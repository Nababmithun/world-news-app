package com.example.worldnewsapp.Common;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class ISO8601Parse {

    public static Date parse(String input) throws java.text.ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");


        if (input.endsWith("Z")) {
            input = input.substring(0, input.length() - 1) + "GMT-00:00";
        } else {
            int inset = 6;

            String s0 = input.substring(0, input.length() - inset);
            String s1 = input.substring(input.length() - inset, input.length());

            input = s0 + "GMT" + s1;
        }

        return df.parse(input);

    }

    public static String toString(Date date) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");

        TimeZone tz = TimeZone.getTimeZone("UTC");

        df.setTimeZone(tz);

        String output = df.format(date);

        int inset0 = 9;
        int inset1 = 6;

        String s0 = output.substring(0, output.length() - inset0);
        String s1 = output.substring(output.length() - inset1, output.length());

        String result = s0 + s1;

        result = result.replaceAll("UTC", "+00:00");

        return result;

    }

}


