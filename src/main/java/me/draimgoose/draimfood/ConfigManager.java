package me.draimgoose.draimfood;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.bukkit.Material.*;

public class ConfigManager {

    private static ConfigManager instance;

    private ConfigManager() {
        reloaded = 0;
        this.random = new Random(System.currentTimeMillis()); // Time as seed.
    }

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

    private static final boolean debug = false;
    private final Random random;
    private static long reloaded;
    private static long last_cached = 0;
    private static final HashMap<Material, Integer> cache = new HashMap<>();

    public String expiryDateText = "Годен до:";
    public String valuesLoadedText = "Значение загружены!";
    public String noPermsText = "Прости! Для использования этой команды вам необходимо следующее разрешение: 'draimfood.reload'";
    public String spoiledFoodName = "Испорченная еда";
    public String spoiledFoodLore = "Эта еда испортилась.";
    public String neverSpoilText = "Эта еда никогда не испортится.";
    public String timeLeftText = "Испортится через %s.";
    public String lessThanAnHour = "Срок годности истекает менее чем через час.";

    public int getTime(Material type) {
        if (debug) {
            System.out.println("Получено время порчи " + type.name());
        }
        if (last_cached <= reloaded) { // При первоначальной загрузке, они оба равны нулю.
            if (debug) {
                if (last_cached == reloaded && last_cached == 0) {
                    System.out.println("Собираем информацию в первый раз, инициализируем кэш.");
                } else {
                    System.out.println("Произошла перезагрузка с момента последнего сбора, очистка и перезапуск кэша.");
                }
            }
            last_cached = System.currentTimeMillis(); // Переопределение значения "last_cached"
            cache.clear(); // очистка кэша
        } else { // если кэш всё ещё остался
            if (debug) {
                System.out.println("Кэш все еще действителен, возвращаем время восстановления с карты.");
            }
            if (cache.containsKey(type)) { // Если уже кэшировался ключ, то возвращает значение.
                return cache.get(type); // Кэш работает с перезагрузкой
            }
        }
        if (debug) {
            System.out.println("Либо кэш был перезапущен, либо тип еще не был кэширован.");
        }
        final int time = DraimFood.getInstance().getConfig().getInt(type.name()); // Получение времени из конфига
        if (debug) {
            System.out.println("Прошло времени с последней настройки " + type.name() + ":\t" + time);
        }
        if (time != 0) { // Если он не равен нулю, то он действителен и мы будем кэшировать после след. перезапуска
            if (debug) {
                System.out.println("Поскольку время не равно нулю, кэширование произойдёт позже");
            }
            cache.put(type, time);
        }
        return time; // Возвращение
    }

    public int getSpoilChance(Material type, int Qty) {
        final float chance = SPOIL_CHANCE.getOrDefault(type, 0f);
        if (type == null || chance <= 0) return 0;
        final float roll = random.nextFloat();
        return roll <= chance ? (int) (roll * Qty) : 0;
    }

    public int getSpoilChance(ItemStack stack) {
        return getSpoilChance(stack.getType(), stack.getAmount());
    }

    public Map<Material, Integer> getSpoilTimes() {
        final HashMap<Material, Integer> spoilTimes = new HashMap<>();
        for (Material value : values()) { // Просмотр всей еды
            int time = getTime(value); // поиск времени
            if (time != 0) spoilTimes.put(value, time); // если стоит не 0, добавляет его
        }
        return spoilTimes; // возвращение
    }

