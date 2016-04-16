package service;

import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.FitbitTokens;

import java.io.IOException;

public interface FitbitDetailsServiceIntf {
	void setFitbitTokens(FitbitTokens fitbitTokens);
	SleepDetails getSleepDetails() throws IOException ;
	HeartRateDetails getHeartRateDetails();
}
