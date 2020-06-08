package com.ajc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Embeddable
public class LevelId implements Serializable {
    private  String name;
    private int level;


    public LevelId(String name, int level) {
        this.name = name;
        this.level = level;
    }
}
