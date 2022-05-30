package com.neilly.peely.service;

import com.neilly.peely.model.Workout;
import org.springframework.security.core.Authentication;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface WorkoutService {
    List<Workout> getAllWorkoutsByUsername(String username);
    Optional<Workout> getWorkoutById(Long id);
    List<Workout> getAllWorkoutsByUsernameAndDate(String username, Date date);
    void addWorkout(Workout workout, Authentication authentication);
    void addExerciseToWorkout(Long exerciseId, Long workoutId, String username);
}
