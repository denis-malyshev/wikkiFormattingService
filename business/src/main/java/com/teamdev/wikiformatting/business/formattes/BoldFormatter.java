package com.teamdev.wikiformatting.business.formattes;

import static com.teamdev.wikiformatting.business.utils.FormattingUtils.replace;

public final class BoldFormatter  {

    private static final String PRESENTATION = "\\*";

    public static String format(String text) {

        if (!text.contains(PRESENTATION))
            return text;

        String result = text;

        int index = 0;
        while (index < text.length()) {
            if (text.indexOf(PRESENTATION, index) != -1) {
                index = text.indexOf(PRESENTATION, index);

                if(text.indexOf(PRESENTATION,index) == -1) {
                    return result;
                }

                String firstResult = replace(result, PRESENTATION, "<b>");
                result = replace(firstResult, PRESENTATION, "</b>");
            }
            index++;
        }

        return result;
    }
}
