package Utilities;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebUIActions {
    WebDriver driver;
    BrowserActions BActions;
    public void setBrowser(String ClassName, String BrowserName){

        BActions.initializeBrowser(ClassName, BrowserName);
    }
    public WebDriver getBrowser(String ClassName){
        return BActions.map.get(ClassName);
    }


    public WebUIActions(String Name,String browser){
        BActions = new BrowserActions();
        setBrowser(Name,browser);
        driver=BrowserActions.map.get(Name);

    }

    public WebElement allocateElement(By element){
            return driver.findElement(element);
    }

    public List<WebElement> allocateElements(By element){
        List<WebElement> elements = driver.findElements(element);
        return elements;
    }

    public void navigateTo (String URL){
        driver.navigate().to(URL);
    }
    public void naviagteBack(){driver.navigate().back();}
    public void refreshPage(){driver.navigate().refresh();}


    public void onClick(By locator){

      WebElement element= allocateElement(locator);
             element.click();
    }

    public void sendKeys(By locator,String keys){
        WebElement element= allocateElement(locator);
        element.sendKeys(keys);
    }
    public String getText(By locator){
        WebElement element= allocateElement(locator);
        return   element.getText();
    }

    public int countElements(By locator){
        List<WebElement> links =allocateElements(locator);
        return links.size();
    }
    public void quit(){
        driver.quit();
    }

}
