package com.teamdev.wikiformatting.test;

import com.teamdev.wikiformatting.business.FormattingService;
import com.teamdev.wikiformatting.business.impl.FormattingServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormattingServiceTest {

    private final FormattingService formattingService = new FormattingServiceImpl();

    @Test
    public void smoke_test() throws Exception {
        String testData = "=some text=";
        final String result = formattingService.wikiToHTML(testData);
        assertEquals("<h1>some text</h1>", result);
    }

    @Test
    public void test_heading_third_level() {
        String testData = "===some text===";
        final String result = formattingService.wikiToHTML(testData);
        assertEquals("<h3>some text</h3>", result);
    }

    @Test
    public void test_invalid_heading_third_level() {
        String testData = "===some text==";
        final String result = formattingService.wikiToHTML(testData);
        assertEquals("<h3>some text</h3>", result);
    }

    @Test
    public void test_links() {
        String testData = "[[Click here to google][http://google.com]]";
        final String result = formattingService.wikiToHTML(testData);
        assertEquals("<a href=[[Click here to google][http://google.com]]>Click here to google</a>", result);
    }

    @Test
    public void test_bold() {
        String testData = "*some text*";
        final String result = formattingService.wikiToHTML(testData);
        assertEquals("<b>some text</b>", result);
    }

    @Test
    public void test_italic() {
        String testData = "_some text_";
        final String result = formattingService.wikiToHTML(testData);
        assertEquals("<i>some text</i>", result);
    }

    @Test
    public void test_bold_italic() {
        String testData = "__some text__";
        final String result = formattingService.wikiToHTML(testData);
        assertEquals("<b><i>some text</i></b>", result);
    }
}
