package repository;

import com.web.model.ActivityDetails;
import com.web.model.ActivityGoalDetails;
import com.web.model.FoodDetails;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.WaterDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service("FitbitDetailsRepository")
public class FitbitDetailsRepository implements FitbitDetailsRepositoryIntf {
	private static final Logger logger = LoggerFactory.getLogger(FitbitDetailsRepository.class);

	@Autowired	
	MongoTemplate mongoOperation;

	public void saveSleepData(SleepDetails sleepDetails) {
		logger.info("Saving user's sleep details");
		mongoOperation.save(sleepDetails);
	}

	public void saveHeartRateData(HeartRateDetails heartRateDetails) {
		logger.info("Saving user's heart details");
		mongoOperation.save(heartRateDetails);
	}

	public void saveFoodData(FoodDetails foodDetails) {
		logger.info("Saving user's food details");
		mongoOperation.save(foodDetails);
	}

	public void saveActivityData(ActivityDetails activityDetails) {
		logger.info("Saving user's activity details");
		mongoOperation.save(activityDetails);
	}

	public void saveWaterData(WaterDetails waterDetails) {
		logger.info("Saving user's water details");
		mongoOperation.save(waterDetails);

	}

	public void saveActivityGoalData(ActivityGoalDetails activityGoalDetails) {
		logger.info("Saving user's activity goal details");
		mongoOperation.save(activityGoalDetails);

	}
}
