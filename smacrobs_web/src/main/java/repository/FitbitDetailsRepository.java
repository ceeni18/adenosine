package repository;

import com.web.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.model.MappingInstantiationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FitbitDetailsRepository")
public class FitbitDetailsRepository implements FitbitDetailsRepositoryIntf {
	private static final Logger logger = LoggerFactory.getLogger(FitbitDetailsRepository.class);

	@Autowired
	MongoTemplate mongoOperation;

	public void saveSleepData(SleepDetails sleepDetails) {
		logger.info("Saving user's sleep details");
		if (findSleepData(sleepDetails.getUserId(), sleepDetails.getDate()) == null)
			mongoOperation.save(sleepDetails);
	}

	public void saveHeartRateData(HeartRateDetails heartRateDetails) {
		logger.info("Saving user's heart details");
		if (findHeartRateData(heartRateDetails.getUserId(), heartRateDetails.getDate()) == null)
			mongoOperation.save(heartRateDetails);
	}

	public void saveFoodData(FoodDetails foodDetails) {
		logger.info("Saving user's food details");
		if (findFoodData(foodDetails.getUserId(), foodDetails.getDate()) == null)
			mongoOperation.save(foodDetails);
	}

	public void saveActivityData(ActivityDetails activityDetails) {
		logger.info("Saving user's activity details");
		if (findActivityData(activityDetails.getUserId(), activityDetails.getDate()) == null)
			mongoOperation.save(activityDetails);
	}

	public void saveWaterData(WaterDetails waterDetails) {
		logger.info("Saving user's water details");
		if (findWaterData(waterDetails.getUserId(), waterDetails.getDate()) == null)
			mongoOperation.save(waterDetails);
	}

	public void saveActivityGoalData(ActivityGoalDetails activityGoalDetails) {
		logger.info("Saving user's activity goal details");
		if (findActivityGoalData(activityGoalDetails.getUserId(), activityGoalDetails.getDate()) == null)
			mongoOperation.save(activityGoalDetails);
	}

	public List<TiSensorLight> getLightMinuteData(String userId) {
		List<TiSensorLight> tiSensorLights = mongoOperation.find(new Query()
				.addCriteria(Criteria.where("userId")
						.is(userId)), TiSensorLight.class, "tiSensorLight");
		return tiSensorLights;
	}

	public SleepDetails findSleepData(String userId, String date) {
		SleepDetails sleepDetails = null;
		try {
			sleepDetails = mongoOperation.findOne(new Query()
							.addCriteria(Criteria.where("userId")
									.is(userId)
									.andOperator(Criteria.where("date").is(date))),
					SleepDetails.class, "sleepDetails");
		} catch (MappingInstantiationException e) {
			logger.error("unable to get data " + e.getMessage());
		}
		return sleepDetails;
	}


	public HeartRateDetails findHeartRateData(String userId, String date) {
		HeartRateDetails heartDetails = null;
		try {
			heartDetails = mongoOperation.findOne(new Query()
							.addCriteria(Criteria.where("userId")
									.is(userId)
									.andOperator(Criteria.where("date").is(date))),
					HeartRateDetails.class, "heartRateDetails");
		} catch (MappingInstantiationException e) {
			logger.error("unable to get data " + e.getMessage());
		}
		return heartDetails;
	}

	public FoodDetails findFoodData(String userId, String date) {
		FoodDetails foodDetails = null;
		try {
			foodDetails = mongoOperation.findOne(new Query()
							.addCriteria(Criteria.where("userId")
									.is(userId)
									.andOperator(Criteria.where("date").is(date))),
					FoodDetails.class, "foodDetails");
		} catch (MappingInstantiationException e) {
			logger.error("unable to get data " + e.getMessage());
		}
		return foodDetails;
	}

	public ActivityDetails findActivityData(String userId, String date) {
		ActivityDetails activityDetails = null;
		try {
			activityDetails = mongoOperation.findOne(new Query()
							.addCriteria(Criteria.where("userId")
									.is(userId)
									.andOperator(Criteria.where("date").is(date))),
					ActivityDetails.class, "activityDetails");
		} catch (MappingInstantiationException e) {
			logger.error("unable to get data " + e.getMessage());
		}
		return activityDetails;
	}

	public WaterDetails findWaterData(String userId, String date) {
		WaterDetails waterDetails = null;
		try {
			waterDetails = mongoOperation.findOne(new Query()
							.addCriteria(Criteria.where("userId")
									.is(userId)
									.andOperator(Criteria.where("date").is(date))),
					WaterDetails.class, "waterDetails");
		} catch (MappingInstantiationException e) {
			logger.error("unable to get data " + e.getMessage());
		}
		return waterDetails;
	}

	public ActivityGoalDetails findActivityGoalData(String userId, String date) {
		ActivityGoalDetails activityGoalDetails = null;
		try {
			activityGoalDetails = mongoOperation.findOne(
					new Query().addCriteria(Criteria.where("userId").is(userId)
									.andOperator(Criteria.where("date").is(date))),
					ActivityGoalDetails.class, "activityGoalDetails");
		} catch (MappingInstantiationException e) {
			logger.error("unable to get data " + e.getMessage());
		}
		return activityGoalDetails;
	}

	public List<TiSensorTemperature> getTemperatureMinuteData (String
	userId){
		List<TiSensorTemperature> tiSensorTemperatures = mongoOperation.find(new Query()
				.addCriteria(Criteria.where("userId")
						.is(userId)), TiSensorTemperature.class, "tiSensorLight");
		return tiSensorTemperatures;
	}

	public List<TiSensorHumidity> getHumidityMinuteData (String userId){
		List<TiSensorHumidity> tiSensorHumidities = mongoOperation.find(new Query()
				.addCriteria(Criteria.where("userId")
						.is(userId)), TiSensorHumidity.class, "tiSensorLight");
		return tiSensorHumidities;

	}
	
	public void removeWaterData(String userId, String date) {
		mongoOperation.remove(new Query().addCriteria(Criteria
				.where("userId").is(userId).and("date").is(date)), WaterDetails.class);
		
	}

	public void removeSleepData(String userId, String date) {
		mongoOperation.remove(new Query().addCriteria(Criteria
				.where("userId").is(userId).and("date").is(date)), SleepDetails.class);
		
	}

	public void removeHeartRateData(String userId, String date) {
		mongoOperation.remove(new Query().addCriteria(Criteria
				.where("userId").is(userId).and("date").is(date)), HeartRateDetails.class);
		
	}

	public void removeFoodData(String userId, String date) {
		mongoOperation.remove(new Query().addCriteria(Criteria
				.where("userId").is(userId).and("date").is(date)), FoodDetails.class);
		
	}

	public void removeActivityData(String userId, String date) {
		mongoOperation.remove(new Query().addCriteria(Criteria
				.where("userId").is(userId).and("date").is(date)), ActivityDetails.class);
		
	}

	public void removeActivityGoalData(String userId, String date) {
		mongoOperation.remove(new Query().addCriteria(Criteria
				.where("userId").is(userId).and("date").is(date)), ActivityGoalDetails.class);
		
	}

}
