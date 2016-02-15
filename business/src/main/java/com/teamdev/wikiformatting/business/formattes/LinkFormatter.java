package com.teamdev.wikiformatting.business.formattes;

public final class LinkFormatter {

    private static final String LINK_REGEX = "\\[\\[(.+)\\]\\[(.+)\\]\\]";
    private static final String LINK_HTML_REGEX = "<a href=$0>$1</a>";

    public static String format(String text) {
        return text.replaceAll(LINK_REGEX, LINK_HTML_REGEX);
    }
}
