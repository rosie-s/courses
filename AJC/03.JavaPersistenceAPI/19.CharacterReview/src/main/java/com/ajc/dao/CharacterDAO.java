package com.ajc.dao;

import com.ajc.model.CharacterPlayer;

import java.util.List;

public abstract interface CharacterDAO extends GenericDAO<CharacterPlayer, Integer> {
    public List<CharacterPlayer> findByName(String name);
}
