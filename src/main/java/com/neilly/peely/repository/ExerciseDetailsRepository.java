package com.neilly.peely.repository;

import com.neilly.peely.model.ExerciseDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExerciseDetailsRepository extends CrudRepository<ExerciseDetails, Long> {

    Optional<ExerciseDetails> findByIdAndAccountHolder_Id(Long id, String name);
}
