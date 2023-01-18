package com.MeFit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MeFit.Models.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
