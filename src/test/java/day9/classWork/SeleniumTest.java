package day9.classWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    //Run by default
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        //System.setProperty();
        driver.get("https://selenium.dev");
    }
}
