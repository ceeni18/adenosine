package repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.web.model.UserProfile;

@Service("UserProfileRepository")
public class UserProfileRepository implements UserProfileRepositoryIntf {

	private static final Logger logger = Logger.getLogger(UserProfileRepository.class);

	@Autowired	
	MongoTemplate mongoOperation;
	
	public void createUser(UserProfile userProfile) {
		logger.debug("saving user profile details");
		mongoOperation.save(userProfile);		
	}


}
