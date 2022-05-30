package com.neilly.peely.repository;

import com.neilly.peely.model.Workout;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {

    List<Workout> findByAccountHolder_Username(String username);

    List<Workout> findByDateAndAccountHolderUsername(Date date, String username);

    Optional<Workout> findByIdAndAccountHolderUsername(Long id, String username);

}
