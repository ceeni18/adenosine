package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.web.config.Constants;
import com.web.model.ActivityDetails;
import com.web.model.ActivityGoalDetails;
import com.web.model.FitbitTokens;
import com.web.model.FoodDetails;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.UserProfile;
import com.web.model.WaterDetails;

import repository.FitbitDetailsRepositoryIntf;

@Service("FitbitDetailsService")
public class FitbitDetailsServiceImpl implements FitbitDetailsServiceIntf {
	private static final Logger logger = LoggerFactory.getLogger(
			FitbitDetailsServiceImpl.class);

	@Autowired private FitbitDetailsRepositoryIntf fitbitDetailsRepository;
	private String access_token;

	public void setFitbitTokens(FitbitTokens fitbitTokens){
		this.access_token = fitbitTokens.getAccess_token();
	}

	public SleepDetails getSleepDetails(String userId) {
		String data = ServiceUtils.httpGet(
				Constants.sleepLogURL + getTodayDate() 
				+ Constants.JSON_EXTENSION,
				access_token);
		SleepDetails sleepDetails = ServiceUtils.gson.fromJson(data,
				SleepDetails.class); // gson returns null is json is null
		logger.debug("SLEEP PATTERNS :: " + sleepDetails);
		if(sleepDetails != null){
			sleepDetails.setDate(getTodayDate());
			sleepDetails.setUserId(userId);
			fitbitDetailsRepository.saveSleepData(sleepDetails);
		}
		return sleepDetails;
	}

	public HeartRateDetails getHeartRateDetails(String userId) {
		String data = ServiceUtils.httpGet(Constants.heartRateURL 
				+getYesterdayDate() +"/1d.json",
				access_token);
		logger.debug("HEART PATTERNS DATA :: " + data);
		HeartRateDetails heartRateDetails = ServiceUtils.gson.fromJson(data,
				HeartRateDetails.class);
		logger.debug("HEART PATTERNS :: " + heartRateDetails);
		if(heartRateDetails != null){
			heartRateDetails.setDate(getYesterdayDate());
			heartRateDetails.setUserId(userId);
			fitbitDetailsRepository.saveHeartRateData(heartRateDetails);
		}
		return heartRateDetails;
	}

	public FoodDetails getFoodDetails(String userId) {
		String data = ServiceUtils.httpGet(Constants.foodURL
				+ getYesterdayDate() + Constants.JSON_EXTENSION,
				access_token);
		FoodDetails foodDetails = ServiceUtils.gson.fromJson(data,
				FoodDetails.class);
		logger.debug("FOOD PATTERNS :: " + foodDetails);
		if(foodDetails != null){ 
			foodDetails.setDate(getYesterdayDate());
			foodDetails.setUserId(userId);
			fitbitDetailsRepository.saveFoodData(foodDetails);
		}
		return foodDetails;
	}

	public ActivityDetails getActivityDetails(String userId) {
		String data = ServiceUtils.httpGet(Constants.activityURL
				+ getYesterdayDate()+ Constants.JSON_EXTENSION,
				access_token);
		ActivityDetails activityDetails = ServiceUtils.gson.fromJson(data,
				ActivityDetails.class);
		logger.debug("ACTIVITY PATTERNS :: " + activityDetails);
		if(activityDetails != null){
			activityDetails.setDate(getYesterdayDate());
			activityDetails.setUserId(userId);
			fitbitDetailsRepository.saveActivityData(activityDetails);
		}
		return activityDetails;
	}

	public WaterDetails getWaterDetails(String userId) {
		String data = ServiceUtils.httpGet(Constants.waterURL 
				+ getYesterdayDate()+ Constants.JSON_EXTENSION,
				access_token);
		WaterDetails waterDetails = ServiceUtils.gson.fromJson(data,
				WaterDetails.class);
		logger.debug("WATER PATTERNS :: " + waterDetails);
		if(waterDetails != null){
			waterDetails.setDate(getYesterdayDate());
			waterDetails.setUserId(userId);
			fitbitDetailsRepository.saveWaterData(waterDetails);
		}
		return waterDetails;
	}

	public ActivityGoalDetails getActivityGoalDetails(String userId) {
		String data = ServiceUtils.httpGet(Constants.activityGoalURL,
				access_token);
		ActivityGoalDetails activityGoalDetails = ServiceUtils.gson.fromJson(data,
				ActivityGoalDetails.class);
		logger.debug("GOAL PATTERNS :: " + activityGoalDetails);
		if(activityGoalDetails != null){
			activityGoalDetails.setDate(getYesterdayDate());
			activityGoalDetails.setUserId(userId);
			fitbitDetailsRepository.saveActivityGoalData(activityGoalDetails);
		}
		return activityGoalDetails;
	}

