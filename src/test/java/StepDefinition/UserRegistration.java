package StepDefinition;

import Pages.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class UserRegistration {
    RegistrationPage RegPage;


    @Given("^the user go to Registration page$")
    public void the_user_go_to_Registration_page() {
        RegPage = new RegistrationPage(this.getClass().getName(), "Chrome");
        RegPage.goToLink("https://demo.nopcommerce.com/register?returnUrl=%2F");
        assertTrue(RegPage.getCurrentURL().contains("register"));

    }


    /*@When("^I enter the user data$")
    public void i_enter_the_user_data() {
        RegPage.enterInfo("female", "Hager99", "Hany151", "hager99@gmail.com", "1234561515789");
        RegPage.ClickOnRegBtn();
    }*/
    @When("^I enter \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_enter(String gender, String firstName, String lastName, String email, String password) throws Throwable {
        RegPage.enterInfo(gender, firstName, lastName, email, password);
        RegPage.ClickOnRegBtn();
    }


    @Then("^the registration page displayed successfully$")
    public void the_registration_page_displayed_successfully() {

        Assert.assertEquals("Your registration completed", RegPage.getTextLogin());
        // RegPage.logOut();

    }
}

