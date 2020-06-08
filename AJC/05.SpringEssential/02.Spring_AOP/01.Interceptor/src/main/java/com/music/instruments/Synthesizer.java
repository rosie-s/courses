package com.music.instruments;

import org.springframework.stereotype.Component;

@Component
public class Synthesizer implements IntfInstrument {
    @Override
    public String toString() {
        return "synthesizer sound";
    }
}
