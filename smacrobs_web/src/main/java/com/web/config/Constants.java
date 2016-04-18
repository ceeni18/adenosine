package com.web.config;

/**
 * Created by uday on 3/24/16.
 */

public class Constants {

    public static final String LOCALHOST = "http://localhost:8080/smacrobs";

    /*
    * Database Constants
    * */
    public static final String DATABASE_NAME;
    public static final String DATABASE_USERNAME;
    public static final String DATABASE_PASSWORD;
    public static final String DATABASE_HOSTNAME;
    public static final int DATABASE_PORT;

    /*
    * FitBit Constants
    * */
    public static final String fitbitOauthResposeType="code";
    public static final String JSON_EXTENSION = ".json";
    public static final String fitbitOauthClientId = "227NJT";
    public static final String appClientIdAndSecrect =
            "MjI3Rk40OjVmNmU0NmI0ZDI5NTZlODAwNTZjYjk3ZGEwYTI3YTZm";
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

    static {
        if(System.getenv("environment") == "production") {
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
