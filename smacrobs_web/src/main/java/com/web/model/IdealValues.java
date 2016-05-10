package com.web.model;

public class IdealValues{
	double idealTemperatureLow;
    double idealTemperatureHigh;
    double idealLightValue;
    double idealHumidityLow;
    double idealHumidityHigh;
    double idealFairlyActiveMinutes;
    String[] foodsInDB;
	public double getIdealTemperatureLow() {
		return idealTemperatureLow;
	}
	public void setIdealTemperatureLow(double idealTemperatureLow) {
		this.idealTemperatureLow = idealTemperatureLow;
	}
	public double getIdealTemperatureHigh() {
		return idealTemperatureHigh;
	}
	public void setIdealTemperatureHigh(double idealTemperatureHigh) {
		this.idealTemperatureHigh = idealTemperatureHigh;
	}
	public double getIdealLightValue() {
		return idealLightValue;
	}
	public void setIdealLightValue(double idealLightValue) {
		this.idealLightValue = idealLightValue;
	}
	public double getIdealHumidityLow() {
		return idealHumidityLow;
	}
	public void setIdealHumidityLow(double idealHumidityLow) {
		this.idealHumidityLow = idealHumidityLow;
	}
	public double getIdealHumidityHigh() {
		return idealHumidityHigh;
	}
	public void setIdealHumidityHigh(double idealHumidityHigh) {
		this.idealHumidityHigh = idealHumidityHigh;
	}
	public double getIdealFairlyActiveMinutes() {
		return idealFairlyActiveMinutes;
	}
	public void setIdealFairlyActiveMinutes(double idealFairlyActiveMinutes) {
		this.idealFairlyActiveMinutes = idealFairlyActiveMinutes;
	}
	public String[] getFoodsInDB() {
		return foodsInDB;
	}
	public void setFoodsInDB(String[] foodsInDB) {
		this.foodsInDB = foodsInDB;
	}
}
