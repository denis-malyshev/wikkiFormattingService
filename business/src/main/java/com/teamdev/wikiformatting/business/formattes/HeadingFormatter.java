package com.teamdev.wikiformatting.business.formattes;

import com.teamdev.wikiformatting.business.Formatter;

import static com.teamdev.wikiformatting.business.utils.FormattingUtils.buildPresentation;
import static com.teamdev.wikiformatting.business.utils.FormattingUtils.countNeighbors;

public final class HeadingFormatter implements Formatter {

    private final char PRESENTATION = '=';

    public String format(String text) {

        if (text.indexOf(PRESENTATION) == -1) {
            return text;
        }

        final char[] chars = text.toCharArray();

        int index = 0;
        while (index < chars.length) {

            if (text.indexOf(PRESENTATION, index) != -1) {
                index = text.indexOf(PRESENTATION, index);
                final int count = countNeighbors(PRESENTATION, chars, index);
                final String oldString = buildPresentation(PRESENTATION, count);
                if (text.indexOf(oldString, index + 1) != -1) {
                    text = text.replaceFirst(oldString, "<h" + count + ">");
                    text = text.replaceFirst(oldString, "</h" + count + ">");
                }
            }
            index++;
        }

        return text;
    }
}
