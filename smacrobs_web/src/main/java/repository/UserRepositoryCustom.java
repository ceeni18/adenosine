package repository;

import org.springframework.stereotype.Repository;

import com.web.model.User;

@Repository
public interface UserRepositoryCustom{
public void createUser(User user);
public User findUser(String name);
}
	
