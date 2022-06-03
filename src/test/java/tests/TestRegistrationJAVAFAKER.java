package tests;

import Pages.RegistrationPage;
import Utilities.Helper;
import com.github.javafaker.Faker;
import data.LoadProperties;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Random;

public class TestRegistrationJAVAFAKER {
    public enum Gender {
       Male,Female;
        private static final Random gender = new Random();
        public static Gender randomGender()  {
            Gender[] genders = values();
            return genders[gender.nextInt(genders.length)];
        }
    }
    RegistrationPage RegPage;
    Faker fakeData= new Faker();
    String gender= Gender.randomGender().toString();
    String fName= fakeData.name().firstName();
    String lName=fakeData.name().lastName();
    String email= fakeData.internet().emailAddress();
    String userPass= fakeData.number().digits(8);

    @Parameters({ "browser"})
    @BeforeClass
    public void setup(String browser){

        RegPage= new RegistrationPage(this.getClass().getName(), browser);
        RegPage.getLink("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @Test
    public void Register(){

        RegPage.enterInfo(gender, fName, lName, email, userPass);
        RegPage.ClickOnRegBtn();
        Assert.assertEquals("Your registration completed",RegPage.getTextLogin());

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
