package com.teamdev.wikiformatting.business.impl;

import java.util.*;

public abstract class TransitionExpressionFactory {

    private static final Set<TransitionExpression> WIKI_TO_HTML = new LinkedHashSet<TransitionExpression>() {{
        add(new TransitionExpression("\\n", "</br>"));
        add(new TransitionExpression("__(.*)__", "<b><i>$1</i></b>"));
        add(new TransitionExpression("_(.*)_", "<i>$1</i>"));
        add(new TransitionExpression("\\*(.*)\\*", "<b>$1</b>"));
        add(new TransitionExpression("={4}(.*)={4}", "<h4>$1</h4>"));
        add(new TransitionExpression("={3}(.*)={3}", "<h3>$1</h3>"));
        add(new TransitionExpression("={2}(.*)={2}", "<h2>$1</h2>"));
        add(new TransitionExpression("={1}(.*)={1}", "<h1>$1</h1>"));
        add(new TransitionExpression("\\[\\[(.+)\\]\\[(.+)\\]\\]", "<a href=$2>$1</a>"));
    }};

    public static Set<TransitionExpression> getWikiToHtml() {
        return WIKI_TO_HTML;
    }
}
