package com.web.utils;

public class Constants {
	static String fitbitOauthResposeType="code";
	static String fitbitOauthClientId="227FN4";
	static String redirectUriFromFitbit="http://localhost:8081/smacrobs/oauthredirect";
	static String fitbitScope="activity%20profile%20settings%20social%20sleep";
	static String fitbitUriForTokens="https://api.fitbit.com/oauth2/token";
	static String minutesAsleepURL ="https://api.fitbit.com/1/user/-/sleep/minutesAsleep/date/";
	static String userProfileURL ="https://api.fitbit.com/1/user/-/profile.json";
	
	public static String getUserProfileURL() {
		return userProfileURL;
	}


	public static String getMinutesAsleepURL() {
		return minutesAsleepURL;
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
