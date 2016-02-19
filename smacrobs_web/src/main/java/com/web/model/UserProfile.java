package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userprofile")
public class UserProfile {
	 String age;
	 String avatar;
     String gender;
     String height;
     String dateOfBirth;
     String fullName;
     String weight;
     
     public UserProfile(String am,String av,String gen,String hei, String dob,String fn,String wei)
     {
    	 age=am;
    	 avatar=av;
    	 gender=gen;
    	 height=hei;
    	 dateOfBirth=dob;
    	 fullName=fn;
    	 weight=wei;
     }

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
     

}
