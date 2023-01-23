package com.MeFit.Services;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MeFit.Dto.ProfileDto;
import com.MeFit.Models.Gender;
import com.MeFit.Models.Profile;
import com.MeFit.Models.Users;
import com.MeFit.Repository.ProfileRepository;
import com.MeFit.Repository.UsersRepository;
import com.MeFit.Utils.ProfileNotFoundException;
import com.MeFit.Utils.UsersNotFoundException;

@Service
public class ProfileService {
	
	private final ProfileRepository profileRepository;
	private final UsersRepository usersRepository;

	
	@Autowired
	public ProfileService(ProfileRepository profileRepository, UsersRepository usersRepository) {
	this.profileRepository = profileRepository;
	this.usersRepository = usersRepository;
	}

	public Profile getProfile(Long id) {
		return profileRepository.findById(id).orElseThrow(() -> new ProfileNotFoundException("Profile not found"));
	}

	public Profile createProfile(ProfileDto profileDto) {
		Profile profile = new Profile();
		profile.setAboutMe(profileDto.getAboutMe());
		profile.setAge(profileDto.getAge());
		profile.setGender(profileDto.getGender());
		profile.setHeight(profileDto.getHeight());
		profile.setWeight(profileDto.getWeight());
		return profileRepository.save(profile);
	}

	public Profile updateProfile(Long id, Map<String, Object> updates) {
		Profile profile = profileRepository.findById(id)
				.orElseThrow(() -> new ProfileNotFoundException("Profile not found"));
		updates.forEach((key, value) -> {
			switch (key) {
			case "AboutMe":
				profile.setAboutMe((String) value);
				break;
			case "Age":
				profile.setAge((Integer) value);
				break;
			case "Gender":
				profile.setGender((Gender) value);
				break;
			case "Height":
				profile.setHeight((BigDecimal) value);
				break;
			case "Weight":
				profile.setWeight((BigDecimal) value);
				break;
			default:
				break;
				
				//name, users, workouts
			}
		});
		return profileRepository.save(profile);
	}

	public void deleteProfile(Long profileId, Long usersId) {
		Profile profile = profileRepository.findById(profileId)
				.orElseThrow(() -> new ProfileNotFoundException("Profile not found"));
		Users user = usersRepository.findById(usersId).orElseThrow(() -> new UsersNotFoundException("User not found"));
		if (!profile.getUser().getId().equals(usersId)) {
			throw new IllegalArgumentException("This user does not own the profile");
		}
		profileRepository.delete(profile);
	}

}

