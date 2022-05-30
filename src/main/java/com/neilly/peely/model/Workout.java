package com.neilly.peely.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date date;
    @ManyToOne()
    @JoinColumn(name="accountHolder_id")
    private AccountHolder accountHolder;
    @OneToMany()
    private List<Exercise> exercises;

    public Workout(){
    }

    public Workout(Long id, String name, Date date, AccountHolder accountHolder, List<Exercise> exercises){
        this.id = id;
        this.name = name;
        this.date = date;
        this.accountHolder = accountHolder;
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

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
