package day9.homeWork;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHover {

    WebDriver driver;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.booking.com");
    }

    @Test
    public void checkCurrencyHint(){
        WebElement currency = driver.findElement(By.xpath("//button[@data-modal-aria-label='Select your currency']"));
        Actions currencyActions = new Actions(driver);
        currencyActions
                .moveToElement(currency)
                .perform();
        Assert.assertEquals("Choose your currency", currency.getAttribute("data-tooltip-text"));
    }

    @Test
    public void checkLanguageHint(){
        WebElement languageElement = driver.findElement(By.xpath("//button[@data-modal-aria-label='Select your language']"));
        Actions languageActions = new Actions(driver);
        languageActions
                .moveToElement(languageElement)
                .perform();
        Assert.assertEquals("Choose your language", languageElement.getAttribute("data-tooltip-text"));
    }

    @After
    public void doAfter() {
        driver.close();
        driver.quit();
    }
}
