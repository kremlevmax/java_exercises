package org.maxkremlev.Music;

import org.springframework.stereotype.Component;

@Component
public class CountryMusic implements Music {
    String[] songs = new String[]{
            "Johnny Cash - I Walk the Line",
            "Patsy Cline - Crazy",
            "Patsy Cline - Crazy"
    };

    public void countryInit() {
        System.out.println("Country music init");
    }

    public void countryDestroy() {
        System.out.println("Country music destroy");
    }

    @Override
    public String showSong(int trackNumber) {
        return songs[trackNumber];
    }
}
