package com.web.model;

public class FitbitTokens {
	
String accessToken;
String refreshToken;

public FitbitTokens(String at,String rt)
{
	accessToken=at;
	refreshToken=rt;
}

public String getAccessToken() {
	return accessToken;
}

public void setAccessToken(String accessToken) {
	this.accessToken = accessToken;
}

public String getRefreshToken() {
	return refreshToken;
}

public void setRefreshToken(String refreshToken) {
	this.refreshToken = refreshToken;
}
}
