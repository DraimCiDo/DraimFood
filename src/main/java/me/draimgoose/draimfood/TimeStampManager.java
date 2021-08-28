package me.draimgoose.draimfood;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
}
