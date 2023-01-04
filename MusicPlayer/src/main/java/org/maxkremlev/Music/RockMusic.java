package org.maxkremlev.Music;

public class RockMusic implements Music {
    public void initRock() {
        System.out.println("Rock Music Init");
    }

    public void destroyRock() {
        System.out.println("Rock Music Destroy");
    }
    @Override
    public String showSong() {
        return "Deftones - Back to School";
    }
}
