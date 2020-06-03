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
@Table(name = "spell_table")
public class LevelElement {

    @EmbeddedId
    @Column(name ="level_id")
    LevelId id;

    @Column(name = "level_name")
    private  String name;

    @Column(name = "level", insertable = false, updatable = false)
    public int level;

    public LevelElement(LevelId levelId, String name, int level){
        this.id = levelId;
        this.name = name;
        this.level = level;
    }
}
