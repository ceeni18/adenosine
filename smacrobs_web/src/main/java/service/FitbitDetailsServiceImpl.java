package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.web.config.Constants;
import com.web.model.ActivityDetails;
import com.web.model.FoodDetails;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.FitbitTokens;
import com.web.model.UserProfile;
import com.web.model.WaterDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public SleepDetails getSleepDetails() {
		String data = ServiceUtils.httpGet(
				Constants.sleepLogURL +
				toDate() +
				Constants.JSON_EXTENSION,
                access_token);
		SleepDetails sleepDetails = ServiceUtils.gson.fromJson(data,
				SleepDetails.class); // gson returns null is json is null
		System.out.println("SLEEP PATTERNS"+sleepDetails);
		if(sleepDetails != null)
			fitbitDetailsRepository.saveSleepData(sleepDetails);
		//logger.debug(sleepDetails.toString());
		return sleepDetails;
	}

	public HeartRateDetails getHeartRateDetails() {
		String data = ServiceUtils.httpGet(Constants.heartRateURL +toDate()+"/1d.json",
                access_token);
		System.out.println("HEART PATTERNS DATA"+data);
		HeartRateDetails heartRateDetails = ServiceUtils.gson.fromJson(data,
				HeartRateDetails.class);
		System.out.println("HEART PATTERNS"+heartRateDetails);
		if(heartRateDetails != null){
			fitbitDetailsRepository.saveHeartRateData(heartRateDetails);
		}
		return heartRateDetails;
	}
	
	public FoodDetails getFoodDetails() {
		String data = ServiceUtils.httpGet(Constants.foodURL+toDate()+Constants.JSON_EXTENSION,
                access_token);
		FoodDetails foodDetails = ServiceUtils.gson.fromJson(data,
				FoodDetails.class);
		System.out.println("FOOD PATTERNS"+foodDetails);
		if(foodDetails != null){
			//TODO: Save
			//fitbitDetailsRepository.saveFoodData(foodDetails);
		}
		return foodDetails;
	}
	
	public ActivityDetails getActivityDetails() {
		String data = ServiceUtils.httpGet(Constants.activityURL+toDate()+Constants.JSON_EXTENSION,
                access_token);
		ActivityDetails activityDetails = ServiceUtils.gson.fromJson(data,
				ActivityDetails.class);
		System.out.println("ACTIVITY PATTERNS"+activityDetails);
		if(activityDetails != null){
			//TODO: Save
			//fitbitDetailsRepository.saveActivityData(foodDetails);
		}
		return activityDetails;
	}
	
	public WaterDetails getWaterDetails() {
		String data = ServiceUtils.httpGet(Constants.waterURL+toDate()+Constants.JSON_EXTENSION,
                access_token);
		WaterDetails waterDetails = ServiceUtils.gson.fromJson(data,
				WaterDetails.class);
		System.out.println("WATER PATTERNS"+waterDetails);
		if(waterDetails != null){
			//TODO: Save
			//fitbitDetailsRepository.saveWaterData(foodDetails);
		}
		return waterDetails;
	}
	
	
	private String toDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());
	}

	
}