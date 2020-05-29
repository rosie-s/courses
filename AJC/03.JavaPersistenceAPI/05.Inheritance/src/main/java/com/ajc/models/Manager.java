package com.ajc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="department_table")
public class Manager extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(name ="fName")
    public String firstName;

    @Column(name ="lName")
    public String lastName;

    @OneToMany(mappedBy = "manager")
    private List<Artist> artists = new ArrayList<>();

    public Manager(String firstName, String lastName) {
        super(firstName,lastName);
    }
}
