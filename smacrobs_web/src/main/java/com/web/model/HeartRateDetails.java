package com.web.model;

import com.google.gson.annotations.SerializedName;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "heartRateDetails")
public class HeartRateDetails {
	@SerializedName("activities-heart")
	private ActivitiesHeart[] activities_heart;
	
	private String userId;
	
	private String date;

	public ActivitiesHeart[] getActivitiesHeart() {
		return activities_heart;
	}

	public void setActivitiesHeart(ActivitiesHeart[] activities_heart) {
		this.activities_heart = activities_heart;
	}

	@Override
	public String toString() {
		return "ClassPojo [activities_heart = " + activities_heart + "]";
	}

	public static class ActivitiesHeart {
		private String dateTime;
		private Value value;

		public String getDateTime() {
			return dateTime;
		}

		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}

		public Value getValue() {
			return value;
		}

		public void setValue(Value value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "ClassPojo [dateTime = " + dateTime + ", value = " + value
					+ "]";
		}
	}

	public static class Value {
		private String restingHeartRate;
		private HeartRateZones[] heartRateZones;
		private CustomHeartRateZones[] customHeartRateZones;

		public String getRestingHeartRate() {
			return restingHeartRate;
		}

		public void setRestingHeartRate(String restingHeartRate) {
			this.restingHeartRate = restingHeartRate;
		}

		public HeartRateZones[] getHeartRateZones() {
			return heartRateZones;
		}

		public void setHeartRateZones(HeartRateZones[] heartRateZones) {
			this.heartRateZones = heartRateZones;
		}

		public CustomHeartRateZones[] getCustomHeartRateZones() {
			return customHeartRateZones;
		}

		public void setCustomHeartRateZones(
				CustomHeartRateZones[] customHeartRateZones) {
			this.customHeartRateZones = customHeartRateZones;
		}

		@Override
		public String toString() {
			return "ClassPojo [restingHeartRate = " + restingHeartRate
					+ ", heartRateZones = " + heartRateZones
					+ ", customHeartRateZones = " + customHeartRateZones + "]";
		}
	}

	public static class HeartRateZones {
		private String min;
		private String minutes;
		private String max;
		private String name;
		private String caloriesOut;

		public String getMin() {
			return min;
		}

		public void setMin(String min) {
			this.min = min;
		}

		public String getMinutes() {
			return minutes;
		}

		public void setMinutes(String minutes) {
			this.minutes = minutes;
		}

		public String getMax() {
			return max;
		}

		public void setMax(String max) {
			this.max = max;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCaloriesOut() {
			return caloriesOut;
		}

		public void setCaloriesOut(String caloriesOut) {
			this.caloriesOut = caloriesOut;
		}

		@Override
		public String toString() {
			return "ClassPojo [min = " + min + ", minutes = " + minutes
					+ ", max = " + max + ", name = " + name
					+ ", caloriesOut = " + caloriesOut + "]";
		}
	}

	public static class CustomHeartRateZones {
		private String min;
		private String minutes;
		private String max;
		private String name;
		private String caloriesOut;

		public String getMin() {
			return min;
		}

		public void setMin(String min) {
			this.min = min;
		}

		public String getMinutes() {
			return minutes;
		}

		public void setMinutes(String minutes) {
			this.minutes = minutes;
		}

		public String getMax() {
			return max;
		}

		public void setMax(String max) {
			this.max = max;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCaloriesOut() {
			return caloriesOut;
		}

		public void setCaloriesOut(String caloriesOut) {
			this.caloriesOut = caloriesOut;
		}

		@Override
		public String toString() {
			return "ClassPojo [min = " + min + ", minutes = " + minutes
					+ ", max = " + max + ", name = " + name
					+ ", caloriesOut = " + caloriesOut + "]";
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}