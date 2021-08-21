package pages.tab;

import day10.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressManagerTab {
    WebDriver addressManagerDriver = Driver.getWebDriver();

    public void enterLoginAndPass(String userName, String password) {
        addressManagerDriver.findElement(By.xpath("//*[@id='tab-manager']/form/div[1]/input")).sendKeys(userName);
        addressManagerDriver.findElement(By.xpath("//*[@id='tab-manager']/form/div[2]/input")).sendKeys(password);
    }

    public void clickRegisterButton() {
        addressManagerDriver.findElement(By.xpath("//*[@id='tab-manager']/form/div[4]/button")).click();
    }
}
