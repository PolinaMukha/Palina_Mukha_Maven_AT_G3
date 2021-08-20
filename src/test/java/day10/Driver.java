package day10;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static WebDriver webDriver;

    public static void initDriver(Config config) {
        if (null == webDriver) {
            webDriver = DriverManager.getDriver(config);
        }
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(Config.CHROME);
        }
        return webDriver;
    }

    public static void destroy() {
        webDriver.close();
        webDriver.quit();
        webDriver = null;
    }
}
