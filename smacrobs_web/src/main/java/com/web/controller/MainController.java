package com.web.controller;

import ch.qos.logback.classic.LoggerContext;

import com.web.config.Constants;
import com.web.model.ActivityDetails;
import com.web.model.ActivityGoalDetails;
import com.web.model.FoodDetails;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.UserProfile;
import com.web.model.FitbitTokens;
import com.web.model.WaterDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.FitbitDetailsServiceIntf;
import service.FitbitOAuthServiceIntf;
import service.UserProfileServiceIntf;

import java.io.IOException;

/**
 * Created by uday on 4/9/16.
 */

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(
            MainController.class);

    ModelAndView mv;
    UserProfileServiceIntf userProfileService;
    FitbitDetailsServiceIntf fitbitDetailsService;
    FitbitOAuthServiceIntf fitbitOuthService;

    @Autowired
    public MainController(UserProfileServiceIntf userProfileService,
                          FitbitDetailsServiceIntf fitbitDetailsService,
                          FitbitOAuthServiceIntf fitbitOuthService){
        this.userProfileService = userProfileService;
        this.fitbitDetailsService = fitbitDetailsService;
        this.fitbitOuthService = fitbitOuthService;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        System.out.println(lc);
        return new ModelAndView("index");
    }

    @RequestMapping("/oauth")
    public String redirectToFitbit() throws IOException {
        logger.debug("Redirecting to "+getRedirectURL());
        return "redirect:" + getRedirectURL();
    }

    @RequestMapping(Constants.redirectUriFromFitbit)
    public ModelAndView redirectFromFitbit(
            @RequestParam(
            value = "code",
            required = false,
            defaultValue = ""
            ) String response) throws IOException {
        logger.debug("Successfully redirected from Fitbit "+response);
        FitbitTokens fitbitTokens = this.fitbitOuthService.getFitbitTokens(response);
        logger.debug("FitbitTokens are received!");
        
        userProfileService.setFitbitTokens(fitbitTokens);
        UserProfile userProfile = userProfileService.getUserDetails();

        fitbitDetailsService.setFitbitTokens(fitbitTokens);
        
        SleepDetails sleepDetails = fitbitDetailsService.getSleepDetails();
        HeartRateDetails heartRateDetails = fitbitDetailsService.getHeartRateDetails();
        
        FoodDetails foodDetails = fitbitDetailsService.getFoodDetails();
        ActivityDetails activityDetails = fitbitDetailsService.getActivityDetails();
        WaterDetails waterDetails = fitbitDetailsService.getWaterDetails();
        ActivityGoalDetails activityGoalDetails = fitbitDetailsService.getActivityGoalDetails();

        mv = new ModelAndView("dashboard");

        mv.addObject("sleepDetails", sleepDetails);
        
        mv = getHeartRate(mv, heartRateDetails);
        mv = getActivity(mv,activityDetails);
        mv = getFood(mv,foodDetails);
        mv = getWater(mv,waterDetails);
        mv = getUserProfile(mv, userProfile);
        mv = getActivityGoals(mv, activityGoalDetails);
        
        
        return mv;
    }

	private ModelAndView getActivityGoals(ModelAndView modelAndView, ActivityGoalDetails activityGoalDetails) {
		String distance = "0";
		String floor = "0";
		String step = "0";
		String cal = "0";
		
		try {
			distance = activityGoalDetails.getGoals().getDistance();
			floor = activityGoalDetails.getGoals().getFloors();
			step = activityGoalDetails.getGoals().getSteps();
			cal = activityGoalDetails.getGoals().getCaloriesOut();
		}catch(Exception ex) {
			logger.warn(ex.getMessage());
		}
		
		modelAndView.addObject("distanceGoal", Float.parseFloat(distance));
		modelAndView.addObject("floorsGoal", Integer.parseInt(floor));
		modelAndView.addObject("stepsGoal", Integer.parseInt(step));
		modelAndView.addObject("caloriesOutGoal", Integer.parseInt(cal));
		System.out.println(modelAndView.toString());
		return modelAndView;
	}

	private ModelAndView getUserProfile(ModelAndView modelAndView, UserProfile userProfile) {
		String fullName = "0";
		String gender = "0";
		String age = "0";
		String dateOfBirth = "0";
		String weight = "0";
		String weightUnit = "0";
		double height = 0;
		String heightUnit = "0";
		String avatar = "0";
		try {
			fullName = userProfile.getUser().getFullName();
			gender = userProfile.getUser().getGender();
			age = userProfile.getUser().getAge();
			dateOfBirth = userProfile.getUser().getDateOfBirth();
			weight = userProfile.getUser().getWeight();
			weightUnit = userProfile.getUser().getWeightUnit();
			height = Math.round(Double.parseDouble(userProfile.getUser().getHeight()));
			heightUnit = userProfile.getUser().getHeightUnit();
			avatar = userProfile.getUser().getAvatar();
		}catch(Exception ex) {
			logger.warn(ex.getMessage());
		}
		
		modelAndView.addObject("fullName", fullName);
		modelAndView.addObject("gender", gender);
		modelAndView.addObject("age", age);
		modelAndView.addObject("dateOfBirth", dateOfBirth);
		modelAndView.addObject("weight", weight);
		modelAndView.addObject("weightUnit", weightUnit);
		modelAndView.addObject("height", height);
		modelAndView.addObject("heightUnit", heightUnit);
		modelAndView.addObject("avatar", avatar);
		System.out.println(modelAndView.toString());
		return modelAndView;
	}

	private ModelAndView getWater(ModelAndView modelAndView, WaterDetails waterDetails) {
		String water = "0";
		try {
			water = waterDetails.getSummary().getWater();
		}catch(Exception ex) {
			logger.warn(ex.getMessage());
		}
		
		modelAndView.addObject("water", Integer.parseInt(water)/1000);
		System.out.println(modelAndView.toString());
		return modelAndView;
	}

	private ModelAndView getFood(ModelAndView modelAndView, FoodDetails foodDetails) {
		String sodium="0";
		String carbs="0";
		String fats="0";
		String fibre="0";
		String protein="0";
		
		try{
			sodium=foodDetails.getSummary().getSodium();
			carbs=foodDetails.getSummary().getCarbs();
			fats=foodDetails.getSummary().getFat();
			fibre=foodDetails.getSummary().getFiber();
			protein=foodDetails.getSummary().getProtein();
		}
		catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		modelAndView.addObject("sodium", Integer.parseInt(sodium)/1000);
		modelAndView.addObject("carbs", carbs);
		modelAndView.addObject("fats", fats);
		modelAndView.addObject("fibre", fibre);
		modelAndView.addObject("protein", protein);
		System.out.println(modelAndView.toString());
		return modelAndView;
	}

	private ModelAndView getActivity(ModelAndView modelAndView,
			ActivityDetails activityDetails) {
		double distance=0;
		String steps="0";
		String floors="0";
		try{
			steps=activityDetails.getSummary().getSteps();
			floors=activityDetails.getSummary().getFloors();
			for(int i=0;i<activityDetails.getSummary().getDistances().length;i++){
				distance+=Double.parseDouble(activityDetails.getSummary().getDistances()[i].getDistance());
				}
			}
		catch(Exception ex)
		{
			logger.warn(ex.getMessage());
		}
		
		modelAndView.addObject("distance",distance);
		modelAndView.addObject("steps",steps);
		modelAndView.addObject("floors",floors);
		System.out.println(modelAndView.toString());
		
		return modelAndView;
	}

	private ModelAndView getHeartRate(ModelAndView modelAndView, HeartRateDetails heartRateDetails) {
    	
    	String heartRate = "";
    	try{
    		heartRate=heartRateDetails.getActivitiesHeart()[0].getValue().getRestingHeartRate(); 	
    	}
    	catch(Exception ex){
    		logger.warn(ex.getMessage());
    	}
    	modelAndView.addObject("heartRate",heartRate);
		return modelAndView;
	}

	private String getRedirectURL() {
        return "https://www.fitbit.com/oauth2/authorize?" +
                "response_type=" + Constants.fitbitOauthResposeType +
                "&client_id=" + Constants.fitbitOauthClientId +
                "&redirect_uri=" +
                Constants.LOCALHOST + Constants.redirectUriFromFitbit +
                "&scope=" + Constants.fitbitScope +
                "&z=1";
    }
}
