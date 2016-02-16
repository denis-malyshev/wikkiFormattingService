package com.teamdev.wikiformatting.business.impl;

import com.teamdev.wikiformatting.business.TextFormattingService;

public final class WikiTextFormattingService implements TextFormattingService {

    public String format(String text) {

        for (TransitionExpression transitionExpression : TransitionExpressionFactory.getWikiToHtml()) {
            text = text.replaceAll(transitionExpression.getFromPresentation(), transitionExpression.getToPresentation());
        }
        return text;
    }
}
