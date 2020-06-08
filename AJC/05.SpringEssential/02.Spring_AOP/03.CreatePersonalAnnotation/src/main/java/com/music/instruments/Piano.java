package com.music.instruments;

import org.springframework.stereotype.Component;

@Component
public class Piano implements IntfInstrument {
    @Override
    public String toString() {
        return "piano sound";
    }
}
