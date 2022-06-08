package Utilities;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserActions  {
    public static Map<String, WebDriver> map = new HashMap();

    public void initializeBrowser(String Name,String driver) {


        if (driver.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            map.put(Name, new ChromeDriver());

        } else if (driver.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            map.put(Name, new FirefoxDriver());

        }

        else if(driver.equalsIgnoreCase("Headless"))
        {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            map.put(Name, new ChromeDriver(options));

        }
    }


}