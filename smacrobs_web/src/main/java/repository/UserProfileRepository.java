package repository;

import com.web.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service("UserProfileRepository")
public class UserProfileRepository implements UserProfileRepositoryIntf {

	private static final Logger logger = LoggerFactory.getLogger(UserProfileRepository.class);

	@Autowired	
	MongoTemplate mongoOperation;

	public void createUser(UserProfile userProfile) {
		logger.info("Saving User Profile details");
		mongoOperation.save(userProfile);		
	}
}
