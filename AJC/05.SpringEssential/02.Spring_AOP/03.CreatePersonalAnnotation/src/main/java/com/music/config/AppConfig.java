package com.music.config;

import com.music.instruments.*;
import com.music.musicians.Guitarist;
import com.music.musicians.IntfMusician;
import com.music.musicians.Pianist;
import org.springframework.context.annotation.*;
import com.music.aspect.*;

@Configuration
@ComponentScan("com.music")
@ImportResource("classpath:application-context.xml")
@EnableAspectJAutoProxy
public class AppConfig {
   /* @Bean
    public IntfInstrument guitar() {
        return new Guitar();
    }

    @Bean
    public IntfMusician guitarist() {
        return new Guitarist();
    }

    @Bean
    public IntfInstrument piano() {
        return new Piano();
    }

    @Bean
    public IntfMusician pianist() {
        return new Pianist();
    }

    @Bean
    public IntfInstrument synthesizer() {
        return new Synthesizer();
    }

    @Bean
    public IntfInstrument ukulele() {
        return new Ukulele();
    }

    @Bean
    public MyAspectInterceptor myAspectInterceptor() {
        return new MyAspectInterceptor();
    }*/
}
