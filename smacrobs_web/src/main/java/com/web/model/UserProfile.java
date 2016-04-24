package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.annotations.SerializedName;

@Document(collection = "userProfile")
public class UserProfile
{
	private User user;
	//private String tiSensorId;

	public User getUser ()
	{
		return user;
	}

	public void setUser (User user)
	{
		this.user = user;
	}
	
	/*public String getTiSensorId() {
		return tiSensorId;
	}

	public void setTiSensorId(String tiSensorId) {
		this.tiSensorId = tiSensorId;
	}*/

	@Override
	public String toString()
	{
		return "ClassPojo [user = "+user+"]";
	}

	public class User
	{
		private String dateOfBirth;

		private String weight;

		private String glucoseUnit;

		private String strideLengthRunningType;

		private String autoStrideEnabled;

		private String foodsLocale;

		private String locale;

		private String averageDailySteps;

		private String startDayOfWeek;

		private String timezone;

		private String avatar150;

		private String height;

		private InactivityAlerts inactivityAlerts;

		private String age;

		private String heightUnit;

		private Features features;

		private String waterUnit;

		private String gender;

		private String strideLengthWalking;

		private String memberSince;

		private SedentaryTime sedentaryTime;

		private String weightUnit;

		private String offsetFromUTCMillis;

		private String avatar;

		private String waterUnitName;

		private String strideLengthWalkingType;

		private String corporate;

		private String strideLengthRunning;

		private TopBadges[] topBadges;

		private String fullName;

		@SerializedName("encodedId")
		private String userId;

		private String distanceUnit;

		private String displayName;

		public String getDateOfBirth ()
		{
			return dateOfBirth;
		}

		public void setDateOfBirth (String dateOfBirth)
		{
			this.dateOfBirth = dateOfBirth;
		}

		public String getWeight ()
		{
			return weight;
		}

		public void setWeight (String weight)
		{
			this.weight = weight;
		}

		public String getGlucoseUnit ()
		{
			return glucoseUnit;
		}

		public void setGlucoseUnit (String glucoseUnit)
		{
			this.glucoseUnit = glucoseUnit;
		}

		public String getStrideLengthRunningType ()
		{
			return strideLengthRunningType;
		}

		public void setStrideLengthRunningType (String strideLengthRunningType)
		{
			this.strideLengthRunningType = strideLengthRunningType;
		}

		public String getAutoStrideEnabled ()
		{
			return autoStrideEnabled;
		}

		public void setAutoStrideEnabled (String autoStrideEnabled)
		{
			this.autoStrideEnabled = autoStrideEnabled;
		}

		public String getFoodsLocale ()
		{
			return foodsLocale;
		}

		public void setFoodsLocale (String foodsLocale)
		{
			this.foodsLocale = foodsLocale;
		}

		public String getLocale ()
		{
			return locale;
		}

		public void setLocale (String locale)
		{
			this.locale = locale;
		}

		public String getAverageDailySteps ()
		{
			return averageDailySteps;
		}

		public void setAverageDailySteps (String averageDailySteps)
		{
			this.averageDailySteps = averageDailySteps;
		}

		public String getStartDayOfWeek ()
		{
			return startDayOfWeek;
		}

		public void setStartDayOfWeek (String startDayOfWeek)
		{
			this.startDayOfWeek = startDayOfWeek;
		}

		public String getTimezone ()
		{
			return timezone;
		}

		public void setTimezone (String timezone)
		{
			this.timezone = timezone;
		}

		public String getAvatar150 ()
		{
			return avatar150;
		}

		public void setAvatar150 (String avatar150)
		{
			this.avatar150 = avatar150;
		}

		public String getHeight ()
		{
			return height;
		}

		public void setHeight (String height)
		{
			this.height = height;
		}

		public InactivityAlerts getInactivityAlerts ()
		{
			return inactivityAlerts;
		}

		public void setInactivityAlerts (InactivityAlerts inactivityAlerts)
		{
			this.inactivityAlerts = inactivityAlerts;
		}

		public String getAge ()
		{
			return age;
		}

		public void setAge (String age)
		{
			this.age = age;
		}

		public String getHeightUnit ()
		{
			return heightUnit;
		}

		public void setHeightUnit (String heightUnit)
		{
			this.heightUnit = heightUnit;
		}

		public Features getFeatures ()
		{
			return features;
		}

		public void setFeatures (Features features)
		{
			this.features = features;
		}

		public String getWaterUnit ()
		{
			return waterUnit;
		}

		public void setWaterUnit (String waterUnit)
		{
			this.waterUnit = waterUnit;
		}

		public String getGender ()
		{
			return gender;
		}

		public void setGender (String gender)
		{
			this.gender = gender;
		}

		public String getStrideLengthWalking ()
		{
			return strideLengthWalking;
		}

		public void setStrideLengthWalking (String strideLengthWalking)
		{
			this.strideLengthWalking = strideLengthWalking;
		}

