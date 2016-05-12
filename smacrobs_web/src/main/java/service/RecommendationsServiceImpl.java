package service;

import com.web.model.*;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import repository.RecommendationsRepository;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by uday on 4/26/16.
 */
@Service("RecommendationsServiceImpl")
public class RecommendationsServiceImpl {
    static final String RESTLESS_SLEEP_VALUE = "2";
    static final String AWAKE_SLEEP_VALUE = "3";
    static final int MAXIMUM_RECOMMENDATIONS_PER_TOPIC = 2;
    static final int MAXIMUM_FACTS = 3;
    private static final Logger logger = LoggerFactory
            .getLogger(RecommendationsServiceImpl.class);
    @Autowired
    RecommendationsRepository recommendationsRepository;
    @Autowired
    FitbitDetailsServiceIntf fitbitDetailsService;
    @Autowired
    TiSensorService tiSensorService;
    @Autowired
    UserProfileServiceImpl userProfileService;
    String userId;
    String todayDate;
    String access_token;
    Recommendations recommendations;
    HeartRateDetails heartRateDetails = null;
    FoodDetails foodDetails;
    ActivityDetails activityDetails;
    WaterDetails waterDetails = null;
    ActivityGoalDetails activityGoalDetails;
    List<SynchronizedData> synchronizedSleepData;
    List<SynchronizedData> synchronizedTemperatureData;
    List<SynchronizedData> synchronizedLightData;
    List<SynchronizedData> synchronizedHumidityData;
    List<String> foodsConsumed;
    String[] medicines;
    boolean lowTemperatureHasEffect = false;
    boolean highTemperatureHasEffect = false;
    boolean lightHasEffect = false;
    boolean lowHumidityHasEffect = false;
    boolean highHumidityHasEffect = false;
    boolean fairlyActive = false;
    Recommendations defaultRecommendations;
    HashMap<String, List<String>> defaultTopics;
    HashMap<String, List<String>> topics;
    IdealValues idealValues = null;

    public void setSessionVariables(HttpSession session) {
        this.userId = session.getAttribute("userId").toString();
        this.access_token = session.getAttribute("access_token").toString();
        this.todayDate = session.getAttribute("todayDate").toString();
        fitbitDetailsService.setSessionVariables(session);
        tiSensorService.setSessionVariables(session);
    }

