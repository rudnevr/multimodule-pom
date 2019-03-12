package io.cognizant.hmh.asdf;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@PageUrl("http://localhost:8080")
public class HelloWorldPage extends FluentPage {

    public HelloWorldPage checkForTitle(String text) {
        assertThat(window().title()).contains(text);
        return this;
    }

    public HelloWorldPage checkForReactComponent(String text) {
        assertEquals(text, find(".Login").first().text());
        return this;
    }

    public HelloWorldPage clickGetQuestionsButton() {
        find(".getQuestionsButton").click();
        try { Thread.sleep(1000); }
        catch (InterruptedException e) { e.printStackTrace(); }
        return this;
    }

    public HelloWorldPage checkNumberOfDisplayedQuestions(int expectedNumber) {
        assertEquals(expectedNumber, find(".question").count());
        return this;
    }

    public HelloWorldPage checkForErrorMessageDisplay(String text) {
        assertTrue($(".errorText").first().html().contains("Fetch questions failed"));
        return this;
    }
}
