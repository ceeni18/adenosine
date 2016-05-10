package service;

import com.web.model.FitbitTokens;
import com.web.model.UserProfile;

public interface UserProfileServiceIntf {
	void setFitbitTokens(FitbitTokens fitbitTokens);
	UserProfile getUserDetails();
	void UpdateTiSensorId(String tisensorId, String userId);
	UserProfile getUserDetailsFromDB(String string);
	void UpdateMedicalDetails( String[] medicine,
			String userId);
	boolean ValidateTiSensor(String id);
}
