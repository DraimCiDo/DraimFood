package me.draimgoose.draimfood.Commands;

import me.draimgoose.draimfood.ConfigManager;
import me.draimgoose.draimfood.TimeStampManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TimeLeftCommand {

    public void sendTimeLeft(CommandSender sender) {
        if (!(sender instanceof Player)) {
            return;
        }

        Player player = (Player) sender;

        ItemStack item = player.getInventory().getItemInMainHand();

        String timeLeft = TimeStampManager.getInstance().getTimeLeft(item);

        if (timeLeft == null) {
            // эта еда никогда не испортится
            player.sendMessage(ConfigManager.getInstance().neverSpoilText);
            return;
        }

        player.sendMessage(timeLeft);
    }
}
