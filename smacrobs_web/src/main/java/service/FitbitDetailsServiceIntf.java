package service;

import com.web.model.ActivityDetails;
import com.web.model.ActivityGoalDetails;
import com.web.model.FoodDetails;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.FitbitTokens;
import com.web.model.WaterDetails;

import java.io.IOException;

public interface FitbitDetailsServiceIntf {
	void setFitbitTokens(FitbitTokens fitbitTokens);
	SleepDetails getSleepDetails() throws IOException ;
	HeartRateDetails getHeartRateDetails();
	FoodDetails getFoodDetails();
	ActivityDetails getActivityDetails();
	WaterDetails getWaterDetails();
	ActivityGoalDetails getActivityGoalDetails();
}
