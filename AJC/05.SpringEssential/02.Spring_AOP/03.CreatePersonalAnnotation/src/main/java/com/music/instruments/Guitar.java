package com.music.instruments;

import com.music.anno.MyAnnotation;
import org.springframework.stereotype.Component;

@Component
public class Guitar implements IntfInstrument {
    @Override
    public String toString() {
        return "guitar sound";
    }

    @MyAnnotation
    public void guitarStrings() {
        System.out.println("Guitars have 6 strings");
    }
}
