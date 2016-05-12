package com.web.config;

public class Constants {

	public static final String REDIRECT_URL_BASE;
	//public static final String REDIRECT_URL_BASE = "http://localhost:8080";
	
	/*
	 * Database Constants
	 * */
	public static final String DATABASE_NAME;
	public static final String DATABASE_USERNAME;
	public static final String DATABASE_PASSWORD;
	public static final String DATABASE_HOSTNAME;
	public static final int DATABASE_PORT;

	/*
	* TiSensor REST API Constants for com.web.load.SimulateAUserTiSensor
	* */
	public static final String TISENSOR_REST_URL;
	//public static final String TISENSOR_REST_URL="http://localhost:8081/tisensor";

	/*
	 * FitBit Constants
	 * */
	public static final String FITBIT_OAUTH_CLIENT_ID;
	//public static final String FITBIT_OAUTH_CLIENT_ID = "227L87";
	public static final String APP_CLIENT_ID_AND_SECRET;
	//public static final String APP_CLIENT_ID_AND_SECRET = "MjI3TDg3OjgxMDYzNTYyYzdiMzZlZmVjMWYzNGY5Y2FhMmNlNTdk";
	public static final String fitbitAuthUri =
			"https://www.fitbit.com/oauth2/authorize?";
	public static final String redirectUriFromFitbit =
			"/oauthredirect";
	public static final String fitbitScope =
			"activity%20profile%20settings%20sleep%20heartrate%20nutrition%20weight";
	public static final String fitbitUriForTokens =
			"https://api.fitbit.com/oauth2/token";
	public static final String sleepLogURL =
			"https://api.fitbit.com/1/user/-/sleep/date/";
	public static final String userProfileURL=
			"https://api.fitbit.com/1/user/-/profile.json";
	public static final String heartRateURL =
			"https://api.fitbit.com/1/user/-/activities/heart/date/";
	public static final String foodURL =
			"https://api.fitbit.com/1/user/-/foods/log/date/";
	public static final String waterURL =
			"https://api.fitbit.com/1/user/-/foods/log/water/date/";
	public static final String activityURL =
			"https://api.fitbit.com/1/user/-/activities/date/";
	public static final String activityGoalURL =
			"https://api.fitbit.com/1/user/-/activities/goals/daily.json";
	public static final String dateFormat = "yyyy-MM-dd";
	public static final String GMAIL_USERNAME = System.getenv("GMAIL_USERNAME");
	public static final String GMAIL_PASSWORD = System.getenv("GMAIL_PASSWORD");

	
	static {
		if(System.getenv("environment") != null &&
				System.getenv("environment").equals("production")) {
			REDIRECT_URL_BASE = System.getenv("REDIRECT_URL_BASE");
			TISENSOR_REST_URL = System.getenv("TISENSOR_REST_URL");
			FITBIT_OAUTH_CLIENT_ID = System.getenv("FITBIT_OAUTH_CLIENT_ID");
			APP_CLIENT_ID_AND_SECRET = System.getenv("APP_CLIENT_ID_AND_SECRECT");
			DATABASE_NAME      = System.getenv("DATABASE_NAME");
			DATABASE_USERNAME  = System.getenv("DATABASE_USERNAME");
			DATABASE_PASSWORD  = System.getenv("DATABASE_PASSWORD");
			DATABASE_HOSTNAME  = System.getenv("DATABASE_HOSTNAME");
			DATABASE_PORT      = Integer.parseInt(
					System.getenv("DATABASE_PORT"));
		}else {
			DATABASE_NAME      = "mydb";
			DATABASE_USERNAME  = "";
			DATABASE_PASSWORD  = "";
			DATABASE_HOSTNAME  = "localhost";
			DATABASE_PORT      = 27017;
		}
	}
}
