package repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import service.FitbitDetailsServiceImpl;

import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;

@Service("SleepDetailsRepository")
public class FitbitDetailsRepository implements FitbitDetailsRepositoryIntf {
	private static final Logger logger = Logger.getLogger(FitbitDetailsRepository.class);
	
	@Autowired	
	MongoTemplate mongoOperation;
	
	public void saveSleepData(SleepDetails sleepDetails) {
		logger.debug("saving user's sleep details");
		mongoOperation.save(sleepDetails);
	}
	
	public void saveHeartRateData(HeartRateDetails heartRateDetails) {
		logger.debug("saving user's heart details");
		mongoOperation.save(heartRateDetails);
	}
}
