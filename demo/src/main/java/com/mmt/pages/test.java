package com.mmt.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        SimpleDateFormat f = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        String current_day=f.format(c.getTime());
        System.out.println(current_day);
        String seventh_day= String.valueOf((Integer.parseInt(current_day)+7));
        System.out.println(seventh_day);
    }
}
