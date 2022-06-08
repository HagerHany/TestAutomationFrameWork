package tests;

import Pages.RegistrationPage;
import Utilities.Helper;
import data.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class TestRegistrationJSON {

    RegistrationPage RegPage;
    @Parameters({ "browser"})
    @BeforeClass
    public void setup(String browser){
        RegPage= new RegistrationPage(this.getClass().getName(), browser);
        RegPage.goToLink("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }


    @Test
    public void Register() throws IOException, ParseException, InterruptedException {
        JsonReader jsonReader =new JsonReader();
        jsonReader.JsonDataReader();
        RegPage.enterInfo(jsonReader.gender, jsonReader.firstname, jsonReader.lastname, jsonReader.email, jsonReader.password);
        RegPage.ClickOnRegBtn();
        Assert.assertEquals("Your registration completed",RegPage.getTextLogin());
        RegPage.logOut();
        RegPage.goToLink("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @AfterMethod
    public void takeSC(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed!!!");
            System.out.println("Taking ScreenShoot......");
            Helper.captureScreenshot(RegPage.getBrowserType(this.getClass().getName()),result.getName());

        }
    }

    @AfterClass
    public void quit(){
        RegPage.closeWindow();
    }


}
