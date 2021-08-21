package pages.tab;

import day10.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserTab {
    WebDriver newUserDriver = Driver.getWebDriver();

    public void enterCredForNewUser(String userName, String password, String confirmPassword, String realEmail) {
        newUserDriver.findElement(By.xpath("//*[@id='tab-register']/form/div[1]/input")).sendKeys(userName);
        newUserDriver.findElement(By.xpath("//*[@id='tab-register']/form/div[2]/input")).sendKeys(password);
        newUserDriver.findElement(By.xpath("//*[@id='tab-register']/form/div[3]/input")).sendKeys(confirmPassword);
        newUserDriver.findElement(By.xpath("//*[@id='tab-register']/form/div[4]/input")).sendKeys(realEmail);
    }

    public void clickRegisterButton() {
        newUserDriver.findElement(By.xpath("//*[@id='tab-mob-register']/form/div[6]/button")).click();
    }


}
