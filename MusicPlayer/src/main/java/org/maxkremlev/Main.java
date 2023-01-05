package org.maxkremlev;

import org.maxkremlev.Music.CountryMusic;
import org.maxkremlev.Music.Music;
import org.maxkremlev.Music.MusicGenre;
import org.maxkremlev.Music.RockMusic;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic(MusicGenre.COUNTRY);
        context.close();

    }
}