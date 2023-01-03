package org.maxkremlev;

import org.maxkremlev.Music.Music;

import java.util.List;

public class MusicPlayer {
    private List<Music> playList;
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<Music> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Music> playList) {
        this.playList = playList;
    }

    public void playMusic() {
        System.out.printf("Volume - %s%s\n",this.volume, "%");
        for (Music music: this.playList) {
            System.out.println(music.showSong());
        }
    }
}
