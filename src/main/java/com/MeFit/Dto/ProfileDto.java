package com.MeFit.Dto;

import java.math.BigDecimal;

import com.MeFit.Models.Gender;
import com.MeFit.Models.Goal;
import com.MeFit.Models.Users;

public class ProfileDto {

	// Long id, Users user, Int age, Gender gender, BigDecimal height, BigDecimal weight, BigDecimal bmi, String aboutMe
	private Long id;
	private Users user;
	private Integer age;
	private Gender gender;
	private BigDecimal height;
	private BigDecimal weight;
	private BigDecimal bmi;
	private String aboutMe;
	
	
	public ProfileDto() {}
	
	public ProfileDto(Profile profile) {
		this.id = profile.getId();
		this.user = user.getUser();
		this.age = profile.getAge();
		this.gender = profile.getGender();
		this.height = profile.getHeight();
		this.weight = profile.getWeight();
		this.bmi = profile.getBmi();
		this.aboutMe = profile.getAboutMe();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getBmi() {
		return bmi;
	}

	public void setBmi(BigDecimal bmi) {
		this.bmi = bmi;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
	
}


