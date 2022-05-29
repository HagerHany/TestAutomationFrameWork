package tests;

import Pages.RegistrationPage;
import Utilities.Helper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;

public class TestRegistrationCSV {

    RegistrationPage RegPage;
    @Parameters({ "browser"})
    @BeforeClass
    public void setup(String browser){
        RegPage= new RegistrationPage(this.getClass().getName(), browser);
        RegPage.getLink("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }


    @Test()
    public void Register() throws CsvValidationException, IOException, InterruptedException {
        CSVReader reader;
        String csvFile= System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserInfo.csv";
        reader = new CSVReader(new FileReader(csvFile));
        String []csvCell;
        while ((csvCell= reader.readNext())!=null)
        {
            String gender= csvCell[0];
            String fName= csvCell[1];
            String lName= csvCell[2];
            String email=csvCell[3];
            String userPass= csvCell[4];
            RegPage.enterInfo(gender, fName, lName, email, userPass);
            RegPage.ClickOnRegBtn();
            Assert.assertEquals("Your registration completed",RegPage.getTextLogin());
            RegPage.logOut();
            Thread.sleep(5000);
            RegPage.getLink("https://demo.nopcommerce.com/register?returnUrl=%2F");
            Thread.sleep(5000);
        }


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
