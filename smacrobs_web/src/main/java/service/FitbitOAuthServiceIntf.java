package service;

import java.io.IOException;

import com.web.model.FitbitTokens;

public interface FitbitOAuthServiceIntf {
	public FitbitTokens getFitbitTokens(String authCode) throws IOException;
}
