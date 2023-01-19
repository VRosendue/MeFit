package com.MeFit.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@Table(name = "Goal")
public class Goal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	


	@Column
	private String name;
	
	@ManyToMany(mappedBy = "goals")
	private Set<Users> users = new HashSet<>();
	
	
	@OneToMany(mappedBy = "goals", cascade = CascadeType.ALL)
	private List<Workout> workouts = new ArrayList<>();
	
	
	
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
	

}
