package com.neilly.peely.service;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.Workout;
import com.neilly.peely.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private AccountHolderService accountHolderService;

    public static final String SECURITY_EXCEPTION_MESSAGE = "Invalid Workout input for User";

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkoutsByUsername(String username) {
        return workoutRepository.findByAccountHolder_Username(username);
    }

    public Optional<Workout> getWorkoutById(Long id){
        return workoutRepository.findById(id);
    }

    public List<Workout> getAllWorkoutsByUsernameAndDate(String username, Date date){
        return workoutRepository.findByDateAndAccountHolderUsername(date, username);
    }

    public void addWorkout(Workout workout, Authentication authentication){
            AccountHolder accountHolder = accountHolderService.getByUsername(authentication.getName());
            workout.setAccountHolder(accountHolder);
            workoutRepository.save(workout);
    }

}
