package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.web.model.UserProfile;

@Service("UserProfileRepository")
public class UserProfileRepository implements UserProfileRepositoryIntf {

@Autowired	
MongoTemplate mongoOperation;
	
public UserProfileRepository()
{
	
}
	
	public void createUser(UserProfile userProfile) {
		System.out.println("saving user profile details");
		mongoOperation.save(userProfile);		
	}

	//TODO: Need to query based on the ID
	public UserProfile findUser(String name) {
		return mongoOperation.findOne(new Query(Criteria.where("name").is(name)), UserProfile.class);	
	}
}
