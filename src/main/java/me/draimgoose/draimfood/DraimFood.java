package me.draimgoose.draimfood;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class DraimFood extends JavaPlugin {

    private static DraimFood instance;

    public static DraimFood getInstance() {
        return instance;
    }

    public String getVersion() {
        return "v0.3.1";
    }

    @Override
    public void onEnable() {
        instance = this;

    }

    @Override
    public void onDisable() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return CommandInterpreter.getInstance().interpretCommand(sender, label, args);
    }

}
