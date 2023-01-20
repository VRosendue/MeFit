package com.MeFit.Models;

import java.util.HashSet;
import java.util.Set;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@Table(name="Users") //User is reserved in H2-Console, which means the name of the table has to be different
public class Users {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
	private String salt;
	
	
	//Would be a good idea to add an enum with Roles, and add private String role in this section
	
	
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name = "user_goal", joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "goal_id"))
	private Set<Goal> goals = new HashSet<>();
	
	 
	//Using library for password hashing - check mvn dependencies for JBCrypt
	public void setPassword(String password) {
		this.salt = BCrypt.gensalt();
		this.password = BCrypt.hashpw(password, this.salt);
	}
	
	public boolean checkPassword(String password) {
		return BCrypt.checkpw(password, this.password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Set<Goal> getGoals() {
		return goals;
	}

	public void setGoals(Set<Goal> goals) {
		this.goals = goals;
	}

	public String getPassword() {
		return password;
	}
	
	
	
}
