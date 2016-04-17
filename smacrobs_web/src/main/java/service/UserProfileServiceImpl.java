package service;

import com.web.config.Constants;
import com.web.model.UserProfile;
import com.web.model.FitbitTokens;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserProfileRepositoryIntf;

@Service("UserProfileService")
public class UserProfileServiceImpl implements UserProfileServiceIntf {
	private static final Logger logger = LoggerFactory.getLogger(UserProfileServiceImpl.class);
	private String access_token;
	@Autowired private UserProfileRepositoryIntf userProfileRepository;

	public void setFitbitTokens(FitbitTokens fitbitTokens){
		this.access_token = fitbitTokens.getAccess_token();
	}
	
	public UserProfile getUserProfileDetails() {
		String data = ServiceUtils.httpGet(Constants.userProfileURL,
                access_token);
		String user = new JSONObject(data).get("user").toString();
		UserProfile userProfile = ServiceUtils.gson.fromJson(user,
				UserProfile.class);
		logger.debug(userProfile.toString());
		this.userProfileRepository.createUser(userProfile);
		return userProfile;
	}
}
