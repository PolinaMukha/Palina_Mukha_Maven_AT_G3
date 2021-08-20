package day9;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.util.concurrent.TimeUnit;

public class JavascriptExecutorTest {

    WebDriver driver;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.booking.com");
    }

    @Test
    public void checkColors() {
        WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
        search.click();
        search.sendKeys("Москва");
        driver.findElement(By.xpath("//button/span[contains(.,'Search')]")).click();
        WebElement hotel = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[10]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", hotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", hotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", hotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", hotel);
        String color = hotel.getCssValue("color");
        String hexColor = Color.fromString(color).asHex();
        System.out.println(hexColor);
        Assert.assertEquals("Color", "#ff0000", hexColor);
    }

    @After
    public void doAfter() {
        driver.close();
        driver.quit();
    }
}
