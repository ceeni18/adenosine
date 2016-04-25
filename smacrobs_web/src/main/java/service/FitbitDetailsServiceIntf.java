package service;

import com.web.model.ActivityDetails;
import com.web.model.ActivityGoalDetails;
import com.web.model.FoodDetails;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.UserProfile;
import com.web.model.FitbitTokens;
import com.web.model.WaterDetails;

import java.io.IOException;

import org.springframework.web.servlet.ModelAndView;

public interface FitbitDetailsServiceIntf {
	void setFitbitTokens(FitbitTokens fitbitTokens);
	SleepDetails getSleepDetails(String userId) throws IOException ;
	HeartRateDetails getHeartRateDetails(String userId);
	FoodDetails getFoodDetails(String userId);
	ActivityDetails getActivityDetails(String userId);
	WaterDetails getWaterDetails(String userId);
	ActivityGoalDetails getActivityGoalDetails(String userId);
	void getHeartRate(ModelAndView modelAndView, 
			HeartRateDetails heartRateDetails);
	void getActivity(ModelAndView modelAndView,
			ActivityDetails activityDetails);
	void getFood(ModelAndView modelAndView, FoodDetails foodDetails);
	void getWater(ModelAndView modelAndView, WaterDetails waterDetails);
	void getUserProfile(ModelAndView modelAndView, UserProfile userProfile);
	void getActivityGoals(ModelAndView modelAndView, 
			ActivityGoalDetails activityGoalDetails);
	void getSleep(ModelAndView modelAndView, SleepDetails sleepDetails);
	SleepDetails getSleepDetailsFromDB(String string);
	HeartRateDetails getHeartRateDetailsFromDB(String string);
	FoodDetails getFoodDetailsFromDB(String string);
	ActivityDetails getActivityDetailsFromDB(String string);
	WaterDetails getWaterDetailsFromDB(String string);
	ActivityGoalDetails getActivityGoalDetailsFromDB(String string);
	
}
