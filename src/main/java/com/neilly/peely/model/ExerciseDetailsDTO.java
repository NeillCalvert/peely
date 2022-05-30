package com.neilly.peely.model;

import java.util.Date;

public class ExerciseDetailsDTO {
    private Long id;
    private Date date;
    private int sets;
    private int reps;
    private double weight;
    private ExerciseDTO exerciseDTO;
    private AccountHolderDTO accountHolderDTO;

    public ExerciseDetailsDTO(Long id, Date date, int sets, int reps, double weight, ExerciseDTO exerciseDTO, AccountHolderDTO accountHolderDTO) {
        this.id = id;
        this.date = date;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.exerciseDTO = exerciseDTO;
        this.accountHolderDTO = accountHolderDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ExerciseDTO getExerciseDTO() {
        return exerciseDTO;
    }

    public void setExerciseDTO(ExerciseDTO exerciseDTO) {
        this.exerciseDTO = exerciseDTO;
    }

    public AccountHolderDTO getAccountHolderDTO() {
        return accountHolderDTO;
    }

    public void setAccountHolderDTO(AccountHolderDTO accountHolderDTO) {
        this.accountHolderDTO = accountHolderDTO;
    }
}
