package com.teamdev.wikiformatting.business.formattes;

import com.teamdev.wikiformatting.business.Formatter;

import static com.teamdev.wikiformatting.business.utils.FormattingUtils.replace;

public final class BoldFormatter implements Formatter{

    private  final String PRESENTATION = "*";

    public  String format(String text) {

        if (!text.contains(PRESENTATION))
            return text;

        String result = text;

        int index = 0;
        while (index < text.length()) {
            if (text.indexOf(PRESENTATION, index) != -1) {
                index = text.indexOf(PRESENTATION, index);

                if (text.indexOf(PRESENTATION, index + 1) == -1) {
                    return result;
                }

                String firstResult = replace(result, "\\*", "<b>");
                result = replace(firstResult, "\\*", "</b>");
            }
            index++;
        }

        return result;
    }
}
