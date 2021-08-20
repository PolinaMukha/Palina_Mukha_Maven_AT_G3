package day10;

import org.junit.*;
import org.openqa.selenium.WebDriver;

public class BookingTest {
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

    static {
        doBeforeAll();
        doAfterAll();
    }

    private static void doBeforeAll() {
        Driver.initDriver(Config.valueOf(System.getProperty("BROWSER")));
    }

    private static void doAfterAll(){
        Runtime.getRuntime().addShutdownHook(new Thread(Driver::destroy));
    }
}
