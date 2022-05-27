import Pages.LoginPage;
import Pages.RegistrationPage;
import Utilities.Helper;
import data.LoadProperties;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestRegisteration {

    RegistrationPage RegPage;
    String gender= LoadProperties.userInfo.getProperty("Gender");
    String fName= LoadProperties.userInfo.getProperty("firstName");
    String lName= LoadProperties.userInfo.getProperty("lastName");
    String email= LoadProperties.userInfo.getProperty("email");
    String userPass= LoadProperties.userInfo.getProperty("password");





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
