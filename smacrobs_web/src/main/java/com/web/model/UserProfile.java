package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userProfile")
public class UserProfile {
	 String age;
	 String avatar;
     String gender;
     String dateOfBirth;
     String fullName;
     
     public UserProfile(String am,String av,String gen, String dob,String fn)
     {
    	 age=am;
    	 avatar=av;
    	 gender=gen;
    	 dateOfBirth=dob;
    	 fullName=fn;
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
}