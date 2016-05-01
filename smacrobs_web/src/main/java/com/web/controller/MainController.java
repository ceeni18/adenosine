package com.web.controller;

import com.web.config.Constants;
import com.web.model.FitbitTokens;
import com.web.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(
			MainController.class);


	UserProfileServiceIntf userProfileService;
	FitbitOAuthServiceIntf fitbitOuthService;
	RecommendationsServiceImpl recommendationsService;
	FitbitDetailsServiceIntf fitbitDetailsService;

	@Autowired
	public MainController(UserProfileServiceIntf userProfileService,
						  FitbitOAuthServiceIntf fitbitOuthService,
						  RecommendationsServiceImpl recommendationsService,
						  FitbitDetailsServiceIntf fitbitDetailsService){
		this.userProfileService = userProfileService;
		this.fitbitOuthService = fitbitOuthService;
		this.recommendationsService = recommendationsService;
		this.fitbitDetailsService = fitbitDetailsService;
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
		userProfileService.UpdateTiSensorId(id,
				session.getAttribute("userId").toString());
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
					) String response, HttpSession session) throws IOException {
		
		logger.debug("Redirected from Fitbit with response "+response);
		FitbitTokens fitbitTokens = this.fitbitOuthService.getFitbitTokens(response);

		// Get User Details of loggedIn user
		userProfileService.setFitbitTokens(fitbitTokens);
		UserProfile userProfile = userProfileService.getUserDetails();

		session.setAttribute("userId" , userProfile.getUser().getUserId());
		session.setAttribute("user", userProfile.getUser());
		session.setAttribute("access_token", fitbitTokens.getAccess_token());
		session.setAttribute("todayDate", ServiceUtils.getTodayDate());
		session.setAttribute("yesterdayDate", ServiceUtils.getYesterdayDate());

		return "redirect:/dashboard";
	}

	@RequestMapping("/dashboard")
	public ModelAndView dashboard(HttpSession session) {
		// add functionality to take date as a parameter
		// and overwrite session variables
		ModelAndView mv = null;
		if(session.getAttribute("userId")==null){
			return new ModelAndView("index");
		}
		else{
			mv = new ModelAndView("dashboard");
			recommendationsService.setSessionVariables(session);
			fitbitDetailsService.setSessionVariables(session);

			fitbitDetailsService.AddHeartRateToModel(mv);
			fitbitDetailsService.AddActivityDetailsToModel(mv);
			fitbitDetailsService.AddFoodToModel(mv);
			fitbitDetailsService.AddWaterToModel(mv);
			fitbitDetailsService.AddUserProfileToModel(mv);
			fitbitDetailsService.AddActivityGoalsToModel(mv);
			fitbitDetailsService.AddSleepToModel(mv);
			recommendationsService.addRecommendationsToModel(mv, Boolean.FALSE);
		}
		return mv;
	}

	@RequestMapping("/error")
	public ModelAndView Error() {
		return new ModelAndView("error");
	}

	@RequestMapping("/tisensor")
	public ModelAndView tisensor() {
		return new ModelAndView("tisensor");
	}

	@RequestMapping("/medical")
	public ModelAndView medical() {
		return new ModelAndView("medical");
	}

	private String getRedirectURL() {
		String url = "/error";
		try {
			url = "https://www.fitbit.com/oauth2/authorize?" +
					"response_type=code" +
					"&client_id=" +
					URLEncoder.encode(Constants.fitbitOauthClientId, "UTF-8") +
					"&redirect_uri=" +
					URLEncoder.encode(Constants.LOCALHOST + Constants
							.redirectUriFromFitbit, "UTF-8") +
					// scope is already encoded
					"&scope=" + Constants.fitbitScope +
					"&prompt=none";
		}catch (Exception e){
			logger.error("URL encoding exception"+e);
		}
		return url;
	}
}