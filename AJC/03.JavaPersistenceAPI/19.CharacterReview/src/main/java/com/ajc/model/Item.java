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
@Table(name = "item_table")
public class Item extends LevelElement {

    @Getter
    @Column(name = "durability")
    private int durability;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "colour")
    private Colour colour;

    @Getter
    @ManyToMany
    @JoinTable(name = "character_items")
    //@ManyToMany(mappedBy = "items", fetch = FetchType.EAGER)
    List<CharacterPlayer> characterItems = new ArrayList<>();

    public Item(String name, int level, int durability, Colour colour) {
        this.durability = durability;
        this.colour = colour;
        this.id = new LevelId(name, level);
    }
}
