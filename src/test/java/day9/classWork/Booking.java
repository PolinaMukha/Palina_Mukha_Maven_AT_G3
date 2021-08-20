package day9.classWork;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class Booking {
    WebDriver driver;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://booking.com");
    }

    @Test
    public void highestPrice() {

        WebElement el = driver.findElement(By.id("ss"));
        el.click();
        el.sendKeys("Париж");
        driver.findElement(By.xpath("//span[text()='Paris']")).click();
        driver.findElement(By.xpath("//*[@data-date='2021-08-01']")).click();
        driver.findElement(By.xpath("//*[@data-date='2021-08-08']")).click();
        driver.findElement(By.id("xp__guests__toggle")).click();

        WebElement el2 = driver.findElement(By.xpath("//button[@aria-label='Increase number of Adults']"));
        el2.click();
        el2.click();

        driver.findElement(By.xpath("//button[@aria-label='Increase number of Rooms']")).click();
        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();

        WebElement priceCheckbox = driver.findElement(By.xpath("//div[@id='filter_price']//span[contains(., '+')]"));

        String price = priceCheckbox.getText().replaceAll("\\D+", "");

        int expectedPrice = Integer.parseInt(price);
        System.out.println(expectedPrice);

        priceCheckbox.click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));

        driver.findElement(By.xpath("//a[text()='Price (lowest first)']")).click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));

        String actualMaxPriceText = driver.findElement(By.xpath("//div[@id='hotellist_inner']//span[contains(., 'Price')]")).getText();
        String priceP = actualMaxPriceText.replaceAll("\\D+", "");
        int actualPrice = Integer.parseInt(priceP) / 7;


        System.out.println(actualMaxPriceText);
        System.out.println(actualPrice);

        Assert.assertTrue("Expected hotel price", actualPrice >= expectedPrice);
    }

    @After
    public void doAfter() {
        driver.close();
        driver.quit();
    }
}

