package me.draimgoose.draimfood.EventHandlers;

import me.draimgoose.draimfood.DFFactory;
import me.draimgoose.draimfood.TimeStampManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryDragEventHandler implements Listener {

    private boolean debug = false;

    @EventHandler()
    public void handle(InventoryDragEvent event) {
        ItemStack item = event.getCursor();

        if (item != null) {

            if (TimeStampManager.getInstance().timeStampAssigned(item)) {

                if (debug) { System.out.println("У предмета есть метка времени!"); }

                if (TimeStampManager.getInstance().timeReached(item)) {

                    if (debug) { System.out.println("Время прошло!"); }

                    event.setCursor(DFFactory.getInstance().createSpoiledFood(item));

                } else {
                    if (debug) { System.out.println("Время еще не прошло!"); }
                }

            }

        }

    }

}