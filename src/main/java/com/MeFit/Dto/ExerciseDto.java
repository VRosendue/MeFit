package com.MeFit.Dto;

import java.util.Set;

import com.MeFit.Models.Exercise;
import com.MeFit.Models.Workout;

public class ExerciseDto {
	
	//Workout workouts, String name, Long id;
	
	private Long id;
	private String name;
	private Set<Workout> workouts;
	
	public ExerciseDto() {}
	
	public ExerciseDto(Exercise exercise) {
		this.id = exercise.getId();
		this.name = exercise.getName();
		this.workouts = exercise.getWorkouts();
		
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

	public Set<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(Set<Workout> workouts) {
		this.workouts = workouts;
	}
	
}


