package org.maxkremlev;

import org.maxkremlev.Music.CountryMusic;
import org.maxkremlev.Music.Music;
import org.maxkremlev.Music.RockMusic;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Music bean1 = context.getBean("rockMusic", RockMusic.class);
        Music bean2 = context.getBean("rockMusic", RockMusic.class);
        System.out.println(bean1);
        System.out.println(bean2);

        Music bean3 = context.getBean("countryMusic", CountryMusic.class);
        Music bean4 = context.getBean("countryMusic", CountryMusic.class);
        System.out.println(bean3);
        System.out.println(bean4);

    }
}