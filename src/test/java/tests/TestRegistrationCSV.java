package tests;

import Pages.RegistrationPage;
import Utilities.Helper;
import data.ExcelReader;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class TestRegistrationCSV {

    RegistrationPage RegPage;
    @Parameters({ "browser"})
    @BeforeClass
    public void setup(String browser){
        RegPage= new RegistrationPage(this.getClass().getName(), browser);
        RegPage.getLink("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }
    @DataProvider(name = "userInfo")
    public static Object[][] userInfo() throws IOException {
        //read from excel
        ExcelReader reader =new ExcelReader();
        return reader.getExcelData();

    }

    @Test(dataProvider="userInfo")
    public void Register(String gender, String fName, String lName, String email, String userPass) throws InterruptedException {
        RegPage.enterInfo(gender, fName, lName, email, userPass);
        RegPage.ClickOnRegBtn();
        Assert.assertEquals("Your registration completed",RegPage.getTextLogin());
        RegPage.logOut();
        RegPage.getLink("https://demo.nopcommerce.com/register?returnUrl=%2F");
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
