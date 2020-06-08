package com.ajc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "orc_table")
public class Orc extends CharacterPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "rage_level")
    private int rage;

    public Orc(String name, int health, int strength, int level) {
        super(name, health, strength, level);
    }
}
