package repository;

import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;

public interface FitbitDetailsRepositoryIntf {
	public void saveSleepData(SleepDetails sleepDetails);
	public void saveHeartRateData(HeartRateDetails heartRateDetails);
}
