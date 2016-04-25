package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activityGoalDetails")
public class ActivityGoalDetails {

	private Goals goals;
	
	private String userId;
	
	private String date;

	public Goals getGoals ()
	{
		return goals;
	}

	public void setGoals (Goals goals)
	{
		this.goals = goals;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [goals = "+goals+"]";
	}

	public static class Goals
	{
		private String distance;

		private String floors;

		private String activeMinutes;

		private String steps;

		private String caloriesOut;

		public String getDistance ()
		{
			return distance;
		}

		public void setDistance (String distance)
		{
			this.distance = distance;
		}

		public String getFloors ()
		{
			return floors;
		}

		public void setFloors (String floors)
		{
			this.floors = floors;
		}

		public String getActiveMinutes ()
		{
			return activeMinutes;
		}

		public void setActiveMinutes (String activeMinutes)
		{
			this.activeMinutes = activeMinutes;
		}

		public String getSteps ()
		{
			return steps;
		}

		public void setSteps (String steps)
		{
			this.steps = steps;
		}

		public String getCaloriesOut ()
		{
			return caloriesOut;
		}

		public void setCaloriesOut (String caloriesOut)
		{
			this.caloriesOut = caloriesOut;
		}

		@Override
		public String toString()
		{
			return "ClassPojo [distance = "+distance+", floors = "+floors+", activeMinutes = "+activeMinutes+", steps = "+steps+", caloriesOut = "+caloriesOut+"]";
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
