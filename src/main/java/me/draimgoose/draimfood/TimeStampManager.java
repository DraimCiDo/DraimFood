package me.draimgoose.draimfood;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeStampManager {

    private static TimeStampManager instance;

    private TimeStampManager() {

    }

    public static TimeStampManager getInstance() {
        if (instance == null) {
            instance = new TimeStampManager();
        }
        return instance;
    }

    String pattern = "MM/dd/yyyy HH";

    public ItemStack assignTimeStamp(ItemStack item, int hoursUntilSpoilage) {
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setLore(asList(
                    "",
                    ChatColor.WHITE + ConfigManager.getInstance().expiryDateText,
                    ChatColor.WHITE + getDateStringPlusTime(hoursUntilSpoilage)
            ));

            item.setItemMeta(meta);
        }

        return item;
    }

    private Date getDate() {
        return Calendar.getInstance().getTime();
    }

    private String getDateStringPlusTime(int hours) {
        return new SimpleDateFormat(pattern).format(getDatePlusTime(hours));
    }

    private Date getDatePlusTime(int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    public boolean timeStampAssigned(ItemStack item) {
        if (item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null && meta.hasLore()) {
                List<String> lore = meta.getLore();

                if (lore != null) {
                    return lore.toString().contains(ConfigManager.getInstance().expiryDateText);
                }
            }
        }

        return false;
    }

    public boolean timeReached(ItemStack item) {
        String timestamp = getTimeStamp(item);

        if (timestamp != null) {

            DateFormat df = new SimpleDateFormat(pattern + ":mm:ss");

            timestamp = timestamp + ":01:01";
            timestamp = timestamp.substring(2);

            Date date = null;
            try {
                date = df.parse(timestamp);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так при разборе метки времени " + timestamp + " с патерном " + pattern + ":mm:ss");
            }

            if (date != null) {
                return getDate().after(date);
            }
        }
        return false;
    }
}
