package me.draimgoose.draimfood.EventHandlers;

import me.draimgoose.draimfood.ConfigManager;
import me.draimgoose.draimfood.TimeStampManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCookEvent;
import org.bukkit.inventory.ItemStack;


public class BlockCookEventHandler implements Listener {

    @EventHandler()
    public void handle(BlockCookEvent event) {

        ItemStack item = event.getResult();
        Material type = item.getType();
        int time = ConfigManager.getInstance().getTime(type);

        if (time != 0) {
            event.setResult(TimeStampManager.getInstance().assignTimeStamp(item, time));
        }

    }

}
