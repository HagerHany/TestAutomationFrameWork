
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.Helper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestLoginPage {

    LoginPage loginPage;

    @Parameters({ "browser"})
    @BeforeClass
    public void setup(String browser){

        loginPage=new LoginPage(this.getClass().getName(), browser);
        loginPage.getLink("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void login(){
        loginPage.enterInfo();
        loginPage.ClickOnLoginBtn();
        Assert.assertEquals("You logged into a secure area!\n" +
                "×",loginPage.getTextLogin());
    }

    @AfterMethod
    public void takeSC(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed!!!");
            System.out.println("Taking ScreenShoot......");
            Helper.captureScreenshot(loginPage.getBrowserType(this.getClass().getName()),result.getName());

        }
    }
    @AfterClass
    public void close(){
        loginPage.closeWindow();
    }

}
