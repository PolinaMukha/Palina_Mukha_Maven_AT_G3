package day9.classWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class SeleniumTestWeather {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://google.com");
        WebElement el = driver.findElement(By.name("q"));
        el.click();
        el.sendKeys("погода Минск");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(., 'сейчас')]")).click();

        driver.findElement(By.xpath("//div[@id='wob_dp']/div[2]")).click();
        Thread.sleep(1000);

        String dateOfWeek =
                DateTimeFormatter.ofPattern("EEEE")
                        .withLocale(new Locale("be", "BY"))
                        .format(LocalDate.now().plus(1, ChronoUnit.DAYS));
        System.out.println(dateOfWeek);

        WebElement el2 = driver.findElement(
                By.xpath(String.format("//*[contains(@aria-label, 'Celsius %s 12:00')][1]", dateOfWeek)));

        System.out.println(el2.getAttribute("aria-label").split("°")[0]);

        driver.close();
        driver.quit();
    }
}
