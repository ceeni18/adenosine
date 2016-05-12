package service;

import com.web.config.Constants;
import com.web.model.*;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import repository.FitbitDetailsRepositoryIntf;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

@Service("FitbitDetailsService")
public class FitbitDetailsServiceImpl implements FitbitDetailsServiceIntf {
    private static final Logger logger = LoggerFactory.getLogger(
            FitbitDetailsServiceImpl.class);

    @Autowired
    FitbitDetailsRepositoryIntf fitbitDetailsRepository;
    @Autowired
    UserProfileServiceIntf userProfileService;

    private String access_token;
    private String userId;
    private String todayDate;
    private String yesterdayDate;

    private String NO_SLEEP_COLOR = "#FFFFFF";
    private String RESTLESS_COLOR = "#3498DB";
    private String SLEEP_COLOR = "#2ECC71";
    private String AWAKE_COLOR = "#9B59B6";

    public void setSessionVariables(HttpSession session) {
        this.userId = session.getAttribute("userId").toString();
        this.access_token = session.getAttribute("access_token").toString();
        this.todayDate = session.getAttribute("todayDate").toString();
        this.yesterdayDate = session.getAttribute("yesterdayDate").toString();
    }

    public SleepDetails getSleepDetails() {
        String data = ServiceUtils.httpGet(
                Constants.sleepLogURL + todayDate
                        + ".json",
                access_token);
        SleepDetails sleepDetails = ServiceUtils.gson.fromJson(data,
                SleepDetails.class); // gson returns null if json is null
        logger.debug("SLEEP PATTERNS :: " + sleepDetails);
        if (sleepDetails != null) {
            sleepDetails.setDate(todayDate);
            sleepDetails.setUserId(userId);
            fitbitDetailsRepository.saveSleepData(sleepDetails);
        }
        return sleepDetails;
    }

    public HeartRateDetails getHeartRateDetails() {
        String data = ServiceUtils.httpGet(Constants.heartRateURL
                        + yesterdayDate + "/1d.json",
                access_token);
        logger.debug("HEART PATTERNS DATA :: " + data);
        HeartRateDetails heartRateDetails = ServiceUtils.gson.fromJson(data,
                HeartRateDetails.class);
        logger.debug("HEART PATTERNS :: " + heartRateDetails);
        if (heartRateDetails != null) {
            heartRateDetails.setDate(yesterdayDate);
            heartRateDetails.setUserId(userId);
            fitbitDetailsRepository.saveHeartRateData(heartRateDetails);
        }
        return heartRateDetails;
    }

    public FoodDetails getFoodDetails() {
        String data = ServiceUtils.httpGet(Constants.foodURL
                        + yesterdayDate + ".json",
                access_token);
        FoodDetails foodDetails = ServiceUtils.gson.fromJson(data,
                FoodDetails.class);
        logger.debug("FOOD PATTERNS :: " + foodDetails);
        if (foodDetails != null) {
            foodDetails.setDate(yesterdayDate);
            foodDetails.setUserId(userId);
            fitbitDetailsRepository.saveFoodData(foodDetails);
        }
        return foodDetails;
    }

    public ActivityDetails getActivityDetails() {
        String data = ServiceUtils.httpGet(Constants.activityURL
                        + yesterdayDate + ".json",
                access_token);
        ActivityDetails activityDetails = ServiceUtils.gson.fromJson(data,
                ActivityDetails.class);
        logger.debug("ACTIVITY PATTERNS :: " + activityDetails);
        if (activityDetails != null) {
            activityDetails.setDate(yesterdayDate);
            activityDetails.setUserId(userId);
            fitbitDetailsRepository.saveActivityData(activityDetails);
        }
        return activityDetails;
    }

    public WaterDetails getWaterDetails() {
        String data = ServiceUtils.httpGet(Constants.waterURL
                        + yesterdayDate + ".json",
                access_token);
        WaterDetails waterDetails = ServiceUtils.gson.fromJson(data,
                WaterDetails.class);
        logger.debug("WATER PATTERNS :: " + waterDetails);
        if (waterDetails != null) {
            waterDetails.setDate(yesterdayDate);
            waterDetails.setUserId(userId);
            fitbitDetailsRepository.saveWaterData(waterDetails);
        }
        return waterDetails;
    }

