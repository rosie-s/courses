package com.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Guitarist implements IntfMusician {

    @Autowired
    private IntfInstrument instrument;

    public Guitarist() {
    }

    @Override
    public void play() {
        System.out.println("The guitarist plays " + instrument.toString());
    }

}
