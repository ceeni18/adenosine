package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by uday on 4/24/16.
 */

@Document(collection = "tiSensorHumidity")
public class TiSensorHumidity implements TiSensorDatapoint {
    private double humidity;
    private String timestamp;
    private String tiSensorId;
    private String userId;
    private String collection = "tiSensorHumidity";

    public String getCollectionName() {
        return collection;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
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