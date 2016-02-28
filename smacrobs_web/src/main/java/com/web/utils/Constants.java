package com.web.utils;

//TODO: should put these in properties file??
public class Constants {
	static String fitbitOauthResposeType="code";
	static String fitbitOauthClientId="227FN4";
	static String redirectUriFromFitbit="http://localhost:8081/smacrobs/oauthredirect";
	static String fitbitScope="activity%20profile%20settings%20sleep%20heartrate";
	static String fitbitUriForTokens="https://api.fitbit.com/oauth2/token";
	static String sleepLogURL ="https://api.fitbit.com/1/user/-/sleep/date/";
	static String userProfileURL ="https://api.fitbit.com/1/user/-/profile.json";
	public static String JSON_EXTENSION = ".json";
	
	public static String getUserProfileURL() {
		return userProfileURL;
	}

	public static String getSleepLogURL() {
		return sleepLogURL;
	}

	public static String getFitbitUriForTokens() {
		return fitbitUriForTokens;
	}

	public static String getFitbitOauthResposeType() {
		return fitbitOauthResposeType;
	}
	
	public static String getFitbitOauthClientId() {
		return fitbitOauthClientId;
	}
	
	public static String getRedirectUriFromFitbit() {
		return redirectUriFromFitbit;
	}
	
	public static String getFitbitScope() {
		return fitbitScope;
	}
}