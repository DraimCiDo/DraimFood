package me.draimgoose.draimfood;

import org.bukkit.Material;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import static org.bukkit.Material.*;

public class LegacyStorageManager {

    private static LegacyStorageManager instance;

    private LegacyStorageManager() {

    }

    public static LegacyStorageManager getInstance() {
        if (instance == null) {
            instance = new LegacyStorageManager();
        }
        return instance;
    }

    public final HashMap<Material, Integer> spoilTimes = new HashMap<>();

    public void legacyLoadValuesFromConfig() {

        try {
            System.out.println("Попытка загрузить время порчи еды...");
            Scanner loadReader = new Scanner(new File("./plugins/DraimFood/" + "draimfood-times.txt"));

            // фактическая загрузка

            // игнорирование версию
            /*String temp1 = */
            loadReader.nextLine();

            // игнорирование второй строки
            /*String temp2 = */
            loadReader.nextLine();

            int value = -1;
            if (loadReader.hasNextLine()) {
                // получение значения из каждой строки конфигурации и установка их в соответствующее поле
                value = getValueFromConfigLine(loadReader.nextLine()); // строка 2
                if (value != -1) {
                    spoilTimes.put(BREAD, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine()); // строка 3
                if (value != -1) {
                    spoilTimes.put(POTATO, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine()); // строка 4
                if (value != -1) {
                    spoilTimes.put(CARROT, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine()); // строка 5
                if (value != -1) {
                    spoilTimes.put(BEETROOT, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(BEEF, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(PORKCHOP, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(CHICKEN, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(COD, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(SALMON, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(MUTTON, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(RABBIT, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(TROPICAL_FISH, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(PUFFERFISH, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(MUSHROOM_STEW, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(RABBIT_STEW, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(BEETROOT_SOUP, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(COOKED_BEEF, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(COOKED_PORKCHOP, value);
                }

            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(COOKED_CHICKEN, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(COOKED_SALMON, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(COOKED_MUTTON, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(COOKED_RABBIT, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(COOKED_COD, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(WHEAT, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(MELON, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(PUMPKIN, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(BROWN_MUSHROOM, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(RED_MUSHROOM, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(NETHER_WART, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(MELON, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(CAKE, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(PUMPKIN, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(SUGAR, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(EGG, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(SUGAR_CANE, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(APPLE, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(COOKIE, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(POISONOUS_POTATO, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(CHORUS_FRUIT, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(DRIED_KELP, value);
                }
            }

            if (loadReader.hasNextLine()) {
                value = getValueFromConfigLine(loadReader.nextLine());
                if (value != -1) {
                    spoilTimes.put(BAKED_POTATO, value);
                }
            }

            loadReader.close();
            System.out.println("Время порчи еды успешно загружено.");
        } catch (FileNotFoundException e) {
            System.out.println("Возникла проблема с загрузкой времени порчи еды!");
        }
    }

    public void legacyLoadCustomText() {
        try {
            System.out.println("Попытка загрузить текст о порче еды...");
            File loadFile = new File("./plugins/DraimFood/" + "draimfood-text.txt");
            Scanner loadReader = new Scanner(loadFile);

            // фактическая загрузка

            if (loadReader.hasNextLine()) {
                ConfigManager.getInstance().expiryDateText = loadReader.nextLine();
            }
            if (loadReader.hasNextLine()) {
                ConfigManager.getInstance().valuesLoadedText = loadReader.nextLine();
            }
            if (loadReader.hasNextLine()) {
                ConfigManager.getInstance().noPermsText = loadReader.nextLine();
            }
            if (loadReader.hasNextLine()) {
                ConfigManager.getInstance().spoiledFoodName = loadReader.nextLine();
            }
            if (loadReader.hasNextLine()) {
                ConfigManager.getInstance().spoiledFoodLore = loadReader.nextLine();
            }


            loadReader.close();
            System.out.println("Текст о порче еды успешно загружен.");
        } catch (FileNotFoundException e) {
            System.out.println("Возникла проблема с загрузкой текста о порче еды!");
        }
    }

    public int getValueFromConfigLine(String line) {

        // формат: "FoodType: (value) часов"

        int firstSpaceIndex = line.indexOf(" ");
        int lastSpaceIndex = line.lastIndexOf(" ");

        int value = 0;
        try {
            value = Integer.parseInt(line.substring(firstSpaceIndex + 1, lastSpaceIndex));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так при получении значения из строки конфигурации.");
            return -1;
        }

        return value;
    }
}