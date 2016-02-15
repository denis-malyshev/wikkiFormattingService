package com.teamdev.wikiformatting.business.utils;

public class FormattingUtils {

    public static int countNeighbors(char marker, char[] text, int index) {
        int result = 1;

        while (result < text.length && index < text.length - 1 && isNeighborEqual(marker, text[++index])) {
            result++;
        }

        return result;
    }

    public static boolean isNeighborEqual(char marker, char neighbor) {
        return marker == neighbor;
    }

    public static String replace(String text, String oldString, String newString) {
        return text.replaceFirst(oldString, newString);
    }
}
