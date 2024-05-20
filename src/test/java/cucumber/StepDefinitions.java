package cucumber;

import java.util.Random;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import cucumber.pages.SignUpPage;

public class StepDefinitions {

    private SignUpPage signUpPage;
    
    @Given("User is on Homepage")
    public void user_is_on_homepage() {
        this.signUpPage = new SignUpPage();
    }

    @Given("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        signUpPage.clicarLogin("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a");
    }

    @When("User enters a name on name field")
    public void user_enters_a_name_on_name_field() {
        signUpPage.preencherCampoXpath("/html/body/section/div/div/div[3]/div/form/input[2]", "Teste 1");
    }

    @When("User enters an email on email field")
    public void user_enters_an_email_on_email_field() {
        Random rand = new Random();
        int randomNum = rand.nextInt((10000 - 1) + 1) + 1;
        signUpPage.preencherCampoXpath("/html/body/section/div/div/div[3]/div/form/input[3]", "teste" + randomNum + "@email.com");
        signUpPage.clicarXpath("/html/body/section/div/div/div[3]/div/form/button");
    }

    @Then("User should be redirectioned to SignUp page")
    public void user_should_be_redirectioned_to_sign_up_page() {
        signUpPage.ehPaginaCerta("https://automationexercise.com/signup");
        signUpPage.verificarTextoPorXpath("/html/body/section/div/div/div/div[1]/h2/b","Enter Account Information");
    }
}
