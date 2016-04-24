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
		mongoOperation.save(userProfile);		
	}

	public void updateUser(String tisensorId, String userId) {
		System.out.println(tisensorId+"............."+userId);
		
				Query query = new Query();
				query.addCriteria(Criteria.where("_id").is("ObjectId(\"571c87dc522676316e8b7c4d\")"));
				
				//TODO: SSR - Query
				//List<UserProfile> user = mongoOperation.find(query, UserProfile.class, "userProfile");

				/*System.out.println(mongoOperation.find(new Query().addCriteria(
			                Criteria.where("user.userId").is(userId)),
			                UserProfile.class,
			                "userProfile"));*/
				 
				//System.out.println("userTest1 - " + user);

				//modify and update with save()
				//user.setTiSensorId(tisensorId);
				//mongoOperation.save(user);
				
				//user = mongoOperation.findOne(query, UserProfile.class, "userProfile");
				//System.out.println(user);
				
				MongoClient client;
				MongoDatabase db;
				MongoCollection coll;
				Bson filter;
				ArrayList<Document> list = new ArrayList<Document>();
				try {
					 client = new MongoClient(Constants.DATABASE_HOSTNAME,Constants.DATABASE_PORT);
					 db = client.getDatabase(Constants.DATABASE_NAME);
					 coll = db.getCollection("userProfile", BsonDocument.class);
					 filter = new Document("user.userId","2YRX98");
					 list = (ArrayList<Document>) coll.find(filter).into(new ArrayList<Document>());
					 System.out.println("........"+list);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	}

}
