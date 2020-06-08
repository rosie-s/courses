package com.music.instruments;

import com.music.anno.MyAnnotation;
import org.springframework.stereotype.Component;

@Component
public class Ukulele implements IntfInstrument {
    @Override
    public String toString() {
        return "ukulele sound";
    }

    @MyAnnotation
    public void ukuleleStrings() {
        System.out.println("Ukuleles have 4 string");
    }
}
