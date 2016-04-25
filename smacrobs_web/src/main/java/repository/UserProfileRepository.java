package repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.web.config.Constants;
import com.web.model.UserProfile;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.model.MappingInstantiationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service("UserProfileRepository")
public class UserProfileRepository implements UserProfileRepositoryIntf {

	private static final Logger logger = LoggerFactory.getLogger(UserProfileRepository.class);

	@Autowired	
	MongoTemplate mongoOperation;

	public void createUser(UserProfile userProfile) {
		logger.info("Saving User Profile details");
		if(FindUser(userProfile.getUser().getUserId())==null)
		 mongoOperation.save(userProfile);		
	}

	public void updateUser(String tisensorId, String userId) {
		
				Query query = new Query();
				query.addCriteria(Criteria.where("user.userId").is(userId));
				UserProfile user = mongoOperation.findOne(query, UserProfile.class, "userProfile");
				user.getUser().setTiSensorId(tisensorId);
				mongoOperation.save(user);	
	}

	public UserProfile FindUser(String userId) {
		UserProfile userProfile1 = null;
		try {
		   userProfile1 = mongoOperation.findOne(new Query()
		               .addCriteria(Criteria.where("user.userId").is(userId)),
		         UserProfile.class, "userProfile");
		}catch (MappingInstantiationException e){
		   logger.error("unable to get data "+e.getMessage());
		}
		return userProfile1;
	}

}
