package com.ajc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "wizard_table")
public class Wizard extends CharacterPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "magic_level")
    private int magic;

    public Wizard(String name, int health, int strength, int level) {
        super(name, health, strength, level);
    }
}


