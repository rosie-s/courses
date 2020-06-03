package com.ajc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="department_table")
public class Manager extends Person{

    public double budget;

    @OneToMany(mappedBy = "manager")
    private List<Artist> artists = new ArrayList<>();

    public Manager(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Manager() {
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "budget=" + budget +
                ", artists=" + artists +
                '}';
    }
}
