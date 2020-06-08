package com.music.musicians;

import com.music.anno.MyAnnotation;
import com.music.instruments.Guitar;
import com.music.instruments.IntfInstrument;
import com.music.instruments.Ukulele;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitarist implements IntfMusician {

    @Autowired
    @Qualifier("ukulele")
    private IntfInstrument instrument;

    public Guitarist() {
    }

    @Override
    public int play() {
        ((Ukulele) instrument).ukuleleStrings();
        //((Guitar) instrument).guitarStrings();
        System.out.println("The Guitarist plays: " + instrument.toString());
        return 2;
    }

}
