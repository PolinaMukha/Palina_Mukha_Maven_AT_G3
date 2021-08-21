package day10;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class Booking4Test {
    public WebDriver webDriver;

    @BeforeTest
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
