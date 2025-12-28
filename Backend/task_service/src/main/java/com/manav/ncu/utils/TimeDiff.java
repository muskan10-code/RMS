package com.manav.ncu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDiff {
	public static void main(String args[]) {
	String dateStart = "09:29:58";
    String dateStop = "10:31:48";

    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    Date d1 = null;
    Date d2 = null;

    try {
        d1 = format.parse(dateStart);
        d2 = format.parse(dateStop);

        //in milliseconds
        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        System.out.print(diffDays + " days, ");
        System.out.print(diffHours + " hours, ");
        System.out.print(diffMinutes + " minutes, ");
        System.out.println(diffSeconds + " seconds.");
        long time=diffHours*60+diffMinutes;
        System.out.println(time);

    } catch (Exception e) {
        e.printStackTrace();
    }

	}
}
