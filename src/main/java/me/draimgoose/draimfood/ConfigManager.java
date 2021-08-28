package me.draimgoose.draimfood;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Material.*;

public class ConfigManager {

    private static ConfigManager instance;

    public static ConfigManager getInstance() {
        return instance == null ? instance = new ConfigManager() : instance;
    }

    private static final Map<Material, Float> SPOIL_CHANCE = new HashMap<Material, Float>() {{
        put(WHEAT, 0.3f);
    }};
}
