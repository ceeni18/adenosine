package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activityDetails")
public class ActivityDetails
{
	private String userId;
	
	private String date;
	
	private Summary summary;

	private Goals goals;

	private Activities[] activities;

	public Summary getSummary ()
	{
		return summary;
	}

	public void setSummary (Summary summary)
	{
		this.summary = summary;
	}

	public Goals getGoals ()
	{
		return goals;
	}

	public void setGoals (Goals goals)
	{
		this.goals = goals;
	}

	public Activities[] getActivities()
	{
		return activities;
	}

	public void setActivities (Activities[] activities)
	{
		this.activities = activities;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [summary = "+summary+", goals = "+goals+", activities = "+activities+"]";
	}

	public static class Summary
	{
		private String fairlyActiveMinutes;

		private String caloriesBMR;

		private String marginalCalories;

		private String floors;

		private String sedentaryMinutes;

		private String elevation;

		private String lightlyActiveMinutes;

		private String activityCalories;

		private String steps;

		private String veryActiveMinutes;

		private Distances[] distances;

		private String caloriesOut;

		public String getFairlyActiveMinutes ()
		{
			return fairlyActiveMinutes;
		}

		public void setFairlyActiveMinutes (String fairlyActiveMinutes)
		{
			this.fairlyActiveMinutes = fairlyActiveMinutes;
		}

		public String getCaloriesBMR ()
		{
			return caloriesBMR;
		}

		public void setCaloriesBMR (String caloriesBMR)
		{
			this.caloriesBMR = caloriesBMR;
		}

		public String getMarginalCalories ()
		{
			return marginalCalories;
		}

		public void setMarginalCalories (String marginalCalories)
		{
			this.marginalCalories = marginalCalories;
		}

		public String getFloors ()
		{
			return floors;
		}

		public void setFloors (String floors)
		{
			this.floors = floors;
		}

		public String getSedentaryMinutes ()
		{
			return sedentaryMinutes;
		}

		public void setSedentaryMinutes (String sedentaryMinutes)
		{
			this.sedentaryMinutes = sedentaryMinutes;
		}

		public String getElevation ()
		{
			return elevation;
		}

		public void setElevation (String elevation)
		{
			this.elevation = elevation;
		}

		public String getLightlyActiveMinutes ()
		{
			return lightlyActiveMinutes;
		}

		public void setLightlyActiveMinutes (String lightlyActiveMinutes)
		{
			this.lightlyActiveMinutes = lightlyActiveMinutes;
		}

		public String getActivityCalories ()
		{
			return activityCalories;
		}

		public void setActivityCalories (String activityCalories)
		{
			this.activityCalories = activityCalories;
		}

		public String getSteps ()
		{
			return steps;
		}

		public void setSteps (String steps)
		{
			this.steps = steps;
		}

		public String getVeryActiveMinutes ()
		{
			return veryActiveMinutes;
		}

		public void setVeryActiveMinutes (String veryActiveMinutes)
		{
			this.veryActiveMinutes = veryActiveMinutes;
		}

		public Distances[] getDistances ()
		{
			return distances;
		}

		public void setDistances (Distances[] distances)
		{
			this.distances = distances;
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
			return "ClassPojo [fairlyActiveMinutes = "+fairlyActiveMinutes+", caloriesBMR = "+caloriesBMR+", marginalCalories = "+marginalCalories+", floors = "+floors+", sedentaryMinutes = "+sedentaryMinutes+", elevation = "+elevation+", lightlyActiveMinutes = "+lightlyActiveMinutes+", activityCalories = "+activityCalories+", steps = "+steps+", veryActiveMinutes = "+veryActiveMinutes+", distances = "+distances+", caloriesOut = "+caloriesOut+"]";
		}
	}

	public static class Distances
	{
		private String distance;

		private String activity;

		public String getDistance ()
		{
			return distance;
		}

		public void setDistance (String distance)
		{
			this.distance = distance;
		}

		public String getActivity ()
		{
			return activity;
		}

		public void setActivity (String activity)
		{
			this.activity = activity;
		}

		@Override
		public String toString()
		{
			return "ClassPojo [distance = "+distance+", activity = "+activity+"]";
		}
	}
	public static class Goals
	{
		private String distance;

		private String floors;

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
			return "ClassPojo [distance = "+distance+", floors = "+floors+", steps = "+steps+", caloriesOut = "+caloriesOut+"]";
		}
	}

	public static class Activities
	{
		private String startTime;

		private String activityId;

		private String duration;

		private String distance;

		private String logId;

		private String description;

		private String name;

		private String isFavorite;

		private String hasStartTime;

		private String calories;

		private String steps;

		private String activityParentId;

		public String getStartTime ()
		{
			return startTime;
		}

		public void setStartTime (String startTime)
		{
			this.startTime = startTime;
		}

		public String getActivityId ()
		{
			return activityId;
		}

		public void setActivityId (String activityId)
		{
			this.activityId = activityId;
		}

		public String getDuration ()
		{
			return duration;
		}

		public void setDuration (String duration)
		{
			this.duration = duration;
		}

		public String getDistance ()
		{
			return distance;
		}

		public void setDistance (String distance)
		{
			this.distance = distance;
		}

		public String getLogId ()
		{
			return logId;
		}

		public void setLogId (String logId)
		{
			this.logId = logId;
		}

		public String getDescription ()
		{
			return description;
		}

		public void setDescription (String description)
		{
			this.description = description;
		}

		public String getName ()
		{
			return name;
		}

		public void setName (String name)
		{
			this.name = name;
		}

		public String getIsFavorite ()
		{
			return isFavorite;
		}

		public void setIsFavorite (String isFavorite)
		{
			this.isFavorite = isFavorite;
		}

		public String getHasStartTime ()
		{
			return hasStartTime;
		}

		public void setHasStartTime (String hasStartTime)
		{
			this.hasStartTime = hasStartTime;
		}

		public String getCalories ()
		{
			return calories;
		}

		public void setCalories (String calories)
		{
			this.calories = calories;
		}

		public String getSteps ()
		{
			return steps;
		}

		public void setSteps (String steps)
		{
			this.steps = steps;
		}

		public String getActivityParentId ()
		{
			return activityParentId;
		}

		public void setActivityParentId (String activityParentId)
		{
			this.activityParentId = activityParentId;
		}

		@Override
		public String toString()
		{
			return "ClassPojo [startTime = "+startTime+", activityId = "+activityId+", duration = "+duration+", distance = "+distance+", logId = "+logId+", description = "+description+", name = "+name+", isFavorite = "+isFavorite+", hasStartTime = "+hasStartTime+", calories = "+calories+", steps = "+steps+", activityParentId = "+activityParentId+"]";
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
