package com.teamdev.wikiformatting.business.formattes;

import static com.teamdev.wikiformatting.business.utils.FormattingUtils.countNeighbors;
import static com.teamdev.wikiformatting.business.utils.FormattingUtils.replace;

public final class HeadingFormatter {

    private static final char PRESENTATION = '=';

    public static String format(String text) {

        if (text.indexOf(PRESENTATION) == -1) {
            return text;
        }

        String result = text;
        final char[] chars = text.toCharArray();

        int index = 0;
        while (index < chars.length) {

            if (text.indexOf(PRESENTATION, index) != -1) {
                index = text.indexOf(PRESENTATION, index);
                final int count = countNeighbors(PRESENTATION, chars, index);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    stringBuilder.append(PRESENTATION);
                }
                final String oldString = stringBuilder.toString();
                String firstResult = replace(result, oldString, "<h" + count + ">");
                result = replace(firstResult, oldString, "</h" + count + ">");
            }
            index++;
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(HeadingFormatter.format("==456546546=="));
    }
}
