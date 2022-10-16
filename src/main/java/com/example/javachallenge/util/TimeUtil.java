package com.example.javachallenge.util;

public class TimeUtil {

    public static long nowInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static long minutesToSeconds(long minutes) {
        return minutes * 60;
    }
}
