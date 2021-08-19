package io.young.dev.assertion;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {

    public WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement element) {
        return new WebElementAssert(element);
    }

    public WebElementAssert isDisplayed() {
        isNotNull();
        if (!actual.isDisplayed()) {
            failWithMessage("Expected the element to be displayed. But it was not!");
        }
        return this;
    }

    public WebElementAssert isEnabled() {
        isNotNull();
        if (!actual.isEnabled()) {
            failWithMessage("Expected the element to be enabled. But it was not!");
        }
        return this;
    }

    public WebElementAssert isButton() {
        isNotNull();
        boolean isButton = actual.getTagName().equalsIgnoreCase("button") ||
                actual.getAttribute("type").equalsIgnoreCase("button");

        if (!isButton) {
            failWithMessage("Expected the element to be a button. But it was not!");
        }
        return this;
    }

    public WebElementAssert hasAttributeValue(String attr, String value) {
        isNotNull();
        if (!actual.getAttribute(attr).equals(value)) {
            failWithMessage("Expected the element to have attr <%s> value as <%s>. But It was not!", attr, value);
        }
        return this;
    }
}
