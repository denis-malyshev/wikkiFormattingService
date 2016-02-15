package com.teamdev.wikiformatting.business.formattes;

import com.teamdev.wikiformatting.business.Formatter;

public final class ItalicFormatter implements Formatter {

    private final String PRESENTATION = "_";

    public String format(String text) {

        if (!text.contains(PRESENTATION))
            return text;

        int index = 0;
        while (index < text.length()) {
            if (text.indexOf(PRESENTATION, index) != -1) {
                index = text.indexOf(PRESENTATION, index);

                if (text.indexOf(PRESENTATION, index + 1) == -1) {
                    return text;
                }

                text = text.replaceFirst(PRESENTATION, "<i>");
                text = text.replaceFirst(PRESENTATION, "</i>");
            }
            index++;
        }

        return text;
    }
}
