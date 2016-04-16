package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "sleepDetails")
public class SleepDetails
{
    private Summary summary;

    private Sleep[] sleep;

    public Summary getSummary ()
    {
        return summary;
    }

    public void setSummary (Summary summary)
    {
        this.summary = summary;
    }

    public Sleep[] getSleep ()
    {
        return sleep;
    }

    public void setSleep (Sleep[] sleep)
    {
        this.sleep = sleep;
    }

    public String toString() {
        return "SleepDetails{" +
                "summary=" + summary +
                ", sleep=" + Arrays.toString(sleep) +
                '}';
    }

    class Summary
    {
        private String totalTimeInBed;

        private String totalMinutesAsleep;

        private String totalSleepRecords;

        public String getTotalTimeInBed ()
        {
            return totalTimeInBed;
        }

        public void setTotalTimeInBed (String totalTimeInBed)
        {
            this.totalTimeInBed = totalTimeInBed;
        }

        public String getTotalMinutesAsleep ()
        {
            return totalMinutesAsleep;
        }

        public void setTotalMinutesAsleep (String totalMinutesAsleep)
        {
            this.totalMinutesAsleep = totalMinutesAsleep;
        }

        public String getTotalSleepRecords ()
        {
            return totalSleepRecords;
        }

        public void setTotalSleepRecords (String totalSleepRecords)
        {
            this.totalSleepRecords = totalSleepRecords;
        }
    }

    public class Sleep
    {
        private String isMainSleep;

        private String restlessCount;

        private String logId;

        private String minutesAfterWakeup;

        private String minutesToFallAsleep;

        private String restlessDuration;

        private String startTime;

        private String minutesAwake;

        private MinuteData[] minuteData;

        private String timeInBed;

        private String duration;

        private String awakeCount;

        private String awakeDuration;

        private String awakeningsCount;

        private String efficiency;

        private String minutesAsleep;

        public String getIsMainSleep ()
        {
            return isMainSleep;
        }

        public void setIsMainSleep (String isMainSleep)
        {
            this.isMainSleep = isMainSleep;
        }

        public String getRestlessCount ()
        {
            return restlessCount;
        }

        public void setRestlessCount (String restlessCount)
        {
            this.restlessCount = restlessCount;
        }

        public String getLogId ()
        {
            return logId;
        }

        public void setLogId (String logId)
        {
            this.logId = logId;
        }

        public String getMinutesAfterWakeup ()
        {
            return minutesAfterWakeup;
        }

        public void setMinutesAfterWakeup (String minutesAfterWakeup)
        {
            this.minutesAfterWakeup = minutesAfterWakeup;
        }

        public String getMinutesToFallAsleep ()
        {
            return minutesToFallAsleep;
        }

        public void setMinutesToFallAsleep (String minutesToFallAsleep)
        {
            this.minutesToFallAsleep = minutesToFallAsleep;
        }

        public String getRestlessDuration ()
        {
            return restlessDuration;
        }

        public void setRestlessDuration (String restlessDuration)
        {
            this.restlessDuration = restlessDuration;
        }

        public String getStartTime ()
        {
            return startTime;
        }

        public void setStartTime (String startTime)
        {
            this.startTime = startTime;
        }

        public String getMinutesAwake ()
        {
            return minutesAwake;
        }

        public void setMinutesAwake (String minutesAwake)
        {
            this.minutesAwake = minutesAwake;
        }

        public MinuteData[] getMinuteData ()
        {
            return minuteData;
        }

        public void setMinuteData (MinuteData[] minuteData)
        {
            this.minuteData = minuteData;
        }

        public String getTimeInBed ()
        {
            return timeInBed;
        }

        public void setTimeInBed (String timeInBed)
        {
            this.timeInBed = timeInBed;
        }

        public String getDuration ()
        {
            return duration;
        }

        public void setDuration (String duration)
        {
            this.duration = duration;
        }

        public String getAwakeCount ()
        {
            return awakeCount;
        }

        public void setAwakeCount (String awakeCount)
        {
            this.awakeCount = awakeCount;
        }

        public String getAwakeDuration ()
        {
            return awakeDuration;
        }

        public void setAwakeDuration (String awakeDuration)
        {
            this.awakeDuration = awakeDuration;
        }

        public String getAwakeningsCount ()
        {
            return awakeningsCount;
        }

        public void setAwakeningsCount (String awakeningsCount)
        {
            this.awakeningsCount = awakeningsCount;
        }

        public String getEfficiency ()
        {
            return efficiency;
        }

        public void setEfficiency (String efficiency)
        {
            this.efficiency = efficiency;
        }

        public String getMinutesAsleep ()
        {
            return minutesAsleep;
        }

        public void setMinutesAsleep (String minutesAsleep)
        {
            this.minutesAsleep = minutesAsleep;
        }
    }

    public class MinuteData
    {
        private String dateTime;

        private String value;

        public String getDateTime ()
        {
            return dateTime;
        }

        public void setDateTime (String dateTime)
        {
            this.dateTime = dateTime;
        }

        public String getValue ()
        {
            return value;
        }

        public void setValue (String value)
        {
            this.value = value;
        }
    }

}