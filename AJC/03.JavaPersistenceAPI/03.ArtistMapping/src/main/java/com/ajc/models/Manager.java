package com.ajc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="department_table")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="fName")
    private String firstName;

    @Column(name ="lName")
    private String lastName;

    @OneToMany(mappedBy = "manager")
    private List<Artist> artists = new ArrayList<>();

    public Manager(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