    public void ensureSmoothTransitionBetweenVersions() {
        File saveFolder = new File("./plugins/DraimFood/");

        // если имеются старые файлы
        if (saveFolder.exists()) {
            System.out.println("[ВНИМАНИЕ] Обнаружено старое имя папки сохранения.");
            // загрузка
            LegacyStorageManager.getInstance().legacyLoadValuesFromConfig();
            LegacyStorageManager.getInstance().legacyLoadCustomText();

            // Переносит старые данные в новую конфигурацию, не делая из них говно не работающие
            LegacyStorageManager.getInstance().spoilTimes.forEach((k, v) -> {
                DraimFood.getInstance().getConfig().addDefault(k.name(), v);
            });

            // Сохраняет новую конфигурацию
            DraimFood.getInstance().getConfig().addDefault("version", DraimFood.getInstance().getVersion());
            DraimFood.getInstance().getConfig().addDefault("expiryDateText", expiryDateText);
            DraimFood.getInstance().getConfig().addDefault("valuesLoadedText", valuesLoadedText);
            DraimFood.getInstance().getConfig().addDefault("noPermsText", noPermsText);
            DraimFood.getInstance().getConfig().addDefault("spoiledFoodName", spoiledFoodName);
            DraimFood.getInstance().getConfig().addDefault("spoiledFoodLore", spoiledFoodLore);
            DraimFood.getInstance().getConfig().addDefault("thisItemWillNeverSpoilText", neverSpoilText);
            DraimFood.getInstance().getConfig().addDefault("timeLeftText", timeLeftText);
            DraimFood.getInstance().getConfig().addDefault("lessThanAnHour", lessThanAnHour);

            DraimFood.getInstance().getConfig().options().copyDefaults(true);
            DraimFood.getInstance().saveConfig();

            // Удаляет старую папку
            LegacyStorageManager.getInstance().deleteLegacyFiles(saveFolder);
        }
    }

    public void handleVersionMismatch() {
        // установка версии
        final DraimFood draimfood = DraimFood.getInstance();
        final FileConfiguration config = draimfood.getConfig();
        if (!config.isString("version")) {
            config.addDefault("version", draimfood.getVersion());
        } else {
            config.set("version", draimfood.getVersion());
            draimfood.saveConfig(); // Сохраняет конфигурацию после обновления значения версии.
        }

        // добавляет значения по умолчанию, если они не существуют
        DEFAULT_SPOIL_TIMES.forEach((key, value) -> {
            if (!config.isInt(key)) {
                config.addDefault(key, value);
            }
        });

        if (!config.isString("expiryDateText")) config.addDefault("expiryDateText", expiryDateText);
        if (!config.isString("valuesLoadedText")) config.addDefault("valuesLoadedText", valuesLoadedText);
        if (!config.isString("noPermsText")) config.addDefault("noPermsText", noPermsText);
        if (!config.isString("spoiledFoodName")) config.addDefault("spoiledFoodName", spoiledFoodName);
        if (!config.isString("spoiledFoodLore")) config.addDefault("spoiledFoodLore", spoiledFoodLore);
        if (!config.isString("thisItemWillNeverSpoilText")) config.addDefault("thisItemWillNeverSpoilText", neverSpoilText);
        if (!config.isString("timeLeftText")) config.addDefault("timeLeftText", timeLeftText);
        if (!config.isString("lessThanAnHour")) config.addDefault("lessThanAnHour", lessThanAnHour);
    }

    public void reload() {
        reloaded = System.currentTimeMillis();
        DraimFood.getInstance().reloadConfig();
        final FileConfiguration config = DraimFood.getInstance().getConfig();
        expiryDateText = config.getString("expiryDateText");
        valuesLoadedText = config.getString("valuesLoadedText");
        noPermsText = config.getString("noPermsText");
        spoiledFoodName = config.getString("spoiledFoodName");
        spoiledFoodLore = config.getString("spoiledFoodLore");
        timeLeftText = config.getString("timeLeftText");
        lessThanAnHour = config.getString("lessThanAnHour");
    }

    public void create() {
        final FileConfiguration config = DraimFood.getInstance().getConfig();
        config.set("version", DraimFood.getInstance().getVersion());
        DEFAULT_SPOIL_TIMES.forEach(config::set);
        config.set("expiryDateText", expiryDateText);
        config.set("valuesLoadedText", valuesLoadedText);
        config.set("noPermsText", noPermsText);
        config.set("spoiledFoodName", spoiledFoodName);
        config.set("spoiledFoodLore", spoiledFoodLore);
        config.set("timeLeftText", timeLeftText);
        config.set("lessThanAnHour", lessThanAnHour);
        DraimFood.getInstance().saveConfig();
    }
}
