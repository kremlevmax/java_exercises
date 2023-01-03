package org.maxkremlev;

import org.maxkremlev.Music.Music;

import java.util.List;

public class MusicPlayer {
    private List<Music> playList;

    public List<Music> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Music> playList) {
        this.playList = playList;
    }

    public void playMusic() {
        for (Music music: this.playList) {
            System.out.println(music.showSong());
        }
    }
}
