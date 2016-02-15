package com.teamdev.wikiformatting.business.formattes;

public final class ParagraphFormatter {

    private static final String PRESENTATION = "\\" + "n";

    public static String format(String text) {
        return text.replaceAll(PRESENTATION, "&#13;&#10;");
    }
}
