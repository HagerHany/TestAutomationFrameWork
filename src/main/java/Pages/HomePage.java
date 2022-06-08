package Pages;

import Utilities.WebUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    By links=By.tagName("a");
    //By fromAuth= By.partialLinkText("Form Authentication");
    WebUIActions actions;
    public HomePage( String className, String browser){
        actions=new WebUIActions(className,browser);
    }

    public void getLink(String url){
        actions.navigateTo(url);
    }
    public void closeWindow(){
        actions.quit();
    }
    public int  numberOfLinks (){
       return actions.countElements(links) ;
    }



}
