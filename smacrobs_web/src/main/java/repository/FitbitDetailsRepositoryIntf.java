package repository;

import com.web.model.ActivityDetails;
import com.web.model.ActivityGoalDetails;
import com.web.model.FoodDetails;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.WaterDetails;

public interface FitbitDetailsRepositoryIntf {
	void saveSleepData(SleepDetails sleepDetails);
	void saveHeartRateData(HeartRateDetails heartRateDetails);
	void saveFoodData(FoodDetails foodDetails);
	void saveActivityData(ActivityDetails activityDetails);
	void saveWaterData(WaterDetails waterDetails);
	void saveActivityGoalData(ActivityGoalDetails activityGoalDetails);
	SleepDetails findSleepData(String userId, String date);
	HeartRateDetails findHeartRateData(String userId, String date);
	FoodDetails findFoodData( String userId, String date);
	ActivityDetails findActivityData(String userId, String date);
	WaterDetails findWaterData(String userId, String date);
	ActivityGoalDetails findActivityGoalData(String userId, String date);
}
