package com.music.musicians;

import com.music.instruments.IntfInstrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pianist implements IntfMusician {

    @Autowired
    @Qualifier("synthesizer")
    private IntfInstrument instrument;

    public Pianist() {
    }

    @Override
    public int play() {
        System.out.println("The Pianist plays: " + instrument.toString());
        return 0;
    }

}
