package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.web.model.SleepDetails;

@Service("SleepDetailsRepository")
public class FitbitDetailsRepository implements FitbitDetailsRepositoryIntf {

	@Autowired	
	MongoTemplate mongoOperation;

	public FitbitDetailsRepository()
	{

	}
	
	public void saveSleepData(SleepDetails sleepDetails) {
		System.out.println("saving user's sleep details");
		mongoOperation.save(sleepDetails);
	}
}