		public String getMemberSince ()
		{
			return memberSince;
		}

		public void setMemberSince (String memberSince)
		{
			this.memberSince = memberSince;
		}

		public SedentaryTime getSedentaryTime ()
		{
			return sedentaryTime;
		}

		public void setSedentaryTime (SedentaryTime sedentaryTime)
		{
			this.sedentaryTime = sedentaryTime;
		}

		public String getWeightUnit ()
		{
			return weightUnit;
		}

		public void setWeightUnit (String weightUnit)
		{
			this.weightUnit = weightUnit;
		}

		public String getOffsetFromUTCMillis ()
		{
			return offsetFromUTCMillis;
		}

		public void setOffsetFromUTCMillis (String offsetFromUTCMillis)
		{
			this.offsetFromUTCMillis = offsetFromUTCMillis;
		}

		public String getAvatar ()
		{
			return avatar;
		}

		public void setAvatar (String avatar)
		{
			this.avatar = avatar;
		}

		public String getWaterUnitName ()
		{
			return waterUnitName;
		}

		public void setWaterUnitName (String waterUnitName)
		{
			this.waterUnitName = waterUnitName;
		}

		public String getStrideLengthWalkingType ()
		{
			return strideLengthWalkingType;
		}

		public void setStrideLengthWalkingType (String strideLengthWalkingType)
		{
			this.strideLengthWalkingType = strideLengthWalkingType;
		}

		public String getCorporate ()
		{
			return corporate;
		}

		public void setCorporate (String corporate)
		{
			this.corporate = corporate;
		}

		public String getStrideLengthRunning ()
		{
			return strideLengthRunning;
		}

		public void setStrideLengthRunning (String strideLengthRunning)
		{
			this.strideLengthRunning = strideLengthRunning;
		}

		public TopBadges[] getTopBadges ()
		{
			return topBadges;
		}

		public void setTopBadges (TopBadges[] topBadges)
		{
			this.topBadges = topBadges;
		}

		public String getFullName ()
		{
			return fullName;
		}

		public void setFullName (String fullName)
		{
			this.fullName = fullName;
		}


		public String getDistanceUnit ()
		{
			return distanceUnit;
		}

		public void setDistanceUnit (String distanceUnit)
		{
			this.distanceUnit = distanceUnit;
		}

		public String getDisplayName ()
		{
			return displayName;
		}

		public void setDisplayName (String displayName)
		{
			this.displayName = displayName;
		}

		@Override
		public String toString()
		{
			return "ClassPojo [dateOfBirth = "+dateOfBirth+", weight = "+weight+", glucoseUnit = "+glucoseUnit+", strideLengthRunningType = "+strideLengthRunningType+", autoStrideEnabled = "+autoStrideEnabled+", foodsLocale = "+foodsLocale+", locale = "+locale+", averageDailySteps = "+averageDailySteps+", startDayOfWeek = "+startDayOfWeek+", timezone = "+timezone+", avatar150 = "+avatar150+", height = "+height+", inactivityAlerts = "+inactivityAlerts+", age = "+age+", heightUnit = "+heightUnit+", features = "+features+", waterUnit = "+waterUnit+", gender = "+gender+", strideLengthWalking = "+strideLengthWalking+", memberSince = "+memberSince+", sedentaryTime = "+sedentaryTime+", weightUnit = "+weightUnit+", offsetFromUTCMillis = "+offsetFromUTCMillis+", avatar = "+avatar+", waterUnitName = "+waterUnitName+", strideLengthWalkingType = "+strideLengthWalkingType+", corporate = "+corporate+", strideLengthRunning = "+strideLengthRunning+", topBadges = "+topBadges+", fullName = "+fullName+", userId = "+userId+", distanceUnit = "+distanceUnit+", displayName = "+displayName+"]";
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}
	}

	public class TopBadges
	{
		private String image75px;

		private String earnedMessage;

		private String shareImage640px;

		private String dateTime;

		private String image50px;

		private String badgeGradientEndColor;

		private String timesAchieved;

		private String mobileDescription;

		private String marketingDescription;

		private String category;

		private String shortDescription;

		private String badgeGradientStartColor;

		private String description;

		private String name;

		private String image125px;

		private String value;

		private String shareText;

		private String[] cheers;

		private String shortName;

		private String encodedId;

		private String image300px;

		private String badgeType;

		private String image100px;

		public String getImage75px ()
		{
			return image75px;
		}

		public void setImage75px (String image75px)
		{
			this.image75px = image75px;
		}

		public String getEarnedMessage ()
		{
			return earnedMessage;
		}

		public void setEarnedMessage (String earnedMessage)
		{
			this.earnedMessage = earnedMessage;
		}

		public String getShareImage640px ()
		{
			return shareImage640px;
		}

		public void setShareImage640px (String shareImage640px)
		{
			this.shareImage640px = shareImage640px;
		}

		public String getDateTime ()
		{
			return dateTime;
		}

