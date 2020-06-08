package com.music.instruments;

import org.springframework.stereotype.Component;

@Component
public class Ukulele implements IntfInstrument {
    @Override
    public String toString() {
        return "ukulele sound";
    }
}
