package repository;

import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service("SleepDetailsRepository")
public class FitbitDetailsRepository implements FitbitDetailsRepositoryIntf {
	private static final Logger logger = LoggerFactory.getLogger(FitbitDetailsRepository.class);
	
	@Autowired	
	MongoTemplate mongoOperation;
	
	public void saveSleepData(SleepDetails sleepDetails) {
		logger.debug("Saving user's sleep details");
		mongoOperation.save(sleepDetails);
	}
	
	public void saveHeartRateData(HeartRateDetails heartRateDetails) {
		logger.debug("Saving user's heart details");
		mongoOperation.save(heartRateDetails);
	}
}
