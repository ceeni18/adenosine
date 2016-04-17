package repository;

import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;

public interface FitbitDetailsRepositoryIntf {
	void saveSleepData(SleepDetails sleepDetails);
	void saveHeartRateData(HeartRateDetails heartRateDetails);
}
