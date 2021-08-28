package me.draimgoose.draimfood;

import me.draimgoose.draimfood.EventHandlers.*;
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

        manager.registerEvents(new CraftItemEventHandler(), mainInstance);
        manager.registerEvents(new InventoryDragEventHandler(), mainInstance);
        manager.registerEvents(new PlayerInteractEventHandler(), mainInstance);
        manager.registerEvents(new ItemSpawnEventHandler(), mainInstance);
        manager.registerEvents(new FurnaceSmeltEventHandler(), mainInstance);
        manager.registerEvents(new BlockCookEventHandler(), mainInstance);

    }

}
