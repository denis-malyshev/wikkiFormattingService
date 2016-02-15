package com.teamdev.wikiformatting.business.formattes;

import com.teamdev.wikiformatting.business.Formatter;

public final class LinkFormatter implements Formatter {

    private final String LINK_REGEX = "\\[\\[(.+)\\]\\[(.+)\\]\\]";
    private final String LINK_HTML_REGEX = "<a href=$0>$1</a>";

    public String format(String text) {
        return text.replaceAll(LINK_REGEX, LINK_HTML_REGEX);
    }
}
