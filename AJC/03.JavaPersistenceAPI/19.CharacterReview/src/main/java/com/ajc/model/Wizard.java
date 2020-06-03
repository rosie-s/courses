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

    public Wizard(CharacterPlayer characterJohn, int magic) {
        this.magic = magic;
    }
}


