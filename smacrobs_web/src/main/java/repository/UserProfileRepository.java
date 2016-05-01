package repository;

import com.web.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.model.MappingInstantiationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


@Service("UserProfileRepository")
public class UserProfileRepository implements UserProfileRepositoryIntf {

	private static final Logger logger = LoggerFactory.getLogger(UserProfileRepository.class);

	@Autowired
	MongoTemplate mongoOperation;

	public void createUser(UserProfile userProfile) {
		if(findUser(userProfile.getUser().getUserId())==null) {
			logger.info("Saving User Profile details");
			mongoOperation.save(userProfile);
		}
	}

	public void updateUser(String tisensorId, String userId) {
		
				Query query = new Query();
				query.addCriteria(Criteria.where("user.userId").is(userId));
				UserProfile user = mongoOperation.findOne(query, UserProfile.class, "userProfile");
				user.getUser().setTiSensorId(tisensorId);
				mongoOperation.save(user);	
	}

	public UserProfile findUser(String userId) {
		UserProfile userProfile = null;
		try {
			userProfile = mongoOperation.findOne(new Query()
							.addCriteria(Criteria.where("user.userId").is(userId)),
					UserProfile.class, "userProfile");
		}catch (MappingInstantiationException e){
			logger.error("unable to get data "+e.getMessage());
		}
		return userProfile;
	}
}
