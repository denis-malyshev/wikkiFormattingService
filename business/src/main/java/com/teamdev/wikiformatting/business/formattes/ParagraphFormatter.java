package com.teamdev.wikiformatting.business.formattes;

import com.teamdev.wikiformatting.business.Formatter;

public final class ParagraphFormatter implements Formatter {

    public String format(String text) {
        return text.replaceAll("\\n", "&#13;&#10;");
    }

    public static void main(String[] args) {
        ParagraphFormatter paragraphFormatter = new ParagraphFormatter();
        System.out.println(paragraphFormatter.format("sdfsdf\nsdf"));
    }
}
