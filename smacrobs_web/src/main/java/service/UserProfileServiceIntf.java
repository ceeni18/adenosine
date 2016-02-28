package service;

import java.io.IOException;

import com.web.model.UserProfile;

public interface UserProfileServiceIntf {
	public UserProfile getUserProfileDetails(String accessToken,String refreshToken) throws IOException;
}
