package com.web.model;

import java.util.Map;

public class SleepDetails {
	private long logId;
	private int efficiency;
	private long duration;
	private int restlessCount;
	private int awakeCount;
	private boolean isMainSleep;
	private Map<String, Integer> dataMap;

	//public SleepDetails(long log, int eff, long dur, int rCount, int aCount, boolean isMain, String dTime, int val) {
	public SleepDetails(long log, int eff, long dur, int rCount, int aCount, boolean isMain, Map<String, Integer> map) {
		logId = log;
		efficiency = eff;
		duration = dur;
		restlessCount = rCount;
		awakeCount = aCount;
		isMainSleep = isMain;
		dataMap = map;
		//dateTime = dTime;
		//value = val;
	}

	public long getLogId() {
		return logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	public int getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public int getRestlessCount() {
		return restlessCount;
	}

	public void setRestlessCount(int restlessCount) {
		this.restlessCount = restlessCount;
	}

	public int getAwakeCount() {
		return awakeCount;
	}

	public void setAwakeCount(int awakeCount) {
		this.awakeCount = awakeCount;
	}

	public boolean getIsMainSleep() {
		return isMainSleep;
	}

	public void setMainSleep(boolean isMainSleep) {
		this.isMainSleep = isMainSleep;
	}

	public Map<String, Integer> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Integer> dataMap) {
		this.dataMap = dataMap;
	}

	/*public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}*/
}