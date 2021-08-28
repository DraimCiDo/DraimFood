package me.draimgoose.draimfood.EventHandlers;

import me.draimgoose.draimfood.ConfigManager;
import me.draimgoose.draimfood.TimeStampManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class ItemSpawnEventHandler implements Listener {

    @EventHandler()
    public void handle(ItemSpawnEvent event) {

        ItemStack item = event.getEntity().getItemStack();
        Material type = item.getType();
        int time = ConfigManager.getInstance().getTime(type);

        if (time != 0 && !TimeStampManager.getInstance().timeStampAssigned(item)) {
            event.getEntity().setItemStack(TimeStampManager.getInstance().assignTimeStamp(item, time));
        }

    }

}
