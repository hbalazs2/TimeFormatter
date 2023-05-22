package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int seconds = random.nextInt(0, Integer.MAX_VALUE);
        System.out.println("Seconds: " + seconds);
        System.out.println(formatDuration(seconds));
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }
        //calculating each values
        int second = seconds % 60;
        int minute = (seconds / 60) % 60;
        int hour = ((seconds / 60) / 60) % 24;
        int day = (((seconds / 60) / 60) / 24) % 365;
        int year = (((seconds / 60) / 60) / 24) / 365;

        //creating arrays for the values and the expressions
        int[] valuesOfTime = {year, day, hour, minute, second};
        String[] expressionOfTime = {"year", "day", "hour", "minute", "second"};

        StringBuilder sb = new StringBuilder();

        //iterating over the arrays and building the string to return
        for (int i = 0; i < valuesOfTime.length; i++) {
            if (valuesOfTime[i] > 0) {
                sb.append(valuesOfTime[i]).append(" ").append(expressionOfTime[i]);
                if (valuesOfTime[i] > 1) {
                    sb.append("s");
                }
                sb.append(", ");
            }
        }
        //deleting the comma from the end of the string
        sb.delete(sb.length() - 2, sb.length());
        //checking for the last comma, if there is one, then it will be switched for an "and"
        int indexOfLastComma = sb.lastIndexOf(",");
        if (indexOfLastComma > -1) {
            sb.replace(indexOfLastComma, indexOfLastComma + 1, " and");
        }
        return sb.toString();
    }
}
