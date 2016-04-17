package service;

import com.web.config.Constants;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.FitbitTokens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FitbitDetailsRepositoryIntf;

@Service("FitbitDetailsService")
public class FitbitDetailsServiceImpl implements FitbitDetailsServiceIntf {
	private static final Logger logger = LoggerFactory.getLogger(
											FitbitDetailsServiceImpl.class);

	@Autowired private FitbitDetailsRepositoryIntf fitbitDetailsRepository;
	private String access_token;

	public void setFitbitTokens(FitbitTokens fitbitTokens){
		this.access_token = fitbitTokens.getAccess_token();
	}

	public SleepDetails getSleepDetails() {
		String data = ServiceUtils.httpGet(
				Constants.sleepLogURL +
				"2015-12-19" +
				Constants.JSON_EXTENSION,
                access_token);
		SleepDetails sleepDetails = ServiceUtils.gson.fromJson(data,
				SleepDetails.class); // gson returns null is json is null
		if(sleepDetails != null)
			fitbitDetailsRepository.saveSleepData(sleepDetails);
		logger.debug(sleepDetails.toString());
		return sleepDetails;
	}

	public HeartRateDetails getHeartRateDetails() {
		String data = ServiceUtils.httpGet(Constants.heartRateURL,
                access_token);
		HeartRateDetails heartRateDetails = ServiceUtils.gson.fromJson(data,
				HeartRateDetails.class);
		if(heartRateDetails != null){
			fitbitDetailsRepository.saveHeartRateData(heartRateDetails);
		}
		return heartRateDetails;
	}
}