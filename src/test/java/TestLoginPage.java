
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

    @DataProvider(name = "userInfo")
    public static Object[][] userInfo(){
            return new Object[][]{
                    {"tomsmith","SuperSecretPassword!"},
                    {"HgaerHany","15926348"}
            };
    }

    @Test(dataProvider = "userInfo")
    public void login(String userName, String userPass){
        loginPage.enterInfo(userName,userPass);
        loginPage.ClickOnLoginBtn();
        Assert.assertEquals("You logged into a secure area!\n" +
                "×",loginPage.getTextLogin());
        //loginPage.getLink("https://the-internet.herokuapp.com/login");
        loginPage.goBack();
        loginPage.refresh();


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
    public void quit(){
        loginPage.closeWindow();
    }


}
