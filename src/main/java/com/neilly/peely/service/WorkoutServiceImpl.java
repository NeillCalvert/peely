package com.neilly.peely.service;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.Exercise;
import com.neilly.peely.model.Workout;
import com.neilly.peely.repository.AccountHolderRepository;
import com.neilly.peely.repository.ExerciseRepository;
import com.neilly.peely.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutServiceImpl implements WorkoutService{

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

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
            Optional<AccountHolder> accountHolder = accountHolderRepository.findByUsername(authentication.getName());
            if(accountHolder.isPresent()){
                workout.setAccountHolder(accountHolder.get());
                workoutRepository.save(workout);
            }
    }

    public void addExerciseToWorkout(Long exerciseId, Long workoutId, String username){
        Optional<Workout> oldWorkout = workoutRepository.findByIdAndAccountHolderUsername(workoutId, username);
        Optional<Exercise> exerciseToAdd = exerciseRepository.findById(exerciseId);

        if(oldWorkout.isPresent() && exerciseToAdd.isPresent()){
            Workout updatedWorkout = oldWorkout.get();
            updatedWorkout.getExercises().add(exerciseToAdd.get());
            workoutRepository.save(updatedWorkout);
        }

    }

}
