package com.web.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.FitbitOAuthServiceIntf;
import service.FitbitDetailsServiceIntf;
import service.UserProfileServiceIntf;






import com.web.utils.FitbitTokens;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.UserProfile;
import com.web.utils.Constants;

@Controller
public class FitbitOAuthControllerTest {
	private final Logger logger;
	
	String controllerMessage = "In Fitbit-OAuth-Connection Controller";
	String redirectUrl;
	ModelAndView mv;
	UserProfileServiceIntf userProfileService;
	FitbitDetailsServiceIntf fitbitDetailsService;
	FitbitOAuthServiceIntf fitbitOuthService;
	
	@Autowired
	Constants constants;

/*	public FitbitOAuthControllerTest() {

		logger=LoggerFactory.getLogger(FitbitOAuthControllerTest.class);
	}
*/
	@Autowired
	public FitbitOAuthControllerTest(UserProfileServiceIntf userProfileService,
			FitbitDetailsServiceIntf sleepDetailsService,
			FitbitOAuthServiceIntf fitbitOAuthService) {
		
		this.userProfileService = userProfileService;
		this.fitbitOuthService = fitbitOAuthService;
		this.fitbitDetailsService = sleepDetailsService;
		logger=LoggerFactory.getLogger(FitbitOAuthControllerTest.class);

		LoggerContext loggerContext = ((ch.qos.logback.classic.Logger)logger).getLoggerContext();
		System.out.println(loggerContext.getName());
		loggerContext.getStatusManager();
	}

	@RequestMapping("/oauth")
	public String redirectToFitbit() throws IOException {

		System.out.print(logger.getName());
		logger.info(controllerMessage + " going to redirect to fitbit ");

		redirectUrl = getRedirectURL();

		return "redirect:" + redirectUrl;
	}

	@RequestMapping("/oauthredirect")
	public ModelAndView redirectFromFitbit(
			@RequestParam(value = "code", required = false, defaultValue = "") String response)
			throws IOException {

		logger.info(controllerMessage
				+ " returned from fitbit access code: " + response);

		FitbitTokens fitbitTokens = fitbitOuthService.getFitbitTokens(response);

		String accessToken = fitbitTokens.getAccessToken();
		String refreshToken = fitbitTokens.getRefreshToken();

		UserProfile userProfile = userProfileService.getUserProfileDetails(
				accessToken, refreshToken);
		SleepDetails sleepDetails = fitbitDetailsService.getSleepDetails(
				accessToken, refreshToken);
		
		HeartRateDetails heartRateDetails =  fitbitDetailsService.getHeartRateDetails(accessToken, refreshToken);

		mv = new ModelAndView("fitbitdetails");
		mv.addObject("userProfile", userProfile);
		mv.addObject("sleepDetails", sleepDetails);
		mv.addObject("heartRateDetails",heartRateDetails);
		return mv;
	}

	private String getRedirectURL() {
	

		return "https://www.fitbit.com/oauth2/authorize?" + ""
				+ "response_type=" + Constants.getFitbitOauthResposeType()
				+ "&client_id=" + constants.getFitbitOauthClientId()
				+ "&redirect_uri=" + constants.getRedirectUriFromFitbit()
				+ "&scope=" + constants.getFitbitScope() + "&z=1";
	}

}
