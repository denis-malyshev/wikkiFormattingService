package com.teamdev.wikiformatting.business.formattes;

import static com.teamdev.wikiformatting.business.utils.FormattingUtils.*;

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

            if (result.indexOf(PRESENTATION, index) != -1) {
                index = result.indexOf(PRESENTATION, index);
                final int count = countNeighbors(PRESENTATION, chars, index);
                final String oldString = buildPresentation(PRESENTATION, count);
                if (result.indexOf(oldString, index + 1) != -1) {
                    String firstResult = replace(result, oldString, "<h" + count + ">");
                    result = replace(firstResult, oldString, "</h" + count + ">");
                }
            }
            index++;
        }

        return result;
    }
}
