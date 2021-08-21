package pages;

import day10.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TrashMailPage {

    WebDriver trashMailPage;

    public void doBefore() {
        trashMailPage = new ChromeDriver();
        trashMailPage.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        trashMailPage.manage().window().maximize();
        trashMailPage.get("https://trashmail.com/");
    }

    @After
    public void doAfter() {
        trashMailPage.close();
        trashMailPage.quit();
    }
}
