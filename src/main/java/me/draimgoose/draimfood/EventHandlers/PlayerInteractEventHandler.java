package me.draimgoose.draimfood.EventHandlers;

import me.draimgoose.draimfood.DFFactory;
import me.draimgoose.draimfood.TimeStampManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractEventHandler implements Listener {

    private boolean debug = false;

    @EventHandler()
    public void handle(PlayerInteractEvent event) {
        ItemStack item = event.getItem();

        if (item != null) {

            if (TimeStampManager.getInstance().timeStampAssigned(item)) {

                if (debug) { System.out.println("У предмета есть метка времени!"); }

                EquipmentSlot hand = event.getHand();
                if (hand != null) {

                    if (TimeStampManager.getInstance().timeReached(item)) {

                        ItemStack spoiledFood = DFFactory.getInstance().createSpoiledFood(item);

                        switch(hand) {
                            case HAND:
                                event.getPlayer().getInventory().setItemInMainHand(spoiledFood);
                                break;
                            case OFF_HAND:
                                event.getPlayer().getInventory().setItemInOffHand(spoiledFood);
                                break;
                            default:
                                if (debug) { System.out.println("Неизвестная рука" + hand); }
                        }
                        event.setCancelled(true);
                    } else {
                        if (debug) { System.out.println("Время еще не прошло!"); }
                    }
                }
                else {
                    event.setCancelled(true);
                }
            }

        }

    }

}
