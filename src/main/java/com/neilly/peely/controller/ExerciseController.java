package com.neilly.peely.controller;

import com.neilly.peely.aspect.GenericLogger;
import com.neilly.peely.model.Exercise;
import com.neilly.peely.model.ExerciseDTO;
import com.neilly.peely.service.ExerciseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseServiceImpl exerciseService;

    @Autowired
    private ModelMapper modelMapper;

    private Exercise convertToEntity(ExerciseDTO exerciseDTO){
        Exercise exercise = modelMapper.map(exerciseDTO, Exercise.class);

        if(null != exercise.getId()){
            Optional<Exercise> oldExercise = exerciseService.findById(exercise.getId());
            oldExercise.ifPresent(value -> exercise.setId(value.getId()));
        }

        return exercise;
    }

    private ExerciseDTO convertToDTO(Exercise exercise){
        ExerciseDTO exerciseDTO = modelMapper.map(exercise, ExerciseDTO.class);
        return exerciseDTO;
    }

    @GenericLogger(logCustomMessage = true, customMessage = "Getting Exercise by name", logMethodArgs = true)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/exercise")
    public Optional<ExerciseDTO> findExerciseByName(String name){
        return exerciseService.findByName(name).map(value -> convertToDTO(value));
    }

    @GenericLogger(logCustomMessage = true, customMessage = "Getting Exercise by account holder", logMethodArgs = true)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/allExercises")
    public List<ExerciseDTO> findExerciseByCurrentlyAuthenticatedUser(Authentication authentication){
        return exerciseService.findByAccountHolder(authentication.getName()).stream().map(value -> convertToDTO(value)).collect(Collectors.toList());
    }

    @GenericLogger(logCustomMessage = true, customMessage = "Adding exercise", logMethodArgs = true)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addExercise")
    public void addExercise(ExerciseDTO exerciseDTO){
        exerciseService.addExercise(convertToEntity(exerciseDTO));
    }
}
