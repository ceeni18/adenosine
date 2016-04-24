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
	SleepDetails getSleepDetails() throws IOException ;
	HeartRateDetails getHeartRateDetails();
	FoodDetails getFoodDetails();
	ActivityDetails getActivityDetails();
	WaterDetails getWaterDetails();
	ActivityGoalDetails getActivityGoalDetails();
	
	
	/*SleepDetails getSleepFromDB();
	HeartRateDetails getHeartRateFromDB();
	FoodDetails getFoodFromDB();
	ActivityDetails getActivityFromDB();
	WaterDetails getWaterFromDB();
	ActivityGoalDetails getActivityGoalFromDB();*/
	
	

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
}
