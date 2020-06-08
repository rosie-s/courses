package com.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Guitarist implements IntfMusician {

    @Autowired
    private IntfInstrument instrument;

    public Guitarist() {
    }

    public Guitarist(IntfInstrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public void play() {
        System.out.println("The guitarist plays " + instrument.toString());
    }

    public IntfInstrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Guitar instrument) {
        this.instrument = instrument;
    }

}
