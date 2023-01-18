package com.MeFit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MeFit.Models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	boolean findByEmail(String email);

}
