package day9.homeWork;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DemoQa {
    static WebDriver driver;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/select-menu");
}
    @Test
    public void checkSelectValue() {
        WebElement selectValue = driver.findElement(By.xpath("//div[@class='mt-2 row'][1]/div/div/div[@class=' css-yk16xz-control']"));
        selectValue.click();
        Actions getValue = new Actions(driver);
        getValue.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        System.out.println(selectValue.getText());
        Assert.assertEquals("Group 2, option 1", selectValue.getText());
    }

    @Test
    public void checkSelectOne() {
        WebElement selectOne = driver.findElement(By.xpath("//div[@class='mt-2 row'][2]/div/div/div[@class=' css-yk16xz-control']"));
        selectOne.click();
        Actions makeOne = new Actions(driver);
        makeOne.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        System.out.println(selectOne.getText());
        Assert.assertEquals("Dr.", selectOne.getText());
    }

        @Test
        public void checkOldStyleSelectMenu() {
            WebElement colors = driver.findElement(By.id("oldSelectMenu"));
            Select selectColor = new Select(colors);
            selectColor.selectByValue("4");
            String color = driver.findElement(By.xpath("//select[@id='oldSelectMenu']/option[@value='4']")).getText();
            System.out.println(color);
            Assert.assertEquals("Purple", color);
        }

        @Test
        public void checkStandardMultiSelect() {
        WebElement cars = driver.findElement(By.id("cars"));
        Select selectCars = new Select(cars);
        selectCars.selectByValue("volvo");
        String car = driver.findElement(By.xpath("//select[@id='cars']/option[@value='volvo']")).getText();
        System.out.println(car);
        Assert.assertEquals("Volvo", car);
    }

    @AfterClass
    public static void doAfter() {
        driver.close();
        driver.quit();
    }
}
