package service;

import com.web.config.Constants;
import com.web.model.FitbitTokens;
import com.web.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserProfileRepositoryIntf;

@Service("UserProfileService")
public class UserProfileServiceImpl implements UserProfileServiceIntf {
    private static final Logger logger = LoggerFactory.getLogger(UserProfileServiceImpl.class);
    @Autowired
    UserProfileRepositoryIntf userProfileRepository;
    private String access_token;

    public void setFitbitTokens(FitbitTokens fitbitTokens) {
        this.access_token = fitbitTokens.getAccess_token();
    }

    public UserProfile getUserDetails() {
        String data = ServiceUtils.httpGet(Constants.userProfileURL,
                access_token);
        UserProfile userProfileDetails = ServiceUtils.gson.fromJson(data,
                UserProfile.class);
        logger.debug("USER PROFILE PATTERNS :: " + userProfileDetails);

        // just for testing purposes,
        // TODO: remove below three statements before deployment
        UserProfile.User user = userProfileDetails.getUser();
        user.setTiSensorId("REDD");
        userProfileDetails.setUser(user);

        if (userProfileDetails != null) {
            userProfileRepository.createUser(userProfileDetails);
        }
        return userProfileDetails;
    }

    public void UpdateTiSensorId(String tisensorId, String userId) {
        userProfileRepository.updateUser(tisensorId, userId);
    }

    public void UpdateMedicalDetails(String[] medicine,
                                     String userId) {
        userProfileRepository.updateUser(medicine, userId);

    }

    public UserProfile getUserDetailsFromDB(String userId) {
        return userProfileRepository.findUser(userId);
    }

    public boolean ValidateTiSensor(String id) {
        if (id == null || id.equals("")) {
            return false;
        }
        return true;
    }


}
