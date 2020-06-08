package com.music;

public class Guitarist implements IntfMusician {

    private IntfInstrument instrument;

    public Guitarist() {
    }

    @Override
    public void play() {
        System.out.println("The guitarist plays " + instrument.toString());
    }

    public void setInstrument(Guitar instrument) {
        this.instrument = instrument;
    }



}
