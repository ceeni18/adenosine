package service;

import java.io.IOException;

import com.web.model.UserProfile;

public interface IUserProfileService {
	public UserProfile getUserProfileDetails(String accessToken,String refreshToken) throws IOException;
}
