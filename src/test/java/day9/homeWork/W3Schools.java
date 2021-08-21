package day9.homeWork;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class W3Schools {
    WebDriver driver;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/java/");
    }

    @Test
    public void findWord() {
        WebElement elTutorial = driver.findElement(By.cssSelector("span.color_h1"));
        Actions makeCopyAction = new Actions(driver);
        makeCopyAction
                .doubleClick(elTutorial)
                .contextClick()
                .sendKeys(Keys.CONTROL, "c")
                .build()
                .perform();

        driver.get("https://google.com");
        WebElement el = driver.findElement(By.name("q"));
        el.click();

        Actions makePasteAction = new Actions(driver);
        makePasteAction
                .sendKeys(Keys.CONTROL, "v")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    @After
    public void doAfter() {
        driver.close();
        driver.quit();
    }
}
