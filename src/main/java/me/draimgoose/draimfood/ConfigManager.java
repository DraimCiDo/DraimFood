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

    private static final Map<String, Integer> DEFAULT_SPOIL_TIMES = new HashMap<String, Integer>() {{
        put("BREAD", 24);
        put("POTATO", 48);
        put("CARROT", 48);
        put("BEETROOT", 48);
        put("BEEF", 24);
        put("PORKCHOP", 24);
        put("CHICKEN", 24);
        put("COD", 24);
        put("SALMON", 24);
        put("MUTTON", 24);
        put("RABBIT", 24);
        put("TROPICAL_FISH", 24);
        put("PUFFERFISH", 24);
        put("MUSHROOM_STEW", 72);
        put("RABBIT_STEW", 96);
        put("BEETROOT_SOUP", 72);
        put("COOKED_BEEF", 72);
        put("COOKED_PORKCHOP", 72);
        put("COOKED_CHICKEN", 72);
        put("COOKED_SALMON", 72);
        put("COOKED_MUTTON", 72);
        put("COOKED_RABBIT", 72);
        put("COOKED_COD", 72);
    }};
}
