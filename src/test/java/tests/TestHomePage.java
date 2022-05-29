
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestHomePage {
    HomePage page;

    @Parameters({ "browser"})
    @BeforeClass
    public void setup(String browser){
        page=new HomePage(this.getClass().getName(), browser);
        page.getLink("https://the-internet.herokuapp.com/");
    }


    @Test
    public void testNumberOfLinks(){
         int links = page.numberOfLinks();
        Assert.assertEquals(46,links);
    }


    @AfterClass
    public  void quit(){
        page.closeWindow();
    }

}
