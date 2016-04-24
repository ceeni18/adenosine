package com.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

import ch.qos.logback.classic.LoggerContext;
import service.FitbitDetailsServiceImpl;
import service.FitbitDetailsServiceIntf;
import service.FitbitOAuthServiceIntf;
import service.UserProfileServiceIntf;

import java.io.IOException;

import javax.servlet.http.HttpSession;

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
	
	
	@RequestMapping(value = "/tisensor", method = RequestMethod.POST)
	   public String saveTiSensor(@RequestParam(
				value = "id",
				required = true,
				defaultValue = ""
				) String id, HttpSession session) {
	   System.out.println(id);
	   userProfileService.UpdateTiSensorId(id, session.getAttribute("userId").toString());
	   return "redirect:/dashboard";
	  }
	
	@RequestMapping("/redirectToSite")
    public String localRedirect(HttpSession session) {
		session.invalidate();
        return "redirect:/";
    }
	
	@RequestMapping(Constants.redirectUriFromFitbit)
	public String redirectFromFitbit(
			@RequestParam(
					value = "code",
					required = false,
					defaultValue = ""
					) String response,HttpSession session) throws IOException {
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
		
		session.setAttribute("userId" , userProfile.getUser().getUserId());
		session.setAttribute("user", userProfile.getUser());
		
		//TODO: SSR Need to put this in dashboard
		FitbitDetailsServiceImpl fitbitService = new FitbitDetailsServiceImpl();
		mv = new ModelAndView("dashboard");
		fitbitService.getHeartRate(mv, heartRateDetails);
		fitbitService.getActivity(mv,activityDetails);
		fitbitService.getFood(mv,foodDetails);
		fitbitService.getWater(mv,waterDetails);
		fitbitService.getUserProfile(mv, userProfile);
		fitbitService.getActivityGoals(mv, activityGoalDetails);
		fitbitService.getSleep(mv, sleepDetails);
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView dashboard(HttpSession session) {
		//TODO: SSR Query From database and send values
		return new ModelAndView("dashboard");
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
		return "https://www.fitbit.com/oauth2/authorize?" +
				"response_type=" + Constants.fitbitOauthResposeType +
				"&client_id=" + Constants.fitbitOauthClientId +
				"&redirect_uri=" +
				Constants.LOCALHOST + Constants.redirectUriFromFitbit +
				"&scope=" + Constants.fitbitScope +
				"&z=1";
	}
}
