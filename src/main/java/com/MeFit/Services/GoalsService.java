package com.MeFit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.MeFit.Dto.GoalDto;
import com.MeFit.Dto.UsersDto;
import com.MeFit.Dto.WorkoutDto;
import com.MeFit.Models.Goal;
import com.MeFit.Repository.GoalRepository;
import com.MeFit.Repository.UsersRepository;
import com.MeFit.Repository.WorkoutRepository;
import com.MeFit.Utils.GoalsNotFoundException;

@Service
public class GoalsService {
	
	
	@Autowired
	private final GoalRepository goalRepository;
	private final WorkoutRepository workoutRepository;
	private final UsersRepository usersRepository;
	

	public GoalsService(GoalRepository goalRepository, WorkoutRepository workoutRepository, UsersRepository usersRepository) {
		this.goalRepository = goalRepository;
		this.usersRepository = usersRepository;
		this.workoutRepository = workoutRepository;
		
	}
	
	
	public Goal getGoal(Long id) {
		return goalRepository.findById(id).orElseThrow(() -> new GoalsNotFoundException("Goal not found"));
	}
	
	
	public Goal createGoal(GoalDto goalDto, UsersDto usersDto, WorkoutDto workoutDto) {
			Goal goal = new Goal();
			goal.setName(goalDto.getName());
			goal.setUsers(goalDto.getUsers());
			goal.setWorkouts(goalDto.getWorkouts());
			
			return goalRepository.save(goal);
		}
	
	
	public Goal updateGoal(Long id, GoalDto goalDto) {
		Goal goal = goalRepository.findById(id).orElseThrow(() -> new GoalsNotFoundException("Goal with that ID not found"));
		goal.setName(goalDto.getName());
		goal.setDescription(goalDto.getDescription());
		goal.setStartDate(goalDto.getStartDate());
		goal.setEndDate(goalDto.getEndDate());
		return goalRepository.save(goal);
	}
	
	//Need to rename Id names on the different models so I don't have multiple matches on Id commands
	@PreAuthorize("hasRole('CONTRIBUTOR')")
	public void deleteGoal(Long id) {
		if(goalRepository.existsById(id)) {
			goalRepository.deleteById(id); 
		} else {
			throw new GoalsNotFoundException("Goal with that ID not found");
		}
		
	}
	
	
	
		
}


	

