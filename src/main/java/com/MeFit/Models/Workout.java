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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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

}
