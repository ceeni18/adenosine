package com.web.model;

import com.google.gson.annotations.SerializedName;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by uday on 4/9/16.
 */

@Document(collection = "heartRateDetails")
public class HeartRateDetails {
    @SerializedName("activities-heart")
    private ActivitiesHeart[] activities_heart;

    public ActivitiesHeart[] getActivitiesheart ()
    {
        return activities_heart;
    }

    public void setActivitiesHeart (ActivitiesHeart[] activities_heart)
    {
        this.activities_heart = activities_heart;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [activities_heart = "+activities_heart+"]";
    }

    class ActivitiesHeart {
        private String dateTime;

        private Value value;

        public String getDateTime ()
        {
            return dateTime;
        }

        public void setDateTime (String dateTime)
        {
            this.dateTime = dateTime;
        }

        public Value getValue ()
        {
            return value;
        }

        public void setValue (Value value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [dateTime = "+dateTime+", value = "+value+"]";
        }
    }

    class Value
    {
        private String restingHeartRate;

        private HeartRateZones[] heartRateZones;

        private String[] customHeartRateZones;

        public String getRestingHeartRate ()
        {
            return restingHeartRate;
        }

        public void setRestingHeartRate (String restingHeartRate)
        {
            this.restingHeartRate = restingHeartRate;
        }

        public HeartRateZones[] getHeartRateZones ()
        {
            return heartRateZones;
        }

        public void setHeartRateZones (HeartRateZones[] heartRateZones)
        {
            this.heartRateZones = heartRateZones;
        }

        public String[] getCustomHeartRateZones ()
        {
            return customHeartRateZones;
        }

        public void setCustomHeartRateZones (String[] customHeartRateZones)
        {
            this.customHeartRateZones = customHeartRateZones;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [restingHeartRate = "+restingHeartRate+", heartRateZones = "+heartRateZones+", customHeartRateZones = "+customHeartRateZones+"]";
        }
    }

    class HeartRateZones
    {
        private String min;

        private String minutes;

        private String max;

        private String name;

        private String caloriesOut;

        public String getMin ()
        {
            return min;
        }

        public void setMin (String min)
        {
            this.min = min;
        }

        public String getMinutes ()
        {
            return minutes;
        }

        public void setMinutes (String minutes)
        {
            this.minutes = minutes;
        }

        public String getMax ()
        {
            return max;
        }

        public void setMax (String max)
        {
            this.max = max;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getCaloriesOut ()
        {
            return caloriesOut;
        }

        public void setCaloriesOut (String caloriesOut)
        {
            this.caloriesOut = caloriesOut;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [min = "+min+", minutes = "+minutes+", max = "+max+", name = "+name+", caloriesOut = "+caloriesOut+"]";
        }
    }

}
