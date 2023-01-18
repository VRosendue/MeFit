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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
	
	
	
	
	
	
	
	

}
