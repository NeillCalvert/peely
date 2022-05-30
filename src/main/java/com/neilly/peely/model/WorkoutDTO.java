package com.neilly.peely.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

public class WorkoutDTO {

    private Long id;
    private String name;
    private Date date;
    private AccountHolderDTO accountHolderDTO;
    private List<ExerciseDTO> exercises;

    public WorkoutDTO(){}

    public WorkoutDTO(Long id, String name, Date date, AccountHolderDTO accountHolderDTO, List<ExerciseDTO> exercises) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.accountHolderDTO = accountHolderDTO;
        this.exercises = exercises;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AccountHolderDTO getAccountHolder() {
        return accountHolderDTO;
    }

    public void setAccountHolder(AccountHolderDTO accountHolderDTO) {
        this.accountHolderDTO = accountHolderDTO;
    }

    public AccountHolderDTO getAccountHolderDTO() {
        return accountHolderDTO;
    }

    public void setAccountHolderDTO(AccountHolderDTO accountHolderDTO) {
        this.accountHolderDTO = accountHolderDTO;
    }

    public List<ExerciseDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseDTO> exercises) {
        this.exercises = exercises;
    }
}
