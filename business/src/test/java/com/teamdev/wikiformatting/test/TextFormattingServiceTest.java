package com.teamdev.wikiformatting.test;

import com.teamdev.wikiformatting.business.TextFormattingService;
import com.teamdev.wikiformatting.business.impl.WikiTextFormattingService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextFormattingServiceTest {

    private final TextFormattingService textFormattingService = new WikiTextFormattingService();

    @Test
    public void smoke_test() {
        final String testData = "=some text=";
        final String result = textFormattingService.format(testData);
        assertEquals("<h1>some text</h1>", result);
    }

    @Test
    public void test_heading_third_level() {
        final String testData = "===some text===";
        final String result = textFormattingService.format(testData);
        assertEquals("<h3>some text</h3>", result);
    }

    @Test
    public void test_invalid_heading_third_level() {
        final String testData = "===some text==";
        final String result = textFormattingService.format(testData);
        assertEquals("<h2>=some text</h2>", result);
    }

    @Test
    public void test_several_headings() {
        final String testData = "== New section ==\n" +
                "=== Subsection ===\n" +
                "Text written in subsection\n" +
                "==== Sub-subsection ====";
        final String result = textFormattingService.format(testData);
        assertEquals("<h2> New section </h2></br>" +
                "<h3> Subsection </h3></br>" +
                "Text written in subsection</br>" +
                "<h4> Sub-subsection </h4>", result);

    }

    @Test
    public void test_link() {
        final String testData = "[[Click here to google][http://google.com]]";
        final String result = textFormattingService.format(testData);
        assertEquals("<a href=http://google.com>Click here to google</a>", result);
    }

    @Test
    public void test_invalid_link() {
        final String testData = "[[Click here to google[http://google.com]]";
        final String result = textFormattingService.format(testData);
        assertEquals("[[Click here to google[http://google.com]]", result);
    }

    @Test
    public void test_bold() {
        final String testData = "*some text*";
        final String result = textFormattingService.format(testData);
        assertEquals("<b>some text</b>", result);
    }

    @Test
    public void test_invalid_bold() {
        final String testData = "*some text**";
        final String result = textFormattingService.format(testData);
        assertEquals("<b>some text*</b>", result);
    }

    @Test
    public void test_italic() {
        final String testData = "_some text_";
        final String result = textFormattingService.format(testData);
        assertEquals("<i>some text</i>", result);
    }

    @Test
    public void test_invalid_italic() {
        final String testData = "_some text__";
        final String result = textFormattingService.format(testData);
        assertEquals("<i>some text_</i>", result);
    }

    @Test
    public void test_bold_italic() {
        final String testData = "__some text__";
        final String result = textFormattingService.format(testData);
        assertEquals("<b><i>some text</i></b>", result);
    }

    @Test
    public void test_paragraph() {
        final String testData = "1st paragraph\nsecond parapgraph";
        final String result = textFormattingService.format(testData);
        assertEquals("1st paragraph</br>second parapgraph", result);
    }
}
