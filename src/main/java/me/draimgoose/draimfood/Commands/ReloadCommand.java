package me.draimgoose.draimfood.Commands;

import me.draimgoose.draimfood.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand {

    public void reload(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("draimfood.reload")) {
                ConfigManager.getInstance().reload();
                player.sendMessage(ChatColor.GREEN + ConfigManager.getInstance().valuesLoadedText);
            }
            else {
                ConfigManager.getInstance().reload();
                System.out.println(ConfigManager.getInstance().valuesLoadedText);
            }
        }
    }
}
