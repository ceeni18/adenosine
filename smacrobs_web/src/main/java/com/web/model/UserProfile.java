package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userProfile")
public class UserProfile {
    private final String userId;
    private final String fullName;

    private final String age;
    private final String avatar;
    private final String gender;
    private final String dateOfBirth;
    private final String tiSensorId;

	private UserProfile(UserProfileBuidler builder){
		// required parameters
		this.userId = builder.userId;
		this.fullName = builder.fullname;

		// optional parameters
		this.tiSensorId = builder.tiSensorId;
		this.gender = builder.gender;
		this.age = builder.age;
		this.dateOfBirth = builder.dateOfBirth;
		this.avatar = builder.avatar;
	}

	public static class UserProfileBuilder{
		private final String userId;
		private final String fullName;

		private String tiSensorId;
		private String gender;
		private String age;
		private String dateOfBirth;
		private String avatar;

		public UserProfileBuilder(String userId, String fullName){
			this.userId = userId;
			this.fullName = fullName;
		}

		public UserProfileBuilder setTiSensorId(String tiSensorId){
			this.tiSensorId = tiSensorId;
			return this;
		}

		public UserProfileBuilder setGender(String gender){
			this.gender = gender;
			return this;
		}

		public UserProfileBuilder setAge(String age){
			this.age = age;
			return this;
		}

		public UserProfileBuilder setDateOfBirth(String dateOfBirth){
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public UserProfileBuilder setAvatar(String url){
			this.avatar = url;
			return this;
		}

		public UserProfile build(){
			return new UserProfile(this);
		}
	}

    public String getAge() {
        return age;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserId() {
        return userId;
    }

    public String getTiSensorId() {
        return tiSensorId;
    }
}