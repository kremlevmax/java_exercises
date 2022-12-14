package org.kremlev.singleton;

public class Singleton {
    private static Singleton mySingleton;

    private Singleton() {}

    // Multiple instance creation prevention
    public static Singleton createInstance() {
        if (mySingleton == null) {
            mySingleton = new Singleton();
        }
        return mySingleton;
    }

    public void printMessage() {
        System.out.println("I'm a Singleton");
    }
}
