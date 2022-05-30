package com.neilly.peely.service;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.Exercise;
import com.neilly.peely.model.ExerciseDetails;
import com.neilly.peely.repository.AccountHolderRepository;
import com.neilly.peely.repository.ExerciseDetailsRepository;
import com.neilly.peely.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseDetailsServiceImpl implements ExerciseDetailsService{
    @Autowired
    private ExerciseDetailsRepository exerciseDetailsRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public void addExerciseDetailsToExercise(ExerciseDetails exerciseDetails, Long exerciseId, String username){
        Optional<Exercise> exercise = exerciseRepository.findById(exerciseId);
        Optional<AccountHolder> accountHolder = accountHolderRepository.findByUsername(username);

        if(exercise.isPresent() && accountHolder.isPresent()){
            exerciseDetails.setExercise(exercise.get());
            exerciseDetails.setAccountHolder(accountHolder.get());
            exerciseDetailsRepository.save(exerciseDetails);
        }
    }

    public void updateExerciseDetails(ExerciseDetails exerciseDetails, String username){
        Optional<ExerciseDetails> oldExerciseDetails = exerciseDetailsRepository.findByIdAndAccountHolder_Id(exerciseDetails.getId(), username);

        if(oldExerciseDetails.isPresent()){
            exerciseDetailsRepository.save(exerciseDetails);
        }
    }
}
