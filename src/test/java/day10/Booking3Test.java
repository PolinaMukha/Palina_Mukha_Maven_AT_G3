package day10;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Booking3Test {
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

    static {
        doBeforeAll();
        doAfterAll();
    }

    private static void doBeforeAll() {
        Driver.initDriver(Config.valueOf("CHROME"));
    }

    private static void doAfterAll(){
        Runtime.getRuntime().addShutdownHook(new Thread(Driver::destroy));
    }
}
