package com.web.model;

public class SleepDetails {
 String sleepMinutes;
 

public SleepDetails(String string) {
	sleepMinutes=string;
}

public String getSleepMinutes() {
	return sleepMinutes;
}

public void setSleepMinutes(String sleepMinutes) {
	this.sleepMinutes = sleepMinutes;
}
}
