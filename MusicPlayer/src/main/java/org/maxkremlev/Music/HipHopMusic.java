package org.maxkremlev.Music;

import org.springframework.stereotype.Component;

@Component
public class HipHopMusic implements Music {
    String[] songs = new String[]{
            "Cypress Hill - (Rap) Superstar",
            "2Pac - California Love",
            "Onyx - This is the Way We Walk in New York"
    };

    @Override
    public String showSong(int trackNumber) {
        return songs[trackNumber];
    }
}
