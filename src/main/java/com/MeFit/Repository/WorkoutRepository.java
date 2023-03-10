package com.MeFit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MeFit.Models.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
