package org.maxkremlev;

import org.maxkremlev.Music.Music;
import org.maxkremlev.Music.RockMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MusicPlayer {
//    private List<Music> playList;
    @Autowired
    private RockMusic rockMusic;

    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

//    public List<Music> getPlayList() {
//        return playList;
//    }

//    public void setPlayList(List<Music> playList) {
//        this.playList = playList;
//    }

    public void playMusic() {
        System.out.printf("Volume - %s%s\n",this.volume, "%");
            System.out.println(rockMusic.showSong());
    }
}
