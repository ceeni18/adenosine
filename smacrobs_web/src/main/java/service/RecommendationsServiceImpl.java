package service;

import com.web.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import repository.RecommendationsRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by uday on 4/26/16.
 */
@Service("RecommendationsServiceImpl")
public class RecommendationsServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger
            (RecommendationsServiceImpl.class);
    @Autowired RecommendationsRepository recommendationsRepository;
    @Autowired FitbitDetailsServiceIntf fitbitDetailsService;
    @Autowired TiSensorService tiSensorService;

    String userId;
    String todayDate;
    String access_token;
    Recommendations recommendations;
    SleepDetails sleepDetails;
    HeartRateDetails heartRateDetails= null;
    FoodDetails foodDetails;
    ActivityDetails activityDetails;
    WaterDetails waterDetails = null ;
    ActivityGoalDetails activityGoalDetails;
    List<TiSensorTemperature> tiSensorTemperatures;
    List<TiSensorLight> tiSensorLights;
    List<TiSensorHumidity> tiSensorHumidities;
    List<String> disturbedTimeFrames;
    List<SynchronizedData> synchronizedSleepData;
    List<SynchronizedData> synchronizedTemperatureData;

    boolean lowTemperatureHasEffect;
    boolean highTemperatureHasEffect;

    static final String RESTLESS_SLEEP_VALUE = "2";
    static final String AWAKE_SLEEP_VALUE = "3";

    Recommendations defaultRecommendations;
    HashMap<String, List<String>> defaultTopics;
    HashMap<String, List<String>> topics;

    double idealTemperatureLow = 19;
    double idealTemperatureHigh = 25;

    static final int MAXIMUM_RECOMMENDATIONS_PER_TOPIC = 2;

    public void setSessionVariables(HttpSession session){
        this.userId = session.getAttribute("userId").toString();
        this.access_token = session.getAttribute("access_token").toString();
        this.todayDate = session.getAttribute("todayDate").toString();
        fitbitDetailsService.setSessionVariables(session);
        tiSensorService.setSessionVariables(session);
    }

    public void addRecommendationsToModel(ModelAndView mv, Boolean recalculate){
        if(recalculate){
            logger.debug("Recalculation flag is set, building " +
                    "recommendations again now!");
            calculateAndSaveRecommendations();
        }
        recommendations = recommendationsRepository
                .getRecommendations(userId, todayDate);
        if(recommendations == null) {
            logger.debug("No recommendations in database, building now!");
            calculateAndSaveRecommendations();
        }
        //parseAndRecommendationsToModel(mv);
    }

    private void calculateAndSaveRecommendations(){
        //try {
            getDataFromDB();
            classifyFood();
            classifyActivity();
            calculateEffectsOnDisturbedSleepTimeFrames();
            getRecommendations();
            recommendationsRepository.saveRecommendations(recommendations);
        //}catch (Exception e){
        //    logger.warn("Error in getting details from Fitbit"+e.getMessage
            // ());
       // }
    }

    private void classifyFood(){

    }

    private void classifyActivity(){

    }

    private void getRecommendations(){
        recommendations = new Recommendations();
        defaultTopics = defaultRecommendations.getTopics();
        topics = new HashMap<String, List<String>>();
        recommendations.setTopics(topics);
        if(lowTemperatureHasEffect){
            setTopicRecommendations("temperature_low");
        }
    }

    private void setTopicRecommendations(String key){
        List<String> defaultTopicRecommendations = defaultTopics.get(key);
        List<String> topicRecommendations = new ArrayList<String>();
        int[] arr = getRandomNumbers(defaultTopicRecommendations.size());

        for(int i=0; i<arr.length; i++){
            topicRecommendations.add(defaultTopicRecommendations.get(arr[i]));
        }
        topics.put(key, topicRecommendations);
    }

    private int[] getRandomNumbers(int sizeOfTopic){
        int[] randomNumbers = new int[MAXIMUM_RECOMMENDATIONS_PER_TOPIC];
        for(int i = 0; i<MAXIMUM_RECOMMENDATIONS_PER_TOPIC; i++){
            randomNumbers[i] = i;
        }
        return randomNumbers;
    }

    private void calculateEffectsOnDisturbedSleepTimeFrames(){
        for(int i=0; i<synchronizedSleepData.size(); i++){
            SynchronizedData sdmS = synchronizedSleepData.get(i);
            if(sdmS.getValue() == RESTLESS_SLEEP_VALUE ||
                    sdmS.getValue() == AWAKE_SLEEP_VALUE){
                    checkTemperaturesEffect(
                            synchronizedTemperatureData.get(i).getValue());
            }
        }
    }

    private void checkTemperaturesEffect(String temperature){
        double temp = Double.parseDouble(temperature);
        if(!lowTemperatureHasEffect && (temp < idealTemperatureLow)){
            lowTemperatureHasEffect = true;
            return;
        }
        if(!highTemperatureHasEffect && temp > idealTemperatureHigh){
            highTemperatureHasEffect = true;
        }
    }

    private void getDataFromDB(){
        synchronizedSleepData = fitbitDetailsService.getSleepInRequiredFormat();
        heartRateDetails = fitbitDetailsService.getHeartRateDetailsFromDB();
        foodDetails = fitbitDetailsService.getFoodDetailsFromDB();
        activityDetails = fitbitDetailsService.getActivityDetailsFromDB();
        waterDetails = fitbitDetailsService.getWaterDetailsFromDB();
        activityGoalDetails = fitbitDetailsService.getActivityGoalDetailsFromDB();
        synchronizedTemperatureData = tiSensorService
                .getTemperatureInRequiredFormat();
        getDefaultRecommendations();
    }

    private void getDefaultRecommendations(){
        defaultRecommendations = recommendationsRepository.getRecommendations
                ("default", "all");
        logger.debug("Default recommendations from the db are : " + defaultRecommendations);
    }
}
