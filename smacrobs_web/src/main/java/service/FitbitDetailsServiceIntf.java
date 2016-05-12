package service;

import com.web.model.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface FitbitDetailsServiceIntf {
    void setSessionVariables(HttpSession session);

    SleepDetails getSleepDetails();

    HeartRateDetails getHeartRateDetails();

    FoodDetails getFoodDetails();

    ActivityDetails getActivityDetails();

    WaterDetails getWaterDetails();

    ActivityGoalDetails getActivityGoalDetails();

    void AddHeartRateToModel(ModelAndView modelAndView);

    void AddActivityDetailsToModel(ModelAndView modelAndView);

    void AddFoodToModel(ModelAndView modelAndView);

    void AddWaterToModel(ModelAndView modelAndView);

    void AddActivityGoalsToModel(ModelAndView modelAndView);

    void AddSleepToModel(ModelAndView modelAndView);

    void AddUserProfileToModel(ModelAndView modelAndView);

    SleepDetails getSleepDetailsFromDB();

    HeartRateDetails getHeartRateDetailsFromDB();

    FoodDetails getFoodDetailsFromDB();

    ActivityDetails getActivityDetailsFromDB();

    WaterDetails getWaterDetailsFromDB();

    ActivityGoalDetails getActivityGoalDetailsFromDB();

    void removeSleepDetailsFromDB();

    void removeHeartRateDetailsFromDB();

    void removeFoodDetailsFromDB();

    void removeActivityDetailsFromDB();

    void removeWaterDetailsFromDB();

    void removeActivityGoalDetailsFromDB();

    List<SynchronizedData>
    getSleepInRequiredFormat();

}
