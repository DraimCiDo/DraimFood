package me.draimgoose.draimfood;

import org.bukkit.plugin.PluginManager;

public class EventRegistry {

    private static EventRegistry instance;

    private EventRegistry() {

    }

    public static EventRegistry getInstance() {
        if (instance == null) {
            instance = new EventRegistry();
        }
        return instance;
    }

    public void registerEvents() {

        DraimFood mainInstance = DraimFood.getInstance();
        PluginManager manager = mainInstance.getServer().getPluginManager();

    }

}
