package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userProfile")
public class UserProfile
{
	private String dateOfBirth;

	private String weight;

	private String glucoseUnit;

	private String foodsLocale;

	private String locale;

	private String state;

	private String aboutMe;

	private String city;

	private String startDayOfWeek;

	private String timezone;

	private String avatar150;

	private String height;

	private String heightUnit;

	private String waterUnit;

	private String gender;

	private String strideLengthWalking;

	private String memberSince;

	private String weightUnit;

	private String nickname;

	private String offsetFromUTCMillis;

	private String avatar;

	private String country;

	private String strideLengthRunning;

	private String fullName;

	public String toString() {
		return "UserProfile{" +
				"dateOfBirth='" + dateOfBirth + '\'' +
				", weight='" + weight + '\'' +
				", glucoseUnit='" + glucoseUnit + '\'' +
				", foodsLocale='" + foodsLocale + '\'' +
				", locale='" + locale + '\'' +
				", state='" + state + '\'' +
				", aboutMe='" + aboutMe + '\'' +
				", city='" + city + '\'' +
				", startDayOfWeek='" + startDayOfWeek + '\'' +
				", timezone='" + timezone + '\'' +
				", avatar150='" + avatar150 + '\'' +
				", height='" + height + '\'' +
				", heightUnit='" + heightUnit + '\'' +
				", waterUnit='" + waterUnit + '\'' +
				", gender='" + gender + '\'' +
				", strideLengthWalking='" + strideLengthWalking + '\'' +
				", memberSince='" + memberSince + '\'' +
				", weightUnit='" + weightUnit + '\'' +
				", nickname='" + nickname + '\'' +
				", offsetFromUTCMillis='" + offsetFromUTCMillis + '\'' +
				", avatar='" + avatar + '\'' +
				", country='" + country + '\'' +
				", strideLengthRunning='" + strideLengthRunning + '\'' +
				", fullName='" + fullName + '\'' +
				", encodedId='" + encodedId + '\'' +
				", distanceUnit='" + distanceUnit + '\'' +
				", displayName='" + displayName + '\'' +
				'}';
	}

	// store this field as userId, this is the primary key
	private String encodedId;

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

	public String getState ()
	{
		return state;
	}

	public void setState (String state)
	{
		this.state = state;
	}

	public String getAboutMe ()
	{
		return aboutMe;
	}

	public void setAboutMe (String aboutMe)
	{
		this.aboutMe = aboutMe;
	}

	public String getCity ()
	{
		return city;
	}

	public void setCity (String city)
	{
		this.city = city;
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

	public String getHeightUnit ()
	{
		return heightUnit;
	}

	public void setHeightUnit (String heightUnit)
	{
		this.heightUnit = heightUnit;
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

	public String getWeightUnit ()
	{
		return weightUnit;
	}

	public void setWeightUnit (String weightUnit)
	{
		this.weightUnit = weightUnit;
	}

	public String getNickname ()
	{
		return nickname;
	}

	public void setNickname (String nickname)
	{
		this.nickname = nickname;
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

	public String getCountry ()
	{
		return country;
	}

	public void setCountry (String country)
	{
		this.country = country;
	}

	public String getStrideLengthRunning ()
	{
		return strideLengthRunning;
	}

	public void setStrideLengthRunning (String strideLengthRunning)
	{
		this.strideLengthRunning = strideLengthRunning;
	}

	public String getFullName ()
	{
		return fullName;
	}

	public void setFullName (String fullName)
	{
		this.fullName = fullName;
	}

	public String getEncodedId ()
	{
		return encodedId;
	}

	public void setEncodedId (String encodedId)
	{
		this.encodedId = encodedId;
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

	public void setDisplayName (String displayName) {
		this.displayName = displayName;
	}
}