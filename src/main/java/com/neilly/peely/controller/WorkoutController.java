package com.neilly.peely.controller;

import com.neilly.peely.aspect.GenericLogger;
import com.neilly.peely.model.Workout;
import com.neilly.peely.model.WorkoutDTO;
import com.neilly.peely.service.WorkoutService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private ModelMapper modelMapper;

    private Workout convertToWorkoutEntity (WorkoutDTO workoutDTO){

        Workout workout = modelMapper.map(workoutDTO, Workout.class);

        if(null != workoutDTO.getId()){
            Optional<Workout> olderWorkout = workoutService.getWorkoutById(workout.getId());
            olderWorkout.ifPresent(value -> workout.setId(value.getId()));
        }

        return workout;
    }

    private WorkoutDTO convertToWorkoutDTO(Workout workout){
        WorkoutDTO workoutDTO = modelMapper.map(workout, WorkoutDTO.class);
        workoutDTO.getAccountHolder().setPassword("");
        return workoutDTO;
    }

    @ResponseStatus(HttpStatus.OK)
    @GenericLogger(logCustomMessage = true, customMessage = "Getting all workouts by username", logMethodArgs = true)
    @GetMapping("/allWorkouts")
    public List<WorkoutDTO> getAllWorkoutsByForCurrentlyAuthenticatedUser(Authentication authentication){
        return workoutService.getAllWorkoutsByUsername(authentication.getName()).stream().map(e -> convertToWorkoutDTO(e)).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GenericLogger(logCustomMessage = true, customMessage = "Getting all workouts by date", logMethodArgs = true)
    @GetMapping("/workoutByDate")
    public List<WorkoutDTO> getAllWorkoutsByDateForCurrentlyAuthenticatedUser(Authentication authentication, Date date) {
        return workoutService.getAllWorkoutsByUsernameAndDate(authentication.getName(), date).stream().map(e -> convertToWorkoutDTO(e)).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GenericLogger(logCustomMessage = true, customMessage = "Adding new workout", logMethodArgs = true)
    @PostMapping("/addWorkout")
    public void addWorkout(@RequestBody WorkoutDTO workoutDTO, Authentication authentication){
        Workout workout = convertToWorkoutEntity(workoutDTO);
        workoutService.addWorkout(workout, authentication);
    }

    @ResponseStatus(HttpStatus.OK)
    @GenericLogger(logCustomMessage = true, customMessage = "Adding exercise to workout", logMethodArgs = true)
    @PutMapping("/addExerciseToWorkout")
    public void addExerciseToWorkout(Long exerciseId, Long workoutId, Authentication authentication){
        workoutService.addExerciseToWorkout(exerciseId, workoutId, authentication.getName());
    }

}
