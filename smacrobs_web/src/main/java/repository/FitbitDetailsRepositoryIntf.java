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
}
