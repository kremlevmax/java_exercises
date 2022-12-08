package org.kremlev.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton mySingleton = Singleton.createInstance();
        mySingleton.printMessage();
    }
}