package org.kremlev.singleton;

public class Main {
    public static void main(String[] args) {
        // .createInstance() returns static instance of Singleton class which is equal to object or null.
        Singleton mySingleton = Singleton.createInstance();
        mySingleton.printMessage();
    }
}