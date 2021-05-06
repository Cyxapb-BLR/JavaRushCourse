package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;

    private OurPresident() {
    }

    static {
        synchronized (Thread.currentThread()) {
            president = new OurPresident();
        }
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}

