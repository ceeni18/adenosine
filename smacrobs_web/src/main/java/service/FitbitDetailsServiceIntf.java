package service;

import java.io.IOException;

import com.web.model.SleepDetails;

public interface FitbitDetailsServiceIntf {
	public SleepDetails getSleepDetails(String accessToken, String refreshToken)
			throws IOException ;
}
