package repository;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.web.model.User;

public class UserRepositoryImpl implements UserRepositoryCustom {

	MongoOperations mongoOperation;
	
	public UserRepositoryImpl(MongoOperations mongoOperation)
	{
		this.mongoOperation = mongoOperation;
	}
	
	public void createUser(User user) {
		System.out.println("saving user");
		mongoOperation.save(user);
		
	}

	public User findUser(String name) {
		return mongoOperation.findOne(new Query(Criteria.where("name").is(name)), User.class);	
	}

}
