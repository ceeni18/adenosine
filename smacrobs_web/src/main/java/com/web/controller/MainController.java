package com.web.controller;

import com.web.config.Constants;
import com.web.model.FitbitTokens;
import com.web.model.UserProfile;
import org.apache.commons.lang.exception.ExceptionUtils;
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
    TiSensorService tiSensorService;

    @Autowired
    public MainController(UserProfileServiceIntf userProfileService,
                          FitbitOAuthServiceIntf fitbitOuthService,
                          RecommendationsServiceImpl recommendationsService,
                          FitbitDetailsServiceIntf fitbitDetailsService,
                          TiSensorService tiSensorService) {
        this.userProfileService = userProfileService;
        this.fitbitOuthService = fitbitOuthService;
        this.recommendationsService = recommendationsService;
        this.fitbitDetailsService = fitbitDetailsService;
        this.tiSensorService = tiSensorService;
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
        ModelAndView mv = new ModelAndView("contact");
        mv.addObject("emailsent", "false");
        //return new ModelAndView("contact");
        return mv;
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

    @RequestMapping("/about")
    public ModelAndView redirectToAbout() throws IOException {
        return new ModelAndView("about");
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ModelAndView sendEmail(@RequestParam(
            value = "name"
    ) String name, @RequestParam(value = "email") String email,
                                  @RequestParam(value = "subject") String subject,
                                  @RequestParam(value = "message") String message, HttpSession session) {
        if (name == null || email == null || subject == null || message == null) {
            return new ModelAndView("error");
        }
        ModelAndView mv = new ModelAndView("contact");
        try {
            ServiceUtils.sendEmailNotification(name, email, subject, message);

            mv.addObject("emailsent", "true");
        } catch (Exception e) {
            logger.error("Unable to send email notifications :: " +
                    ExceptionUtils.getFullStackTrace(e));
        }

        //return "redirect:/dashboard";
        return mv;
    }

    @RequestMapping(value = "/tisensor", method = RequestMethod.POST)
    public String saveTiSensor(@RequestParam(
            value = "id",
            required = true,
            defaultValue = ""
    ) String id, HttpSession session) {
        if (!userProfileService.ValidateTiSensor(id)) {
            return "redirect:/error";
        }
        userProfileService.UpdateTiSensorId(id,
                session.getAttribute("userId").toString());
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/medical", method = RequestMethod.POST)
    public String saveMedical(@RequestParam(value = "medicine") String[] medicine, HttpSession session) {
        if (!recommendationsService.ValidateMedicine(medicine))
            return "redirect:/error";

        userProfileService.UpdateMedicalDetails(medicine,
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

        logger.debug("Redirected from Fitbit with response " + response);
        FitbitTokens fitbitTokens = this.fitbitOuthService.getFitbitTokens(response);

        // Get User Details of loggedIn user
        userProfileService.setFitbitTokens(fitbitTokens);
        UserProfile userProfile = userProfileService.getUserDetails();

        session.setAttribute("userId", userProfile.getUser().getUserId());
        session.setAttribute("user", userProfile.getUser());
        session.setAttribute("access_token", fitbitTokens.getAccess_token());
        session.setAttribute("todayDate", ServiceUtils.getTodayDate());
        session.setAttribute("yesterdayDate", ServiceUtils.getYesterdayDate());

        return "redirect:/dashboard";
    }

    @RequestMapping("/dashboard")
    public ModelAndView dashboard(@RequestParam(
            value = "date",
            required = false,
            defaultValue = ""
    ) String date, HttpSession session) {
        ModelAndView mv = null;
        if (session.getAttribute("userId") == null) {
            return index();
        } else {
            if (date == null || date.equals("")) {
                session.setAttribute("todayDate", ServiceUtils.getTodayDate());
                session.setAttribute("yesterdayDate", ServiceUtils.getYesterdayDate());
            } else {
                session.setAttribute("todayDate", date);
                session.setAttribute("yesterdayDate", ServiceUtils.getYesterdayDate(date));
            }
            mv = new ModelAndView("dashboard");
            recommendationsService.setSessionVariables(session);
            fitbitDetailsService.setSessionVariables(session);
            tiSensorService.setSessionVariables(session);

            fitbitDetailsService.AddHeartRateToModel(mv);
            fitbitDetailsService.AddActivityDetailsToModel(mv);
            fitbitDetailsService.AddFoodToModel(mv);
            fitbitDetailsService.AddWaterToModel(mv);
            fitbitDetailsService.AddUserProfileToModel(mv);
            fitbitDetailsService.AddActivityGoalsToModel(mv);
            fitbitDetailsService.AddSleepToModel(mv);

            tiSensorService.AddTemperatureToModel(mv);
            tiSensorService.AddLightToModel(mv);
            tiSensorService.AddHumidityToModel(mv);

            recommendationsService.addRecommendationsToModel(mv);

            /*session.setAttribute("todayDate", ServiceUtils.getTodayDate());
            session.setAttribute("yesterdayDate", ServiceUtils.getYesterdayDate());*/
        }
        return mv;
    }

    @RequestMapping("/refresh")
    public String refresh(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            fitbitDetailsService.removeActivityDetailsFromDB();
            fitbitDetailsService.removeActivityGoalDetailsFromDB();
            fitbitDetailsService.removeFoodDetailsFromDB();
            fitbitDetailsService.removeHeartRateDetailsFromDB();
            fitbitDetailsService.removeSleepDetailsFromDB();
            fitbitDetailsService.removeWaterDetailsFromDB();
            recommendationsService.removeRecommendationsFromDB();
            return "redirect:/dashboard";
        }
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
        ModelAndView mv = new ModelAndView("medical");
        recommendationsService.addMedicinesToModel(mv);
        return mv;
    }

    private String getRedirectURL() {
        String url = "/error";
        try {
            url = "https://www.fitbit.com/oauth2/authorize?" +
                    "response_type=code" +
                    "&client_id=" +
                    URLEncoder.encode(Constants.FITBIT_OAUTH_CLIENT_ID, "UTF-8") +
                    "&redirect_uri=" +
                    URLEncoder.encode(Constants.REDIRECT_URL_BASE + Constants
                            .redirectUriFromFitbit, "UTF-8") +
                    // scope is already encoded
                    "&scope=" + Constants.fitbitScope +
                    "&prompt=none";
        } catch (Exception e) {
            logger.error("URL encoding exception" +
                    ExceptionUtils.getFullStackTrace(e));
        }
        return url;
    }
}