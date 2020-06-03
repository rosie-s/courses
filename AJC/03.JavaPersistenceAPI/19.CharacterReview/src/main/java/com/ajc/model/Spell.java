package com.ajc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@ToString
@NoArgsConstructor
@Table(name = "spell_table")
public class Spell extends LevelElement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Getter
    @Column(name = "cost")
    private int cost;

    @Getter
    @Column(name = "damage")
    private  int damage;

    public Spell(int cost, int damage) {
        this.cost = cost;
        this.damage = damage;
    }
}
