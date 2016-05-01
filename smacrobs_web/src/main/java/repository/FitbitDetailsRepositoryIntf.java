package repository;

import com.web.model.*;

import java.util.List;

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
	List<TiSensorLight> getLightMinuteData(String userId);
	List<TiSensorTemperature> getTemperatureMinuteData(String userId);
	List<TiSensorHumidity> getHumidityMinuteData(String userId);
}
