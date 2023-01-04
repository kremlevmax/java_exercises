package org.maxkremlev.Music;

import org.springframework.stereotype.Component;

@Component
public class CountryMusic implements Music {
    public void countryInit() {
        System.out.println("Country music init");
    }

    public void countryDestroy() {
        System.out.println("Country music destroy");
    }
    @Override
    public String showSong() {
        return "Johnny Cash - Folsom Prison Blues";
    }
}
