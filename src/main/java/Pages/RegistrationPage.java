package Pages;

import Utilities.WebUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
/*

	@FindBy(css="a.ico-logout")
	public WebElement logoutLink;

	@FindBy(linkText="My account")
	WebElement myAccountLink;

*/
    By male=By.id("gender-male");
    By female=By.id("gender-female");
    By firstName=By.id("FirstName");
    By lastName=By.id("LastName");
    By userEmail=By.id("Email");
    By password=By.id("Password");
    By confirmPassword=By.id("ConfirmPassword");
    By registerBtn=By.id("register-button");
    By successMsg=By.cssSelector("div.result");
    By logoutBtn=By.className("ico-logout");
    WebUIActions actions;

    public RegistrationPage( String Name,String browser){
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

    public void enterInfo(String gender,String fName,String lName,String email,String Pass){
        if(gender.equalsIgnoreCase("female"))
            actions.onClick(female);
        else
            actions.onClick(male);
        actions.sendKeys(firstName,fName);
        actions.sendKeys(lastName,lName);
        actions.sendKeys(userEmail,email);
        actions.sendKeys(password,Pass);
        actions.sendKeys(confirmPassword,Pass);

    }
    public void ClickOnRegBtn(){
        actions.onClick(registerBtn);
    }
    public void logOut(){
        actions.onClick(logoutBtn);
    }

    public void closeWindow(){
        actions.quit();
    }


    public boolean UserLoggedInSucessfully(){
        try{
            actions.allocateElement(successMsg);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public String getTextLogin(){
        if(UserLoggedInSucessfully())
            return actions.getText(successMsg);
        return "" ;
    }
    public WebDriver getBrowserType(String className){
        return actions.getBrowser(className);
    }




}
