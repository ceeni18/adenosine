package com.web.controller;

import ch.qos.logback.classic.LoggerContext;
import com.web.config.Constants;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.model.UserProfile;
import com.web.model.FitbitTokens;
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
        UserProfile userProfile = userProfileService.getUserProfileDetails();

        fitbitDetailsService.setFitbitTokens(fitbitTokens);
        SleepDetails sleepDetails = fitbitDetailsService.getSleepDetails();
        HeartRateDetails heartRateDetails = fitbitDetailsService
                .getHeartRateDetails();

        mv = new ModelAndView("dashboard");
        mv.addObject("userProfile", userProfile);
        mv.addObject("sleepDetails", sleepDetails);
        mv.addObject("heartRateDetails",heartRateDetails);
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
