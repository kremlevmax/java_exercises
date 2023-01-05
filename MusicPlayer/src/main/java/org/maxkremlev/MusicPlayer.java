package org.maxkremlev;

import org.maxkremlev.Music.Music;
import org.maxkremlev.Music.MusicGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    private final Music music1, music2, music3;

    @Value("${musicPlayer.volume}")
    private int volume;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("countryMusic") Music music2,
                       @Qualifier("hipHopMusic") Music music3) {
        this.music1 = music1;
        this.music2 = music2;
        this.music3 = music3;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic(MusicGenre genre) {
        Random random = new Random();

        int trackNumber = random.nextInt(3);
        String song = null;

        switch (genre) {
            case ROCK:
                song = music1.showSong(trackNumber);
                break;
            case COUNTRY:
                song = music2.showSong(trackNumber);
                break;
            case HIPHOP:
                song = music3.showSong(trackNumber);
                break;
        }

        System.out.printf("Volume - %s%s\n%s", this.volume, "%", song);
    }
}
