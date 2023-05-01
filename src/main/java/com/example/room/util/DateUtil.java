package com.example.room.util;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static boolean isToday(LocalDate compareDay) {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        return compareDay.getYear() == cal.get(Calendar.YEAR) &&
            compareDay.getMonthValue() == cal.get(Calendar.MONTH) + 1 &&
            compareDay.getDayOfMonth() == cal.get(Calendar.DAY_OF_MONTH);
    }
}
