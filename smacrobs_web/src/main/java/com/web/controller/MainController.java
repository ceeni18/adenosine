package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

import service.FitbitDetailsServiceImpl;
import service.FitbitDetailsServiceIntf;
import service.FitbitOAuthServiceIntf;
import service.UserProfileServiceIntf;

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

	@RequestMapping("/")
	public ModelAndView index() {
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
	
	@RequestMapping(value = "/tisensor", method = RequestMethod.POST)
	public String saveTiSensor(@RequestParam(
			value = "id",
			required = true,
			defaultValue = ""
			) String id, HttpSession session) {
		userProfileService.UpdateTiSensorId(id, session.getAttribute("userId").toString());
		return "redirect:/dashboard";
	}

	@RequestMapping("/redirectToSite")
	public String localRedirect(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	UserProfile userProfile=null;
	SleepDetails sleepDetails = null;
	HeartRateDetails heartRateDetails= null;
	FoodDetails foodDetails= null;
	ActivityDetails activityDetails= null;
	WaterDetails waterDetails= null ;
	ActivityGoalDetails activityGoalDetails= null;

	@RequestMapping(Constants.redirectUriFromFitbit)
	public String redirectFromFitbit(
			@RequestParam(
					value = "code",
					required = false,
					defaultValue = ""
					) String response,HttpSession session) throws IOException {
		
		logger.debug("Successfully redirected from Fitbit "+response);
		FitbitTokens fitbitTokens = this.fitbitOuthService.getFitbitTokens(response);
		logger.info("FitbitTokens are received!");
		
		userProfileService.setFitbitTokens(fitbitTokens);
		userProfile = userProfileService.getUserDetails();
		fitbitDetailsService.setFitbitTokens(fitbitTokens);
		sleepDetails = fitbitDetailsService.getSleepDetails(userProfile.getUser().getUserId());
		heartRateDetails = fitbitDetailsService.getHeartRateDetails(userProfile.getUser().getUserId());
		foodDetails = fitbitDetailsService.getFoodDetails(userProfile.getUser().getUserId());
		activityDetails = fitbitDetailsService.getActivityDetails(userProfile.getUser().getUserId());
		waterDetails = fitbitDetailsService.getWaterDetails(userProfile.getUser().getUserId());
		activityGoalDetails = fitbitDetailsService.getActivityGoalDetails(userProfile.getUser().getUserId());
		
		session.setAttribute("userId" , userProfile.getUser().getUserId());
		session.setAttribute("user", userProfile.getUser());
		
		return "redirect:/dashboard";
	}

	@RequestMapping("/dashboard")
	public ModelAndView dashboard(HttpSession session) {
		if(session.getAttribute("userId")==null){
			index();
		}
		else{
			FitbitDetailsServiceImpl fitbitService = new FitbitDetailsServiceImpl();
			mv = new ModelAndView("dashboard");
			userProfile = userProfileService.getUserDetailsFromDB(session.getAttribute("userId").toString());
			sleepDetails = fitbitDetailsService.getSleepDetailsFromDB(session.getAttribute("userId").toString());
			heartRateDetails = fitbitDetailsService.getHeartRateDetailsFromDB(session.getAttribute("userId").toString());
			foodDetails = fitbitDetailsService.getFoodDetailsFromDB(session.getAttribute("userId").toString());
			activityDetails = fitbitDetailsService.getActivityDetailsFromDB(session.getAttribute("userId").toString());
			waterDetails = fitbitDetailsService.getWaterDetailsFromDB(session.getAttribute("userId").toString());
			activityGoalDetails = fitbitDetailsService.getActivityGoalDetailsFromDB(session.getAttribute("userId").toString());
			fitbitService.getHeartRate(mv, heartRateDetails);
			fitbitService.getActivity(mv,activityDetails);
			fitbitService.getFood(mv,foodDetails);
			fitbitService.getWater(mv,waterDetails);
			fitbitService.getUserProfile(mv, userProfile);
			fitbitService.getActivityGoals(mv, activityGoalDetails);
			fitbitService.getSleep(mv, sleepDetails);
		}
		return mv;
	}

	@RequestMapping("/error")
	public ModelAndView Error() {
		return new ModelAndView("Error");
	}

	@RequestMapping("/tisensor")
	public ModelAndView tisensor() {
		return new ModelAndView("TiSensor");
	}

	@RequestMapping("/medical")
	public ModelAndView medical() {
		return new ModelAndView("Medical");
	}

	private String getRedirectURL() {
		return Constants.fitbitAuthUri + 
				"response_type=" + Constants.fitbitOauthResposeType +
				"&client_id=" + Constants.fitbitOauthClientId +
				"&redirect_uri=" +
				Constants.LOCALHOST + Constants.redirectUriFromFitbit +
				"&scope=" + Constants.fitbitScope;
	}
}