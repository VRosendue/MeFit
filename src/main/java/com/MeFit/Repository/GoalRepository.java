package com.MeFit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MeFit.Models.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

}
