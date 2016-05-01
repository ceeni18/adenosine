package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by uday on 4/23/16.
 */

@Document(collection = "tiSensorTemperature")
public class TiSensorTemperature implements TiSensorDatapoint {
    private double temperature;
    private String timestamp;
    private String tiSensorId;
    private String userId;
    private String collection = "tiSensorTemperature";
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCollectionName() {
        return collection;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTiSensorId() {
        return tiSensorId;
    }

    public void setTiSensorId(String tiSensorId) {
        this.tiSensorId = tiSensorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
