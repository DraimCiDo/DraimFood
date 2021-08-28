package me.draimgoose.draimfood;

public class TimeStampManager {

    private static TimeStampManager instance;

    private TimeStampManager() {

    }

    public static TimeStampManager getInstance() {
        if (instance == null) {
            instance = new TimeStampManager();
        }
        return instance;
    }

    String pattern = "MM/dd/yyyy HH";

}
