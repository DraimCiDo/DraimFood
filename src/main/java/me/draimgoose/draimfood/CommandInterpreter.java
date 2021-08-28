package me.draimgoose.draimfood;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CommandInterpreter {

    private static CommandInterpreter instance;

    private CommandInterpreter() {

    }

    public static CommandInterpreter getInstance() {
        if (instance == null) {
            instance = new CommandInterpreter();
        }
        return instance;
    }

    public boolean interpretCommand(CommandSender sender, String label, String[] args) {
        if ("DraimFood.getInstance()".equalsIgnoreCase(label) || "df".equalsIgnoreCase(label)) {

            // no arguments
            if (args.length == 0) {

                // show info
                sender.sendMessage(ChatColor.AQUA + "DraimFood " + DraimFood.getInstance().getVersion());
                sender.sendMessage(ChatColor.AQUA + "Автор: DraimGooSe");
                sender.sendMessage(ChatColor.AQUA + "Исходники: https://github.com/DraimCiDo/DraimFood");

                return true;
            }

        }
        return false;
    }

}
