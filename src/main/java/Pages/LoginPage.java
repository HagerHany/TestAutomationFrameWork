package Pages;


import Utilities.WebUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    By userName=By.id("username");
    By password=By.id("password");
    By loginBtn=By.className("radius");
    By flash=By.id("flash");
    WebUIActions actions;

    public LoginPage( String Name,String browser){
        actions=new WebUIActions(Name,browser);
    }
    public void getLink(String url){
        actions.navigateTo(url);
    }
    public void goBack(){
        actions.naviagteBack();
    }
    public void refresh(){
        actions.refreshPage();
    }

    public void enterInfo(String Name,String Pass){
        actions.sendKeys(userName,Name);//tomsmith
        actions.sendKeys(password,Pass);
    }
    public void closeWindow(){
        actions.quit();
    }
    public void ClickOnLoginBtn(){
        actions.onClick(loginBtn);
    }

    public boolean UserLoggedInSucessfully(){
        try{
            actions.allocateElement(flash);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public String getTextLogin(){
        if(UserLoggedInSucessfully())
            return actions.getText(flash);
        return "" ;
    }
    public WebDriver getBrowserType(String className){
        return actions.getBrowser(className);
    }




}
