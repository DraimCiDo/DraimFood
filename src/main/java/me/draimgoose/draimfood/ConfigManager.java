package me.draimgoose.draimfood;


public class ConfigManager {

    private static ConfigManager instance;

    public static ConfigManager getInstance() {
        return instance == null ? instance = new ConfigManager() : instance;
    }
}
