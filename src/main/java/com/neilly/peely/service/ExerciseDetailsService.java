package com.neilly.peely.service;

import com.neilly.peely.model.ExerciseDetails;

public interface ExerciseDetailsService {
    void addExerciseDetailsToExercise(ExerciseDetails exerciseDetails, Long exerciseId, String username);
    void updateExerciseDetails(ExerciseDetails exerciseDetails, String username);
}
