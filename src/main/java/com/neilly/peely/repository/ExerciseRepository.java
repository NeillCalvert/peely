package com.neilly.peely.repository;

import com.neilly.peely.model.Exercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    Optional<Exercise> findByName(String name);

}
