package io.young.dev.uitest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.young.dev.assertion.PageAssert;
import io.young.dev.assertion.WebElementAssert;
import io.young.dev.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    protected WebElementAssert assertThat(WebElement element) {
        return WebElementAssert.assertThat(element);
    }

    protected PageAssert assertThat(BasePage basePage) {
        return PageAssert.assertThat(basePage);
    }

    @AfterTest
    public void quit() {
        this.driver.quit();
    }
}
