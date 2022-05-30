package com.neilly.peely.service;

import com.neilly.peely.model.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    Optional<Exercise> findByName(String name);
    List<Exercise> findByAccountHolder(String username);
    Optional<Exercise> findById(Long id);
    void addExercise(Exercise exercise);
}
