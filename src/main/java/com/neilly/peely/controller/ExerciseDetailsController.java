package com.neilly.peely.controller;

import com.neilly.peely.aspect.GenericLogger;
import com.neilly.peely.model.ExerciseDetails;
import com.neilly.peely.service.ExerciseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exerciseDetails")
public class ExerciseDetailsController {
    @Autowired
    private ExerciseDetailsService exerciseDetailsService;

    @ResponseStatus(HttpStatus.OK)
    @GenericLogger(logCustomMessage = true, customMessage = "Adding exercise details", logMethodArgs = true)
    @PostMapping("/addExerciseDetails")
    public void addExerciseDetailsToExercise(@RequestBody ExerciseDetails exerciseDetails, Long exerciseId, Authentication authentication){
        exerciseDetailsService.addExerciseDetailsToExercise(exerciseDetails, exerciseId, authentication.getName());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GenericLogger(logCustomMessage = true, customMessage = "Adding exercise details", logMethodArgs = true)
    @PostMapping("/updateExerciseDetails")
    public void updateExerciseDetails(@RequestBody ExerciseDetails exerciseDetails, Authentication authentication){
        exerciseDetailsService.updateExerciseDetails(exerciseDetails, authentication.getName());
    }

}
