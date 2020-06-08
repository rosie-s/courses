package com.music.instruments;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements IntfInstrument {
    @Override
    public String toString() {
        return "guitar sound";
    }
}
