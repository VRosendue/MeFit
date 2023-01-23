package com.MeFit.Dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.MeFit.Models.Goal;
import com.MeFit.Models.Users;
import com.MeFit.Models.Workout;


public class GoalDto {

	
	private Long id;
	private String name;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private Set<Users> users = new HashSet<>();
	private List<Workout> workouts = new ArrayList<>();
	
	
	
	
	public GoalDto() {}
	
	public GoalDto(Goal goal) {
		this.id = goal.getId();
		this.name = goal.getName();
		this.description = goal.getDescription();
		this.startDate = goal.getStartDate();
		this.endDate = goal.getEndDate();
		this.users = goal.getUsers();
		this.workouts = goal.getWorkouts();
		
		
		
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

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
