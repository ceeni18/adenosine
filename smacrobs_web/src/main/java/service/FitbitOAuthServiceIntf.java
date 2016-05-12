package service;

import com.web.model.FitbitTokens;

public interface FitbitOAuthServiceIntf {
    FitbitTokens getFitbitTokens(String authCode);
}
