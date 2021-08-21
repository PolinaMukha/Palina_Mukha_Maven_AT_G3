package day9.classWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestGoogleYandex {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        //System.setProperty();
        driver.get("https://google.com");
        driver.navigate().to("https://yandex.by/");
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();

        driver.close();
        driver.quit();
    }
}