	private String getYesterdayDate() {
		DateFormat dateFormat = new SimpleDateFormat(Constants.dateFormat);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());
	}
	
	private String getTodayDate() {
		DateFormat dateFormat = new SimpleDateFormat(Constants.dateFormat);
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	public void getSleep(ModelAndView modelAndView, SleepDetails sleepDetails) {
		String duration = null;
		int efficiency = 0;
		int awakeningTime = 0;
		int length = sleepDetails.getSleep().length;
		try {
			duration = sleepDetails.getSummary().getTotalTimeInBed();
			for(int count=0; count< length; count++) {
				efficiency += Integer.parseInt(
						sleepDetails.getSleep()[length]
								.getEfficiency()); 
				awakeningTime += Integer.parseInt(
						sleepDetails.getSleep()[length]
								.getAwakeningsCount());
			}
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		long hours = Long.parseLong(duration)/60;
		long minutes = Long.parseLong(duration)%60;
		duration = hours + " hr " + minutes + " min";
		modelAndView.addObject("sleepDuration", duration);
		modelAndView.addObject("sleepEfficiency", efficiency);
		modelAndView.addObject("awakeningTime", awakeningTime);
		logger.debug(modelAndView.toString());
	}

	public void getActivityGoals(ModelAndView modelAndView, ActivityGoalDetails activityGoalDetails) {
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
			logger.warn(ex.getMessage());
		}

		modelAndView.addObject("distanceGoal", Math.round(Double.parseDouble(distance)));
		modelAndView.addObject("floorsGoal", Integer.parseInt(floor));
		modelAndView.addObject("stepsGoal", Integer.parseInt(step));
		modelAndView.addObject("caloriesOutGoal", Integer.parseInt(cal));
		logger.debug(modelAndView.toString());
	}

	public void getUserProfile(ModelAndView modelAndView, UserProfile userProfile) {
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
		}catch(Exception ex) {
			logger.warn(ex.getMessage());
		}

		modelAndView.addObject("fullName", fullName);
		modelAndView.addObject("gender", gender);
		modelAndView.addObject("age", age);
		modelAndView.addObject("dateOfBirth", dateOfBirth);
		modelAndView.addObject("weight", weight);
		modelAndView.addObject("weightUnit", weightUnit);
		modelAndView.addObject("height", height);
		modelAndView.addObject("heightUnit", heightUnit);
		modelAndView.addObject("avatar", avatar);
		logger.debug(modelAndView.toString());
	}

	public void getWater(ModelAndView modelAndView, WaterDetails waterDetails) {
		String water = null;
		try {
			water = waterDetails.getSummary().getWater();
		}catch(Exception ex) {
			logger.warn(ex.getMessage());
		}
		//BigDecimal bd = new BigDecimal(Double.parseDouble(water));
		//bd = bd.setScale(2, RoundingMode.FLOOR);

		modelAndView.addObject("water", water);
		logger.debug(modelAndView.toString());
	}

	public void getFood(ModelAndView modelAndView, FoodDetails foodDetails) {
		String sodium=null;
		String carbs=null;
		String fats=null;
		String fibre=null;
		String protein=null;
		String caloriesIn=null;

		try{
			sodium=foodDetails.getSummary().getSodium();
			carbs=foodDetails.getSummary().getCarbs();
			fats=foodDetails.getSummary().getFat();
			fibre=foodDetails.getSummary().getFiber();
			protein=foodDetails.getSummary().getProtein();
			caloriesIn=foodDetails.getSummary().getCalories();
		}
		catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		modelAndView.addObject("sodium", sodium);
		modelAndView.addObject("carbs", carbs);
		modelAndView.addObject("fats", fats);
		modelAndView.addObject("fibre", fibre);
		modelAndView.addObject("protein", protein);
		modelAndView.addObject("caloriesIn", caloriesIn);
		logger.debug(modelAndView.toString());
	}

	public void getActivity(ModelAndView modelAndView,
			ActivityDetails activityDetails) {
		double distance=0.0d;
		String steps=null;
		String floors=null;
		try{
			steps=activityDetails.getSummary().getSteps();
			floors=activityDetails.getSummary().getFloors();
			for(int i=0;i<activityDetails.getSummary().getDistances().length;i++){
				distance+=Math.round(
						Double.parseDouble(activityDetails.getSummary().getDistances()[i].getDistance()));
			}
		}
		catch(Exception ex)
		{
			logger.warn(ex.getMessage());
		}

		modelAndView.addObject("distance",distance);
		modelAndView.addObject("steps",steps);
		modelAndView.addObject("floors",floors);
		
		logger.debug(modelAndView.toString());
	}

	public void getHeartRate(ModelAndView modelAndView, HeartRateDetails heartRateDetails) {
		String heartRate = null;
		try {
			heartRate=heartRateDetails.getActivitiesHeart()[0].getValue().getRestingHeartRate();
		}
		catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		modelAndView.addObject("heartRate",heartRate);
		
		logger.debug(modelAndView.toString());
	}

	public SleepDetails getSleepDetailsFromDB(String userId) {
		return fitbitDetailsRepository.findSleepData(userId, getTodayDate());
	}

	public HeartRateDetails getHeartRateDetailsFromDB(String userId) {
		return fitbitDetailsRepository.findHeartRateData(userId, getYesterdayDate());
	}

	public FoodDetails getFoodDetailsFromDB(String userId) {
		return fitbitDetailsRepository.findFoodData(userId, getYesterdayDate());
	}

	public ActivityDetails getActivityDetailsFromDB(String userId) {
		return fitbitDetailsRepository.findActivityData(userId, getYesterdayDate());
	}

	public WaterDetails getWaterDetailsFromDB(String userId) {
		return fitbitDetailsRepository.findWaterData(userId, getYesterdayDate());
	}

	public ActivityGoalDetails getActivityGoalDetailsFromDB(String userId) {
		return fitbitDetailsRepository.findActivityGoalData(userId, getYesterdayDate());
	}

}