package com.music;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements IntfInstrument {
    @Override
    public String toString() {
        return "Glink glink glink";
    }
}
