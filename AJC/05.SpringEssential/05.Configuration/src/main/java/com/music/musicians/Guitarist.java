package com.music.musicians;

import com.music.instruments.IntfInstrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitarist implements IntfMusician {

    @Autowired
    @Qualifier("ukulele")
    private IntfInstrument instrument;

    public Guitarist() {
    }

    @Override
    public void play() {
        System.out.println("The Guitarist plays: " + instrument.toString());
    }

}
