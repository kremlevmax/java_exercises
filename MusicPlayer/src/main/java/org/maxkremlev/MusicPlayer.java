package org.maxkremlev;

import org.maxkremlev.Music.Music;
import org.maxkremlev.Music.RockMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MusicPlayer {
    private final Music music1, music2;

    private int volume;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("countryMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic() {
        System.out.printf("Volume - %s%s\n",this.volume, "%");
        System.out.println(music1.showSong());
        System.out.println(music2.showSong());
    }
}
