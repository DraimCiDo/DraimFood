package me.draimgoose.draimfood;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class DraimFood extends JavaPlugin {

    private static DraimFood instance;

    public static DraimFood getInstance() {
        return instance;
    }

    public String getVersion() {
        return "v0.5.0";
    }

    @Override
    public void onEnable() {
        instance = this;

        ConfigManager.getInstance().ensureSmoothTransitionBetweenVersions();

        // создание и загрузка конфига
        if (!(new File("./plugins/DraimFood/config.yml").exists())) {
            ConfigManager.getInstance().create();
        } else {
            reloadConfig();
        }

        if (!getVersion().equalsIgnoreCase(getConfig().getString("version"))) {
            ConfigManager.getInstance().handleVersionMismatch();
        }
    }

    @Override
    public void onDisable() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return CommandInterpreter.getInstance().interpretCommand(sender, label, args);
    }

}
