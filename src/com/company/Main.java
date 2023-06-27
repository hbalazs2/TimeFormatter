package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int seconds = random.nextInt(0, Integer.MAX_VALUE);
            System.out.println("Seconds: " + seconds);
            System.out.println(formatDuration(seconds));
        }
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }
        //calculating each values
        int second = seconds % 60;
        int minute = seconds / 60;
        int hour = minute  / 60;
        int day = hour / 24;
        int year = day / 365;
        minute %= 60;
        hour %= 24;
        day %= 365;

        //creating arrays for the values and the expressions
        int[] valuesOfTime = creatingValuesOfTimeArray(year, day, hour, minute, second);
        String[] expressionOfTime = {"year", "day", "hour", "minute", "second"};

        StringBuilder sb = creatingStringBuilder();

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

        return adjustingStringBuilder(sb).toString();
    }

    private static int[] creatingValuesOfTimeArray(int year, int day, int hour, int minute, int second) {
        return new int[]{year, day, hour, minute, second};
    }

    private static StringBuilder creatingStringBuilder() {
        return new StringBuilder();
    }

    private static StringBuilder adjustingStringBuilder(StringBuilder sb) {
        //deleting the comma from the end of the string
        sb.delete(sb.length() - 2, sb.length());
        //checking for the last comma, if there is one, then it will be switched for an "and"
        int indexOfLastComma = sb.lastIndexOf(",");
        if (indexOfLastComma > -1) {
            sb.replace(indexOfLastComma, indexOfLastComma + 1, " and");
        }
        return sb;
    }
}
