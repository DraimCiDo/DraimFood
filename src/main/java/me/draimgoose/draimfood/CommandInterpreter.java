package me.draimgoose.draimfood;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import me.draimgoose.draimfood.Commands.TimeLeftCommand;
import me.draimgoose.draimfood.Commands.ReloadCommand;

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

            //reload command
            if (args[0].equalsIgnoreCase("reload")) {
                new ReloadCommand().reload(sender);
                return true;
            }

            if (args[0].equalsIgnoreCase("timeleft")) {
                new TimeLeftCommand().sendTimeLeft(sender);
                return true;
            }

        }
        return false;
    }

}
