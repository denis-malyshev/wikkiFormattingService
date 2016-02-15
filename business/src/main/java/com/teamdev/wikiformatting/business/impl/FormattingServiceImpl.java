package com.teamdev.wikiformatting.business.impl;

import com.teamdev.wikiformatting.business.FormattingService;
import com.teamdev.wikiformatting.business.formattes.*;

import javax.jws.WebService;

@WebService
public class FormattingServiceImpl implements FormattingService {

    public String wikiToHTML(String text) {
        return LinkFormatter.
                format(BoldFormatter.
                        format(HeadingFormatter.
                                format(ItalicFormatter.
                                        format(BoldItalicFormatter.
                                                format(
                                                        ParagraphFormatter.format(text)
                                                )))));
    }
}
