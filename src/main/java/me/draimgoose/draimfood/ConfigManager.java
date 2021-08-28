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
        put("WHEAT", 48);
        put("HAY_BLOCK", 48);
        put("MELON", 48);
        put("PUMPKIN", 48);
        put("BROWN_MUSHROOM", 48);
        put("RED_MUSHROOM", 48);
        put("NETHER_WART", 168);
        put("MELON_SLICE", 24);
        put("CAKE", 24);
        put("PUMPKIN_PIE", 24);
        put("SUGAR", 72);
        put("EGG", 72);
        put("SUGAR_CANE", 48);
        put("APPLE", 48);
        put("COOKIE", 94);
        put("POISONOUS_POTATO", 24);
        put("CHORUS_FRUIT", 94);
        put("DRIED_KELP", 72);
        put("BAKED_POTATO", 94);
        put("SWEET_BERRIES", 48);
    }};
}