    public ActivityGoalDetails getActivityGoalDetails() {
        String data = ServiceUtils.httpGet(Constants.activityGoalURL,
                access_token);
        ActivityGoalDetails activityGoalDetails = ServiceUtils.gson.fromJson(data,
                ActivityGoalDetails.class);
        logger.debug("ACTIVITY GOAL PATTERNS :: " + activityGoalDetails);
        if (activityGoalDetails != null) {
            activityGoalDetails.setDate(yesterdayDate);
            activityGoalDetails.setUserId(userId);
            fitbitDetailsRepository.saveActivityGoalData(activityGoalDetails);
        }
        return activityGoalDetails;
    }

    private String getSleepMinuteData(SleepDetails sleepDetails) {
        StringBuffer sb = new StringBuffer();
        String datapointTemplate = "{ y: 2, color: '%%COLOR%%'},";
        sb.append("[");
        List<SynchronizedData> synchronizedSleepData =
                getSleepInRequiredFormat();
        try {
            for (int i = 0; i < synchronizedSleepData.size(); i++) {
                SynchronizedData sleepMinutedata = synchronizedSleepData.get(i);
                sb.append(datapointTemplate.replaceFirst("%%COLOR%%",
                        getSleepColor(sleepMinutedata.getValue())));
            }
        } catch (Exception e) {
            logger.error("Unable to get sleep minute data " + e);
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    private String getSleepColor(String value) {
        if (value == null) return NO_SLEEP_COLOR;
        if (value.equals("1")) return SLEEP_COLOR;
        if (value.equals("2")) return RESTLESS_COLOR;
        if (value.equals("3")) return AWAKE_COLOR;
        return null;
    }

    public void AddSleepToModel(ModelAndView modelAndView) {
        SleepDetails sleepDetails = getSleepDetailsFromDB();
        if (sleepDetails == null) {
            sleepDetails = getSleepDetails();
        }
        int sleepEfficiency = 0;
        int awakeningTime = 0;
        String duration = "0";
        try {
            duration = sleepDetails.getSummary().getTotalTimeInBed();
            SleepDetails.Sleep[] sleep = sleepDetails.getSleep();
            int sleepCount = sleep.length;
            for (int count = 0; count < sleepCount; count++) {
                sleepEfficiency += Integer.parseInt(sleep
                        [count].getEfficiency());
                awakeningTime += Integer.parseInt(
                        sleep[count].getAwakeningsCount());
            }
            if (sleepCount > 0)
                sleepEfficiency = sleepEfficiency / sleepCount;
        } catch (Exception ex) {
            logger.error("Unable to parse efficiency and awakeningTime " + ex);
        }
        long hours = Long.parseLong(duration) / 60;
        long minutes = Long.parseLong(duration) % 60;
        duration = hours + " hr " + minutes + " min";
        modelAndView.addObject("sleepDuration", duration);
        modelAndView.addObject("sleepEfficiency", sleepEfficiency);
        modelAndView.addObject("awakeningTime", awakeningTime);
        modelAndView.addObject("sleepMinuteData",
                getSleepMinuteData(sleepDetails));
        logger.debug(modelAndView.toString());
    }

    public void AddActivityGoalsToModel(ModelAndView modelAndView) {
        ActivityGoalDetails activityGoalDetails = getActivityGoalDetailsFromDB();
        if (activityGoalDetails == null) {
            activityGoalDetails = getActivityGoalDetails();
        }
        String distance = null;
        String floor = null;
        String step = null;
        String cal = null;

		try {
			distance = activityGoalDetails.getGoals().getDistance();
			floor = activityGoalDetails.getGoals().getFloors();
			step = activityGoalDetails.getGoals().getSteps();
			cal = activityGoalDetails.getGoals().getCaloriesOut();
		}catch(Exception ex) {
			logger.error(ExceptionUtils.getFullStackTrace(ex));
		}
		
		modelAndView.addObject("distanceGoal", distance);
		modelAndView.addObject("floorsGoal", floor);
		modelAndView.addObject("stepsGoal", step);
		modelAndView.addObject("caloriesOutGoal", cal);
		
		logger.debug(modelAndView.toString());
	}

    public void AddUserProfileToModel(ModelAndView modelAndView) {
        UserProfile userProfile = userProfileService.getUserDetailsFromDB(userId);
        String fullName = null;
        String gender = null;
        String age = null;
        String dateOfBirth = null;
        String weight = null;
        String weightUnit = null;
        double height = 0.0d;
        String heightUnit = null;
        String avatar = null;
        try {
            fullName = userProfile.getUser().getFullName();
            gender = userProfile.getUser().getGender();
            age = userProfile.getUser().getAge();
            dateOfBirth = userProfile.getUser().getDateOfBirth();
            weight = userProfile.getUser().getWeight();
            weightUnit = userProfile.getUser().getWeightUnit();
            height = Math.round(Double.parseDouble(userProfile.getUser().getHeight()));
            heightUnit = userProfile.getUser().getHeightUnit();
            avatar = userProfile.getUser().getAvatar();
        } catch (Exception ex) {
            logger.error(ExceptionUtils.getFullStackTrace(ex));
        }

        modelAndView.addObject("fullName", fullName);
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("age", age);
        modelAndView.addObject("dateOfBirth", dateOfBirth);
        String wt = weight + " pounds";
        modelAndView.addObject("weight", wt);
        modelAndView.addObject("weightUnit", weightUnit);
        int feet = (int) height / 12;
        int inch = (int) height % 12;
        String ht = feet + " ft " + inch + " in";
        modelAndView.addObject("height", ht);
        modelAndView.addObject("heightUnit", heightUnit);
        modelAndView.addObject("avatar", avatar);
        logger.debug(modelAndView.toString());
    }

    public void AddWaterToModel(ModelAndView modelAndView) {
        WaterDetails waterDetails = getWaterDetailsFromDB();
        if (waterDetails == null) {
            waterDetails = getWaterDetails();
        }
        String water = null;
        try {
            water = waterDetails.getSummary().getWater();
        } catch (Exception ex) {
            logger.error(ExceptionUtils.getFullStackTrace(ex));
        }
        String val = "0 fl.oz.";
        if (water != null) {
            BigDecimal bd = new BigDecimal(Double.parseDouble(water));
            bd = bd.setScale(2, RoundingMode.FLOOR);
            val = bd + " fl.oz.";
        }
        modelAndView.addObject("water", val);
        logger.debug(modelAndView.toString());
    }

    public void AddFoodToModel(ModelAndView modelAndView) {
        FoodDetails foodDetails = getFoodDetailsFromDB();
        if (foodDetails == null) {
            foodDetails = getFoodDetails();
        }
        String carbs = null;
        String fats = null;
        String fibre = null;
        String protein = null;
        String caloriesIn = null;

		try{
			carbs=foodDetails.getSummary().getCarbs();
			fats=foodDetails.getSummary().getFat();
			fibre=foodDetails.getSummary().getFiber();
			protein=foodDetails.getSummary().getProtein();
			caloriesIn=foodDetails.getSummary().getCalories();
		}
		catch(Exception ex){
			logger.error(ExceptionUtils.getFullStackTrace(ex));
		}
		
		modelAndView.addObject("carbs", carbs);
		modelAndView.addObject("fats", fats);
		modelAndView.addObject("fibre", fibre);
		modelAndView.addObject("protein", protein);
		modelAndView.addObject("calIn", caloriesIn);
		logger.debug(modelAndView.toString());
	}

	public void AddActivityDetailsToModel(ModelAndView modelAndView) {
		ActivityDetails activityDetails = getActivityDetailsFromDB();
		if(activityDetails == null){
			activityDetails = getActivityDetails();
		}
		double distance=0.0d;
		String steps=null;
		String floors=null;
		String calOut = null;
		try{
			steps=activityDetails.getSummary().getSteps();
			floors=activityDetails.getSummary().getFloors();
			calOut = activityDetails.getSummary().getCaloriesOut();
			for(int i=0;i<activityDetails.getSummary().getDistances().length;i++){
				if(activityDetails.getSummary().getDistances()[i].getActivity().equalsIgnoreCase("total")) {
					distance = Double.parseDouble(activityDetails.getSummary().getDistances()[i].getDistance());
					break;
				}
			}
		}
		catch(Exception ex)
		{
			logger.error(ExceptionUtils.getFullStackTrace(ex));
		}
		
		modelAndView.addObject("distance",distance);
		modelAndView.addObject("steps",steps);
		modelAndView.addObject("floors",floors);
		modelAndView.addObject("calOut",calOut);
		logger.debug(modelAndView.toString());
	}

    public void AddHeartRateToModel(ModelAndView modelAndView) {
        String heartRate = null;
        HeartRateDetails heartRateDetails = getHeartRateDetailsFromDB();
        if (heartRateDetails == null) {
            heartRateDetails = getHeartRateDetails();
        }
        try {
            heartRate = heartRateDetails.getActivitiesHeart()[0].getValue()
                    .getRestingHeartRate();
        } catch (Exception ex) {
            logger.error(ExceptionUtils.getFullStackTrace(ex));
        }
        modelAndView.addObject("heartRate", heartRate);

        logger.debug(modelAndView.toString());
    }

    public SleepDetails getSleepDetailsFromDB() {
        return fitbitDetailsRepository.findSleepData(userId, todayDate);
    }

    public HeartRateDetails getHeartRateDetailsFromDB() {
        return fitbitDetailsRepository.findHeartRateData(userId, yesterdayDate);
    }

    public FoodDetails getFoodDetailsFromDB() {
        return fitbitDetailsRepository.findFoodData(userId, yesterdayDate);
    }

    public ActivityDetails getActivityDetailsFromDB() {
        return fitbitDetailsRepository.findActivityData(userId, yesterdayDate);
    }

    public WaterDetails getWaterDetailsFromDB() {
        return fitbitDetailsRepository.findWaterData(userId, yesterdayDate);
    }

    public ActivityGoalDetails getActivityGoalDetailsFromDB() {
        return fitbitDetailsRepository.findActivityGoalData(userId, yesterdayDate);
    }

    public List<SynchronizedData>
    getSleepInRequiredFormat() {
        SleepDetails sleepDetails = getSleepDetailsFromDB();
        HashMap<String, String> tempHash = new HashMap<String, String>();

        SleepDetails.Sleep sleep[] = sleepDetails.getSleep();
        for (int i = 0; i < sleep.length; i++) {
            SleepDetails.MinuteData minuteData[] = sleep[i].getMinuteData();
            for (int j = 0; j < minuteData.length; j++) {
                tempHash.put(minuteData[j].getDateTime().substring(0, 5),
                        minuteData[j].getValue());
            }
        }

        List<SynchronizedData> synchronizedSleepData = ServiceUtils
                .getSynchronizedDataList();

        for (SynchronizedData sdm : synchronizedSleepData) {
            if (tempHash.containsKey(sdm.getTime())) {
                sdm.setValue(tempHash.get(sdm.getTime()));
            }
        }

        return synchronizedSleepData;
    }

    public void removeSleepDetailsFromDB() {
        fitbitDetailsRepository.removeSleepData(userId, todayDate);

    }

    public void removeHeartRateDetailsFromDB() {
        fitbitDetailsRepository.removeHeartRateData(userId, yesterdayDate);

    }

    public void removeFoodDetailsFromDB() {
        fitbitDetailsRepository.removeFoodData(userId, yesterdayDate);

    }

    public void removeActivityDetailsFromDB() {
        fitbitDetailsRepository.removeActivityData(userId, yesterdayDate);

    }

    public void removeWaterDetailsFromDB() {
        fitbitDetailsRepository.removeWaterData(userId, yesterdayDate);

    }

    public void removeActivityGoalDetailsFromDB() {
        fitbitDetailsRepository.removeActivityGoalData(userId, yesterdayDate);

    }

}