		public void setDateTime (String dateTime)
		{
			this.dateTime = dateTime;
		}

		public String getImage50px ()
		{
			return image50px;
		}

		public void setImage50px (String image50px)
		{
			this.image50px = image50px;
		}

		public String getBadgeGradientEndColor ()
		{
			return badgeGradientEndColor;
		}

		public void setBadgeGradientEndColor (String badgeGradientEndColor)
		{
			this.badgeGradientEndColor = badgeGradientEndColor;
		}

		public String getTimesAchieved ()
		{
			return timesAchieved;
		}

		public void setTimesAchieved (String timesAchieved)
		{
			this.timesAchieved = timesAchieved;
		}

		public String getMobileDescription ()
		{
			return mobileDescription;
		}

		public void setMobileDescription (String mobileDescription)
		{
			this.mobileDescription = mobileDescription;
		}

		public String getMarketingDescription ()
		{
			return marketingDescription;
		}

		public void setMarketingDescription (String marketingDescription)
		{
			this.marketingDescription = marketingDescription;
		}

		public String getCategory ()
		{
			return category;
		}

		public void setCategory (String category)
		{
			this.category = category;
		}

		public String getShortDescription ()
		{
			return shortDescription;
		}

		public void setShortDescription (String shortDescription)
		{
			this.shortDescription = shortDescription;
		}

		public String getBadgeGradientStartColor ()
		{
			return badgeGradientStartColor;
		}

		public void setBadgeGradientStartColor (String badgeGradientStartColor)
		{
			this.badgeGradientStartColor = badgeGradientStartColor;
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

		public String getImage125px ()
		{
			return image125px;
		}

		public void setImage125px (String image125px)
		{
			this.image125px = image125px;
		}

		public String getValue ()
		{
			return value;
		}

		public void setValue (String value)
		{
			this.value = value;
		}

		public String getShareText ()
		{
			return shareText;
		}

		public void setShareText (String shareText)
		{
			this.shareText = shareText;
		}

		public String[] getCheers ()
		{
			return cheers;
		}

		public void setCheers (String[] cheers)
		{
			this.cheers = cheers;
		}

		public String getShortName ()
		{
			return shortName;
		}

		public void setShortName (String shortName)
		{
			this.shortName = shortName;
		}

		public String getEncodedId ()
		{
			return encodedId;
		}

		public void setEncodedId (String encodedId)
		{
			this.encodedId = encodedId;
		}

		public String getImage300px ()
		{
			return image300px;
		}

		public void setImage300px (String image300px)
		{
			this.image300px = image300px;
		}

		public String getBadgeType ()
		{
			return badgeType;
		}

		public void setBadgeType (String badgeType)
		{
			this.badgeType = badgeType;
		}

		public String getImage100px ()
		{
			return image100px;
		}

		public void setImage100px (String image100px)
		{
			this.image100px = image100px;
		}

		@Override
		public String toString()
		{
			return "ClassPojo [image75px = "+image75px+", earnedMessage = "+earnedMessage+", shareImage640px = "+shareImage640px+", dateTime = "+dateTime+", image50px = "+image50px+", badgeGradientEndColor = "+badgeGradientEndColor+", timesAchieved = "+timesAchieved+", mobileDescription = "+mobileDescription+", marketingDescription = "+marketingDescription+", category = "+category+", shortDescription = "+shortDescription+", badgeGradientStartColor = "+badgeGradientStartColor+", description = "+description+", name = "+name+", image125px = "+image125px+", value = "+value+", shareText = "+shareText+", cheers = "+cheers+", shortName = "+shortName+", encodedId = "+encodedId+", image300px = "+image300px+", badgeType = "+badgeType+", image100px = "+image100px+"]";
		}
	}

	public class SedentaryTime
	{
		private String startTime;

		private String duration;

		public String getStartTime ()
		{
			return startTime;
		}

		public void setStartTime (String startTime)
		{
			this.startTime = startTime;
		}

		public String getDuration ()
		{
			return duration;
		}

		public void setDuration (String duration)
		{
			this.duration = duration;
		}

		@Override
		public String toString()
		{
			return "ClassPojo [startTime = "+startTime+", duration = "+duration+"]";
		}
	}


	public class InactivityAlerts
	{
		private String[] weekDays;

		public String[] getWeekDays ()
		{
			return weekDays;
		}

		public void setWeekDays (String[] weekDays)
		{
			this.weekDays = weekDays;
		}

		@Override
		public String toString()
		{
			return "ClassPojo [weekDays = "+weekDays+"]";
		}
	}

	public class Features
	{
		private String exerciseGoal;

		public String getExerciseGoal ()
		{
			return exerciseGoal;
		}

		public void setExerciseGoal (String exerciseGoal)
		{
			this.exerciseGoal = exerciseGoal;
		}

		@Override
		public String toString()
		{
			return "ClassPojo [exerciseGoal = "+exerciseGoal+"]";
		}
	}



}