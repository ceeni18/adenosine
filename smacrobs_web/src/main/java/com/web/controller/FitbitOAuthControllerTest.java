package com.web.controller;


import java.io.IOException;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import service.FitbitOAuthService;
import service.SleepDetailsService;
import service.UserProfileService;

import com.web.model.FitbitTokens;
import com.web.model.SleepDetails;
import com.web.model.UserProfile;
import com.web.utils.Constants;

@Controller
public class FitbitOAuthControllerTest {
	String controllerMessage = "In Fitbit-OAuth-Connection Controller";
	String redirectUrl;
	ModelAndView mv;
	
	UserProfileService userProfileService = new UserProfileService();
	SleepDetailsService sleepDetailsService = new SleepDetailsService();
	FitbitOAuthService fitbitOuthService = new FitbitOAuthService();

	@RequestMapping("/oauth")
	public String redirectToFitbit() throws IOException {

		System.out.println(controllerMessage+" going to redirect to fitbit ");

		redirectUrl = getRedirectURL();

		return "redirect:" + redirectUrl;		
	}

	@RequestMapping("/oauthredirect")
	public ModelAndView redirectFromFitbit (
			@RequestParam(value = "code", required = false, defaultValue = "") String response) throws IOException {

		System.out.println(controllerMessage+" returned from fitbit access code: " +response);	

		FitbitTokens fitbitTokens =  fitbitOuthService.getFitbitTokens(response);
		
		String accessToken=fitbitTokens.getAccessToken();	
		String refreshToken = fitbitTokens.getRefreshToken();


		UserProfile userProfile  = userProfileService.getUserProfileDetails(accessToken,refreshToken);
		SleepDetails sleepDetails = sleepDetailsService.getSleepDetails(accessToken, refreshToken);	
		
		mv = new ModelAndView("fitbitdetails");
		mv.addObject("message", "Minutes Asleep data from fitbit");
		mv.addObject("sleepDetails",sleepDetails );	
		mv.addObject("userProfile",userProfile);
		return mv;
	}

	private String getRedirectURL(){
		return "https://www.fitbit.com/oauth2/authorize?"+""
				+"response_type="+Constants.getFitbitOauthResposeType()
				+"&client_id="+Constants.getFitbitOauthClientId()
				+"&redirect_uri="+Constants.getRedirectUriFromFitbit()
				+"&scope="+Constants.getFitbitScope()
				+"&z=1";
	}

	



}

