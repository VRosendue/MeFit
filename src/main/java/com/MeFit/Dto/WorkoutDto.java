package com.MeFit.Dto;

import java.util.Date;
import java.util.Set;

import com.MeFit.Models.Exercise;
import com.MeFit.Models.Goal;
import com.MeFit.Models.Workout;

public class WorkoutDto {
	
	//Long id, String name, Date completedOn, Goal goals, Set<Exercise> exercises
	
	private Long id;
	private String name;
	private Date completedOn;
	private Goal goals;
	private Set<Exercise> exercises;
	
	
	public WorkoutDto() {}
	
	public WorkoutDto(Workout workout) {
		this.id = workout.getId();
		this.name = workout.getName();
		this.completedOn = workout.getCompletedOn();
		this.goals = workout.getGoals();
		this.exercises = workout.getExercises();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(Date completedOn) {
		this.completedOn = completedOn;
	}

	public Goal getGoals() {
		return goals;
	}

	public void setGoals(Goal goals) {
		this.goals = goals;
	}

	public Set<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(Set<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	
	
	

}
