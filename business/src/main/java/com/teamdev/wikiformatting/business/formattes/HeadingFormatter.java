package com.teamdev.wikiformatting.business.formattes;

import com.teamdev.wikiformatting.business.Formatter;

import static com.teamdev.wikiformatting.business.utils.FormattingUtils.*;

public final class HeadingFormatter implements Formatter {

    private final char PRESENTATION = '=';

    public String format(String text) {

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
