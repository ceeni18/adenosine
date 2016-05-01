package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by uday on 4/23/16.
 */

@Document(collection = "tiSensorLight")
public class TiSensorLight implements TiSensorDatapoint {
    private double light;
    private String timestamp;
    private String tiSensorId;
    private String userId;
    private String collection = "tiSensorLight";

    public String getCollectionName() {
        return collection;
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
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
