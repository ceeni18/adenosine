package service;

import java.io.IOException;

import com.web.model.FitbitTokens;

public interface IFitbitOAuthService {
	public FitbitTokens getFitbitTokens(String authCode) throws IOException;
}
