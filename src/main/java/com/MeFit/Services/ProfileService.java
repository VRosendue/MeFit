package com.MeFit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MeFit.Dto.ProfileDto;
import com.MeFit.Models.Profile;
import com.MeFit.Repository.ProfileRepository;

@Service
public class ProfileService {

	
	@Autowired
	private ProfileRepository profileRepository;
	
	
	public Profile updateProfile(Long id, ProfileDto profileDto) {
		Profile profile = profileRepository.findById(id).orElse(null);
		if(profile != null) {
			
		}
	}
	
}
