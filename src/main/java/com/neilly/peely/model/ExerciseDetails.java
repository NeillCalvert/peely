package com.neilly.peely.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ExerciseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private int sets;
    private int reps;
    private double weight;
    @ManyToOne
    private Exercise exercise;
    @ManyToOne
    private AccountHolder accountHolder;

    public ExerciseDetails(Long id, Date date, int sets, int reps, double weight, Exercise exercise, AccountHolder accountHolder) {
        this.id = id;
        this.date = date;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.exercise = exercise;
        this.accountHolder = accountHolder;
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

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }
}
