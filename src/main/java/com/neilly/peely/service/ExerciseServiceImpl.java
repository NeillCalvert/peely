package com.neilly.peely.service;

import com.neilly.peely.model.Exercise;
import com.neilly.peely.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService{
    @Autowired
    private ExerciseRepository exerciseRepository;

    public Optional<Exercise> findByName(String name){
        return exerciseRepository.findByName(name);
    }

    public List<Exercise> findByAccountHolder(String username){
        return null;
    }

    public Optional<Exercise> findById(Long id){
        return exerciseRepository.findById(id);
    }

    public void addExercise(Exercise exercise){
        exerciseRepository.save(exercise);
    }
}
