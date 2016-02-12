package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.web.model.User;
import repository.UserRepositoryImpl;

@Service("UserService")
public class UserService {

	UserRepositoryImpl userRepository;
	public UserService(MongoOperations mongoOperation)
	{
		
		userRepository=new UserRepositoryImpl(mongoOperation);
	}
	
	public void createUser(User user)
	{
		userRepository.createUser(user);
	}
	
	public User findUser(String name)
	{
		return userRepository.findUser(name);
	}
}
