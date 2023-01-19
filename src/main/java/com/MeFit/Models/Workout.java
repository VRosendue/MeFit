package com.MeFit.Models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@Table(name = "Workout")
public class Workout {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String name;
	
	@Column
	private Date completedOn;
	
	@ManyToOne
	@JoinColumn(name = "goals_id")
	private Goal goals;
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name = "workout_exercise",
    joinColumns = @JoinColumn(name = "workout_id"),
    inverseJoinColumns = @JoinColumn(name = "exercise_id"))
	private Set<Exercise> exercises = new HashSet<>();

	

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
