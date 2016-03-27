package com.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Constants {
	static String fitbitOauthResposeType="code";
	public static String JSON_EXTENSION = ".json";
	
	String appClientIdAndSecrect;
	String fitbitOauthClientId;	
	String redirectUriFromFitbit;
	String fitbitScope;
	String fitbitUriForTokens;
	String sleepLogURL;
	String userProfileURL;
	String heartRateURL;
	
	
	public  String getUserProfileURL() {
		return userProfileURL;
	}

	public  String getSleepLogURL() {
		return sleepLogURL;
	}

	public  String getFitbitUriForTokens() {
		return fitbitUriForTokens;
	}

	public static String getFitbitOauthResposeType() {
		return fitbitOauthResposeType;
	}
	
	public String getFitbitOauthClientId() {
		return fitbitOauthClientId;
	}
	
	public  String getRedirectUriFromFitbit() {
		return redirectUriFromFitbit;
	}
	
	public  String getFitbitScope() {
		return fitbitScope;
	}

	public void setFitbitOauthClientId(String fitbitOauthClientId) {
		this.fitbitOauthClientId = fitbitOauthClientId;
	}

	public void setRedirectUriFromFitbit(String redirectUriFromFitbit) {
		this.redirectUriFromFitbit = redirectUriFromFitbit;
	}

	public void setFitbitScope(String fitbitScope) {
		this.fitbitScope = fitbitScope;
	}

	public void setFitbitUriForTokens(String fitbitUriForTokens) {
		this.fitbitUriForTokens = fitbitUriForTokens;
	}

	public void setSleepLogURL(String sleepLogURL) {
		this.sleepLogURL = sleepLogURL;
	}

	public void setUserProfileURL(String userProfileURL) {
		this.userProfileURL = userProfileURL;
	}

	public String getHeartRateURL() {
		return heartRateURL;
	}

	public void setHeartRateURL(String heartRateURL) {
		this.heartRateURL = heartRateURL;
	}

	public String getAppClientIdAndSecrect() {
		return appClientIdAndSecrect;
	}

	public void setAppClientIdAndSecrect(String appClientIdAndSecrect) {
		this.appClientIdAndSecrect = appClientIdAndSecrect;
	}
}