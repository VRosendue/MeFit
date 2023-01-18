package com.MeFit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MeFit.Models.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
