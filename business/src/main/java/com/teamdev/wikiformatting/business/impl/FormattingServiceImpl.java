package com.teamdev.wikiformatting.business.impl;

import com.teamdev.wikiformatting.business.Formatter;
import com.teamdev.wikiformatting.business.FormattingService;
import com.teamdev.wikiformatting.business.formattes.*;

import javax.jws.WebService;
import java.util.HashSet;
import java.util.Set;

@WebService
public class FormattingServiceImpl implements FormattingService {

    private final Set<Formatter> formatterMap = new HashSet<Formatter>() {{
        add(new BoldFormatter());
        add(new BoldItalicFormatter());
        add(new HeadingFormatter());
        add(new ItalicFormatter());
        add(new LinkFormatter());
        add(new ParagraphFormatter());
    }};

    public String wikiToHTML(String text) {

        for (Formatter aFormatterMap : formatterMap) {
            text = aFormatterMap.format(text);
        }
        return text;
    }
}
