package service;

import com.web.model.UserProfile;
import com.web.model.FitbitTokens;

public interface UserProfileServiceIntf {
	void setFitbitTokens(FitbitTokens fitbitTokens);
	UserProfile getUserDetails();
	void UpdateTiSensorId(String tisensorId, String userId);
}
