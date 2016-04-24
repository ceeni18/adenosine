package com.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.config.Constants;
import com.web.model.ActivityDetails;
import com.web.model.ActivityGoalDetails;
import com.web.model.FitbitTokens;
import com.web.model.FoodDetails;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.UserProfile;
import com.web.model.WaterDetails;

import ch.qos.logback.classic.LoggerContext;
import service.FitbitDetailsServiceImpl;
import service.FitbitDetailsServiceIntf;
import service.FitbitOAuthServiceIntf;
import service.UserProfileServiceIntf;

import java.io.IOException;

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
		logger.debug(lc.toString());
		return new ModelAndView("index");
	}

	@RequestMapping("/oauth")
	public String redirectToFitbit() throws IOException {
		logger.debug("Redirecting to " + getRedirectURL());
		return "redirect:" + getRedirectURL();
	}

	@RequestMapping("/contact")
	public ModelAndView redirectToContact() throws IOException {
		return new ModelAndView("contact");
	}

	@RequestMapping("/senso")
	public ModelAndView redirectToSensor() throws IOException {
		return new ModelAndView("senso");
	}

	@RequestMapping("/fitbit")
	public ModelAndView redirectToFit() throws IOException {
		return new ModelAndView("fitbit");
	}

	@RequestMapping("/data")
	public ModelAndView redirectToData() throws IOException {
		return new ModelAndView("data");
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
		
		FitbitDetailsServiceImpl fitbitService = new FitbitDetailsServiceImpl();

		mv = new ModelAndView("dashboard");

		fitbitService.getHeartRate(mv, heartRateDetails);
		fitbitService.getActivity(mv,activityDetails);
		fitbitService.getFood(mv,foodDetails);
		fitbitService.getWater(mv,waterDetails);
		fitbitService.getUserProfile(mv, userProfile);
		fitbitService.getActivityGoals(mv, activityGoalDetails);
		fitbitService.getSleep(mv, sleepDetails);

		return mv;
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
