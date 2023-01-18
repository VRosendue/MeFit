package com.MeFit.Dto;

import com.MeFit.Models.Goal;


public class GoalDto {

	
	private Long id;
	private String name;
	
	public GoalDto() {}
	
	public GoalDto(Goal goal) {
		this.id = goal.getId();
		this.name = goal.getName();
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
