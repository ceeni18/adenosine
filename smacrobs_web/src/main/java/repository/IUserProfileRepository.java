package repository;


import com.web.model.UserProfile;

public interface IUserProfileRepository {
	public void createUser(UserProfile userProfile);
	public UserProfile findUser(String name);
}
