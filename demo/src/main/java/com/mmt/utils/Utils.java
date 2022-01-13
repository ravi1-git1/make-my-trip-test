package com.mmt.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {


    public String seventh()    {

    SimpleDateFormat f = new SimpleDateFormat("dd");
    Calendar c = Calendar.getInstance();
    String current_day=f.format(c.getTime());
        System.out.println(current_day);
    String seventh_day= String.valueOf((Integer.parseInt(current_day)+7));
        System.out.println(seventh_day);
        return seventh_day;
    }
}
