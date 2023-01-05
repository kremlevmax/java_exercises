package org.maxkremlev.Music;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {
    String[] songs = new String[]{
            "Deftones - Back to School",
            "Led Zeppelin - Stairway to Heaven",
            "Nirvana - Come As You Are"};

    public void initRock() {
        System.out.println("Rock Music Init");
    }

    public void destroyRock() {
        System.out.println("Rock Music Destroy");
    }
    @Override
    public String showSong(int trackNumber) {
        return songs[trackNumber];
    }
}
