package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tiSensor")
public class TiSensor {
    private final String tiSensorId;
    private final String userId;

    private final double temperature;
    private final double light;
    private final Date dateTime;

    private TiSensor(TiSensorBuilder builder){
        this.tiSensorId = builder.tiSensorId;
        this.userId = builder.userId;
        this.temperature = builder.temperature;
        this.light = builder.light;
        this.dateTime = builder.dateTime;
    }

    public static class TiSensorBuilder{
        private String tiSensorId;
        private String userId;
        private double temperature;
        private double light;
        private Date dateTime;

        public TiSensorBuilder(String tiSensorId, String userId){
            this.tiSensorId = tiSensorId;
            this.userId = userId;
        }

        public TiSensorBuilder setTemperature(double temperature){
            this.temperature = temperature;
            return this;
        }

        public TiSensorBuilder setLight(double light){
            this.light = light;
            return this;
        }

        public TiSensorBuilder setDateTime(Date dateTime){
            this.dateTime = dateTime;
            return this;
        }

        public TiSensorBuilder build(){
            return new TiSensor(this);
        }
    }

    public String getTiSensorId() {
        return tiSensorId;
    }

    public String getUserId() {
        return userId;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getLight() {
        return light;
    }

    public Date getDateTime() {
        return dateTime;
    }
}