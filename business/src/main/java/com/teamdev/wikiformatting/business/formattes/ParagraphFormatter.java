package com.teamdev.wikiformatting.business.formattes;

import com.teamdev.wikiformatting.business.Formatter;

public final class ParagraphFormatter implements Formatter {

    public String format(String text) {
        return text.replaceAll("\\n", "&#13;&#10;");
    }
}
