package repository;

import com.web.model.UserProfile;

public interface UserProfileRepositoryIntf {
	void createUser(UserProfile userProfile);
	void updateUser(String tisensorId, String userId);
	UserProfile findUser(String userId);
	void updateUser(String[] medicine, String userId);
}
