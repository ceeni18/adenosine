package com.web.model;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sleepDetails")
public class FitbitData {
	private final String userId;
	private final Date date;

	private final long logId;
	private final int efficiency;
	private final long duration;
	private final int restlessCount;
    private final int awakeCount;
	private final boolean isMainSleep;
	private final Map<String, Integer> dataMap;
    private final int heartRate;

    private FitbitData(FitbitDataBuilder builder){
        this.userId = builder.userId;
        this.date = builder.date;
        this.logId = builder.logId;
        this.efficiency = builder.efficiency;
        this.duration = builder.duration;
        this.restlessCount = builder.restlessCount;
        this.awakeCount = builder.awakeCount;
        this.isMainSleep = builder.isMainSleep;
        this.dataMap = builder.dataMap;
    }

    public static class FitbitDataBuilder{
        private String userId;
        private Date date;

        private long logId; // what is this logid?
        private int efficiency;
        private long duration;
        private int restlessCount;
        private int awakeCount;
        private boolean isMainSleep;
        private Map<String, Integer> dataMap;
        private int heartRate;

        public FitbitDataBuilder(String userId, String date){
            this.userId = userId;
            this.date = date;
        }

        public FitbitDataBuilder setLogId(long logId){
            this.logId = logId;
            return this;
        }
        
        public FitbitDataBuilder setEfficiency(int efficiency){
            this.efficiency = efficiency;
            return this;
        }
        
        public FitbitDataBuilder setDuration(long duration){
            this.duration = duration;
            return this;
        }

        public FitbitDataBuilder setRestlessCount(int restlessCount){
            this.restlessCount = restlessCount;
            return this;
        }

        public FitbitDataBuilder setAwakeCount(int awakeCount){
            this.awakeCount = awakeCount;
            return this;
        }

        public FitbitDataBuilder setDuration(boolean isMainSleep){
            this.isMainSleep = isMainSleep;
            return this;
        }

        public FitbitDataBuilder setDataMap(Map<String, Integer> dataMap){
            this.dataMap = dataMap;
            return this;
        }

        public FitbitDataBuilder setHeartRate(int heartRate){
            this.heartRate = heartRate;
            return this;
        }

        public FitbitData build(){
            return new FitbitData(this);
        }
    }

    public int getAwakeCount() {
        return awakeCount;
    }

    public String getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public long getLogId() {
        return logId;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public long getDuration() {
        return duration;
    }

    public int getRestlessCount() {
        return restlessCount;
    }

    public boolean isMainSleep() {
        return isMainSleep;
    }

    public Map<String, Integer> getDataMap() {
        return dataMap;
    }

    public int getHeartRate() {
        return heartRate;
    }
}