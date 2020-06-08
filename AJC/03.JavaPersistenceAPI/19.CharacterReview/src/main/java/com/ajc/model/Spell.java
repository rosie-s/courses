package com.ajc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@ToString
@NoArgsConstructor
@Table(name = "spell_table")
public class Spell extends LevelElement {

    @Getter
    @Column(name = "cost")
    private int cost;

    @Getter
    @Column(name = "damage")
    private  int damage;

    @Getter
    @ManyToMany
    @JoinTable(name = "character_spells")
    List<CharacterPlayer> characterSpells = new ArrayList<>();

    public Spell(String name, int level, int cost, int damage) {
        this.cost = cost;
        this.damage = damage;
        this.id = new LevelId(name, level);

    }
}
