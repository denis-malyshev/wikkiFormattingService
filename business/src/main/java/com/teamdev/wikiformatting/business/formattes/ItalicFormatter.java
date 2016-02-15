package com.teamdev.wikiformatting.business.formattes;

import static com.teamdev.wikiformatting.business.utils.FormattingUtils.replace;

public final class ItalicFormatter {

    private static final String PRESENTATION = "_";

    public static String format(String text) {

        if (!text.contains(PRESENTATION))
            return text;

        String result = text;

        int index = 0;
        while (index < text.length()) {
            if (result.indexOf(PRESENTATION, index) != -1) {
                index = result.indexOf(PRESENTATION, index);

                if (result.indexOf(PRESENTATION, index + 1) == -1) {
                    return result;
                }

                String firstResult = replace(result, PRESENTATION, "<i>");
                result = replace(firstResult, PRESENTATION, "</i>");
            }
            index++;
        }

        return result;
    }
}
