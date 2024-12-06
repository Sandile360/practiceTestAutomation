package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    protected static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        if(driver == null){
            switch (browser.toLowerCase()){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Driver not bound.");
            }
        }

        return driver;
    }

}
