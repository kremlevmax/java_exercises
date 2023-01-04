package org.maxkremlev;

import org.maxkremlev.Music.CountryMusic;
import org.maxkremlev.Music.Music;
import org.maxkremlev.Music.RockMusic;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();
        context.close();

    }
}