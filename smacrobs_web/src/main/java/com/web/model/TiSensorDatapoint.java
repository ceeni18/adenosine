package com.web.model;

/**
 * Created by uday on 3/21/16.
 */

public interface TiSensorDatapoint {
    String getUserId();

    void setUserId(String userId);

    String getTiSensorId();

    void setTiSensorId(String tiSensorId);

    String getCollectionName();
}