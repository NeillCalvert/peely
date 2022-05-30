package com.neilly.peely.service;

import com.neilly.peely.model.Exercise;
import com.neilly.peely.repository.ExerciseRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ExerciseServiceTest {

    @Mock
    ExerciseRepository exerciseRepository;

    @InjectMocks
    ExerciseServiceImpl exerciseService;

    public final String TEST_USERNAME = "TEST";
    public final Long TEST_ID = Long.valueOf(1);

    public void testFindByName(){
        Exercise exercise = new Exercise(TEST_ID, TEST_USERNAME);
        Mockito.when(exerciseRepository.findByName(TEST_USERNAME)).thenReturn(Optional.of(exercise));
    }

}
