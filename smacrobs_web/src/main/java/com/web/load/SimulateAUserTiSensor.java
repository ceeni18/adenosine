package com.web.load;

import com.web.config.Constants;
import com.web.model.*;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by uday on 4/30/16.
 */
public class SimulateAUserTiSensor {
    static RestTemplate restTemplate;
    static TiSensorTemperature temperature = new TiSensorTemperature();
    static TiSensorLight light = new TiSensorLight();
    static TiSensorHumidity humidity = new TiSensorHumidity();
    static Random random = new Random();


    public static void main(String args[]) throws Exception {
        restTemplate = new RestTemplate();

        String userId = "26BZH7";
        temperature.setUserId(userId);
        light.setUserId(userId);
        humidity.setUserId(userId);

        temperature.setTiSensorId("REDD");
        light.setTiSensorId("REDD");
        humidity.setTiSensorId("REDD");

        DecimalFormat formatter = new DecimalFormat("00");
        for(int i=22; i<24; i++){
            for(int j=0; j<60; j++){
                sendData(""+i+":"+formatter.format(j)+":00");
            }
        }
        for(int i=0; i<10; i++){
            for(int j=0; j<60; j++){
                sendData(""+formatter.format(i)+":"+formatter.format(j)+":00");
            }
        }
    }

    private static void sendData(String minute){
        temperature.setTimestamp(minute);
        light.setTimestamp(minute);
        humidity.setTimestamp(minute);

        temperature.setTemperature(15+random.nextDouble());
        sendDataPoint(temperature, "/temperature");
        light.setLight(5+random.nextDouble());
        sendDataPoint(light, "/light");
        humidity.setHumidity(50+random.nextDouble());
        sendDataPoint(humidity, "/humidity");
    }

    private static void sendDataPoint(TiSensorDatapoint datapoint, String
            restUrl){
        try{
            restTemplate.postForLocation(Constants.TISENSOR_REST_URL+restUrl,
                    datapoint);
        }catch(Exception e){
            System.out.println("Unable to Send datapoint"+e);
        }
    }
}
