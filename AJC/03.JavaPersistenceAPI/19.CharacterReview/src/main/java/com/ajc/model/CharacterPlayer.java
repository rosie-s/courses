package com.ajc.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "character_table")
public class CharacterPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "health")
    private int health;

    @Column(name = "strength")
    private int strength;

    @Column(name = "level")
    private int level;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "characterSpells")
    private List<Spell> spells = new ArrayList<>();

    @ManyToMany(mappedBy = "characterItems")
    private List<Item> items = new ArrayList<>();


    public CharacterPlayer(String name, int health, int strength, int level) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.level = level;
    }

    @Override
    public String toString() {
        return "CharacterPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                ", level=" + level +
                ", user=" + user +
                ", items=" + items +
                ", spells=" + spells +
                '}';
    }
}