    public void addRecommendationsToModel(ModelAndView mv) {
        recommendations = recommendationsRepository.getRecommendations(userId,
                todayDate);
        if (recommendations == null || recommendations.getTopics().isEmpty()) {
            logger.info("No recommendations in database, building now!");
            calculateAndSaveRecommendations();
        }

        List<String> recommendationsForModel = new ArrayList<String>();
        List<String> factsForModel = new ArrayList<String>();
        String NO_RECOMMENDATIONS_MESSAGE = "The data you have provided is "
                + "very limited!";
        if (recommendations != null && !recommendations.getTopics().isEmpty()) {
            try {
                Iterator it = recommendations.getTopics().entrySet().iterator();
                List<String> modelListRef;
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (entry.getKey().equals("facts"))
                        modelListRef = factsForModel;
                    else
                        modelListRef = recommendationsForModel;
                    List<String> topic = (List<String>) entry.getValue();
                    for (int i = 0; i < topic.size(); i++) {
                        modelListRef.add(topic.get(i));
                    }
                }
            } catch (Exception e) {
                logger.error("Unable to add recommendations/facts to model "
                        + e);
            }
        }
        if (recommendationsForModel.isEmpty()) {
            recommendationsForModel.add(NO_RECOMMENDATIONS_MESSAGE);
        }
        if (factsForModel.isEmpty()) {
            factsForModel.add("Something went wrong! please reload "
                    + "recommendations or report this " + "error");
        }
        mv.addObject("recommendations", recommendationsForModel);
        mv.addObject("recommendationFacts", factsForModel);
    }

    private void calculateAndSaveRecommendations() {
        getDataFromDB();
        try {
            idealValues = recommendationsRepository.getIdealValues();
            classifyFood();
            classifyActivity();
            classifyMedicine();
            calculateEffectsOnDisturbedSleepTimeFrames();
            calculateRecommendations();
        } catch (Exception e) {
            logger.error("Error in generating recommendations"
                    + ExceptionUtils.getFullStackTrace(e));
        }
        saveRecommendations();
    }

    private void saveRecommendations() {
        try {
            recommendationsRepository.saveRecommendations(recommendations);
        } catch (Exception e) {
            logger.error("Error in saving recommendations to database"
                    + e.getStackTrace());
        }
    }

    private void classifyMedicine() {
        try {
            medicines = userProfileService
                    .getUserDetailsFromDB(this.userId)
                    .getUser()
                    .getMedicines();
        } catch (Exception e) {
            logger.error("Unable to classify medicine " +
                    ExceptionUtils.getFullStackTrace(e));
        }
    }

    private void classifyFood() {
        if (foodDetails == null || foodDetails.getFoods() == null
                || foodDetails.getSummary() == null) {
            return;
        }
        foodsConsumed = new ArrayList<String>();
        try {
            for (int i = 0; i < foodDetails.getFoods().length; i++) {
                FoodDetails.Foods food = foodDetails.getFoods()[i];
                String items;
                items = food.getLoggedFood().getName();
                for (int j = 0; j < idealValues.getFoodsInDB().length; j++) {
                    if (items.contains(idealValues.getFoodsInDB()[j])) {
                        foodsConsumed.add(idealValues.getFoodsInDB()[j]);
                    }
                }
            }
            FoodDetails.Summary foodSummary = foodDetails.getSummary();

            parseAndAddFood("carbs", foodSummary.getCarbs());
            parseAndAddFood("protein", foodSummary.getProtein());
            parseAndAddFood("fat", foodSummary.getFat());
            parseAndAddFood("fiber", foodSummary.getFiber());
            parseAndAddFood("water", foodSummary.getWater());
        } catch (Exception e) {
            logger.error("Unable to parse food data"
                    + ExceptionUtils.getFullStackTrace(e));
        }
    }

    private void parseAndAddFood(String food, String value) {
        Double foodConsumptionValue = Double.parseDouble(value);
        if (foodConsumptionValue > 0)
            foodsConsumed.add(food);
    }

    private void classifyActivity() {
        try {
            Double fairlyActiveMinutes = Double.parseDouble(activityDetails
                    .getSummary().getFairlyActiveMinutes());
            if (fairlyActiveMinutes > idealValues.getIdealFairlyActiveMinutes()) {
                fairlyActive = true;
            }
        } catch (Exception e) {
            logger.error("Unable to parse activity data for recommendations"
                    + e);
        }
    }

    private void calculateRecommendations() {
        recommendations = new Recommendations();
        defaultTopics = defaultRecommendations.getTopics();
        topics = new HashMap<String, List<String>>();
        recommendations.setTopics(topics);
        recommendations.setUserId(userId);
        recommendations.setDate(todayDate);
        setTemperatureRecommendations();
        setLightRecommendations();
        setHumidityRecommendations();
        setFoodRecommendations();
        setActivityRecommendations();
        setMedicineRecommendations();
        setFacts();
    }

    private void setMedicineRecommendations() {
        for (int i = 0; i < medicines.length; i++) {
            setTopicRecommendations("medicine_" + medicines[i]);
        }
    }

    private void setFacts() {
        setTopicRecommendations("facts");
    }

    private void setActivityRecommendations() {
        if (fairlyActive)
            setTopicRecommendations("activity");
    }

    private void setFoodRecommendations() {
        String key = null;
        if (foodsConsumed != null || foodsConsumed.size() != 0) {
            for (int i = 0; i < foodsConsumed.size(); i++) {
                setTopicRecommendations("food_" + foodsConsumed.get(i));
            }
        }
    }

    private void setHumidityRecommendations() {
        String key = null;
        if (lowHumidityHasEffect)
            key = "humidity_low";
        else if (highHumidityHasEffect)
            key = "humidity_high";
        else
            return;
        setTopicRecommendations(key);
    }

    private void setLightRecommendations() {
        if (lightHasEffect)
            setTopicRecommendations("light");
        return;
    }

    private void setTemperatureRecommendations() {
        String key = null;
        if (lowTemperatureHasEffect)
            key = "temperature_low";
        else if (highTemperatureHasEffect)
            key = "temperature_high";
        else
            return;
        setTopicRecommendations(key);
    }

    private void setTopicRecommendations(String key) {
        List<String> defaultTopicRecommendations;
        if (defaultTopics.containsKey(key))
            defaultTopicRecommendations = defaultTopics.get(key);
        else {
            logger.warn("No recommendations found for topic " + key);
            return;
        }
        List<String> topicRecommendations = new ArrayList<String>();
        int recommendationsPerTopic = MAXIMUM_RECOMMENDATIONS_PER_TOPIC;
        if (defaultTopicRecommendations.size() < recommendationsPerTopic) {
            recommendationsPerTopic = defaultTopicRecommendations.size();
        }
        int[] randomNumbers = getRandomNumbers(defaultTopicRecommendations
                .size());

        for (int i = 0; i < recommendationsPerTopic; i++) {
            topicRecommendations.add(defaultTopicRecommendations
                    .get(randomNumbers[i]));
        }
        logger.debug("Recommendations set for topic '" + key + "' are: "
                + topicRecommendations);
        topics.put(key, topicRecommendations);
    }

    private int[] getRandomNumbers(int sizeOfTopic) {
        int[] randomNumbers = new int[sizeOfTopic];
        for (int i = 0; i < sizeOfTopic; i++) {
            randomNumbers[i] = i;
        }
        Collections.shuffle(Arrays.asList(randomNumbers));
        return randomNumbers;
    }

    private void calculateEffectsOnDisturbedSleepTimeFrames() {
        for (int i = 0; i < synchronizedSleepData.size(); i++) {
            SynchronizedData sdmS = synchronizedSleepData.get(i);
            if (sdmS.getValue() != null
                    && (sdmS.getValue().equals(RESTLESS_SLEEP_VALUE) || sdmS
                    .getValue().equals(AWAKE_SLEEP_VALUE))) {
                if (!(lowTemperatureHasEffect || highTemperatureHasEffect)) {
                    checkTemperaturesEffect(synchronizedTemperatureData.get(i)
                            .getValue());
                }
                if (!lightHasEffect) {
                    checkLightEffect(synchronizedLightData.get(i).getValue());
                }
                if (!(lowHumidityHasEffect || highHumidityHasEffect)) {
                    checkHumidityEffect(synchronizedHumidityData.get(i)
                            .getValue());
                }
            }
        }
    }

    private void checkTemperaturesEffect(String temperature) {
        if (temperature == null) {
            return;
        }
        double temp = Double.parseDouble(temperature);
        if (temp < idealValues.getIdealTemperatureLow()) {
            lowTemperatureHasEffect = true;
            return;
        }
        if (temp > idealValues.getIdealTemperatureHigh()) {
            highTemperatureHasEffect = true;
        }
    }

    private void checkLightEffect(String light) {
        if (light == null) {
            return;
        }
        Double lightValue = Double.parseDouble(light);
        if (lightValue > idealValues.getIdealLightValue()) {
            lightHasEffect = true;
        }
    }

    private void checkHumidityEffect(String humidity) {
        if (humidity == null) {
            return;
        }
        Double humidityValue = Double.parseDouble(humidity);
        if (humidityValue < idealValues.getIdealHumidityLow()) {
            lowHumidityHasEffect = true;
            return;
        }
        if (humidityValue > idealValues.getIdealHumidityHigh()) {
            highHumidityHasEffect = true;
        }
    }

    private void getDataFromDB() {
        try {
            synchronizedSleepData = fitbitDetailsService
                    .getSleepInRequiredFormat();
            heartRateDetails = fitbitDetailsService.getHeartRateDetailsFromDB();
            foodDetails = fitbitDetailsService.getFoodDetailsFromDB();
            activityDetails = fitbitDetailsService.getActivityDetailsFromDB();
            waterDetails = fitbitDetailsService.getWaterDetailsFromDB();
            activityGoalDetails = fitbitDetailsService
                    .getActivityGoalDetailsFromDB();
            synchronizedTemperatureData = tiSensorService
                    .getTemperatureInRequiredFormat();
            synchronizedLightData = tiSensorService.getLightInRequiredFormat();
            synchronizedHumidityData = tiSensorService
                    .getHumidityInRequiredFormat();
            getDefaultRecommendations();
        } catch (Exception e) {
            logger.error("Error in getting data for generating "
                    + "recommendations " + e.getStackTrace());
        }
    }

    private void getDefaultRecommendations() {
        defaultRecommendations = recommendationsRepository.getRecommendations(
                "default", "all");
    }

    public void removeRecommendationsFromDB() {
        recommendationsRepository.removeRecommendations(userId, todayDate);
    }

    public void addMedicinesToModel(ModelAndView mv) {
        mv.addObject("medicines", getMedicines());
    }

    public ArrayList<String> getMedicines() {
        Medicine medicine = recommendationsRepository.getMedicines();
        ArrayList<String> medicines;
        medicines = new ArrayList<String>(
                Arrays.asList(medicine.getMedicines()));
        return medicines;

    }

    public boolean ValidateMedicine(String[] medicines) {
        boolean isValidMedicine = false;
        for (int i = 0; i < medicines.length; i++) {
            if (getMedicines().contains(medicines[i])) {
                isValidMedicine = true;
            }
        }
        return isValidMedicine;
    }
}
