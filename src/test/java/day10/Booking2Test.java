package day10;

import org.junit.*;
import org.openqa.selenium.WebDriver;

public class Booking2Test {
    public WebDriver webDriver;

    @Before
    public void initSecondDriver() {
        webDriver = Driver.getWebDriver();
    }

    @Test
    public void firstTest() {
        webDriver.get("https://booking.com");
        System.out.println(webDriver.getTitle());
    }

    @Test
    public void secondTest() {
        webDriver.get("https://booking.com");
        System.out.println(webDriver.getTitle());
    }
}
