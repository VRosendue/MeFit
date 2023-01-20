package com.MeFit.Services;

import java.nio.file.AccessDeniedException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.MeFit.Dto.UsersDto;
import com.MeFit.Models.Users;
import com.MeFit.Repository.UsersRepository;
import com.MeFit.Utils.UsersNotFoundException;

@Service
public class UsersService {
	
	
	private final UsersRepository usersRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UsersService(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usersRepository = usersRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	
	public Users getUser(Long id) {
		return usersRepository.findById(id).orElseThrow(() -> new UsersNotFoundException("Users not found"));
		
	}
	
	
	public Users getCurrentUser(Principal principal) {
		return usersRepository.findByUsername(principal.getName()).orElseThrow(() -> new UsersNotFoundException("User not found"));
	}
	
	public Users createNewUser(UsersDto usersDto) {
		Users user = new Users();
		user.setEmail(usersDto.getEmail());
		user.setUsername(usersDto.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(usersDto.getPassword()));
		
		return usersRepository.save(user);
	}
	
	
	public Users updatePassword(String newPassword, Long id, Principal principal) throws AccessDeniedException {
		Users user =
		usersRepository.findById(id).orElseThrow(() -> new UsersNotFoundException("Could not find user"));
		if (principal.getName().equals(user.getUsername())) {
			user.setPassword(bCryptPasswordEncoder.encode(newPassword));
			return usersRepository.save(user);
		} else {
			throw new AccessDeniedException("Unable to change password");
		}
	}
	
	public void deleteUser(Long id, Principal principal) throws AccessDeniedException {
		Users user = 
				usersRepository.findById(id).orElseThrow(() -> new UsersNotFoundException("User not found"));
		if(principal.getName().equals(user.getUsername())) {
			usersRepository.delete(user);
		} else {
			throw new AccessDeniedException("You are not allowed to delete this user");
		}
	}
	

}
