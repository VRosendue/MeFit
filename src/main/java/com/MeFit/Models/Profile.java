package com.MeFit.Models;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@Table(name = "Profile")

public class Profile {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column
	private BigDecimal height;
	
	@Column
	private BigDecimal weight;
	
	@Column
	private BigDecimal bmi;
	
	
	@PrePersist
	@PreUpdate
	public void calculateBMI() {
		if (height != null && weight != null) {
			bmi = weight.divide(height.pow(2), 2, RoundingMode.HALF_UP);
			
		}
	}
	
	
	@Column
	private String aboutMe;
	


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
