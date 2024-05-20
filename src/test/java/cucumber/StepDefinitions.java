package cucumber;

import java.util.Random;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import cucumber.pages.SignUpPage;

public class StepDefinitions {

    private SignUpPage signUpPage;
    private Random rand;

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
        rand = new Random();
        int randomNum = rand.nextInt(10000) + 1;
        signUpPage.preencherCampoXpath("/html/body/section/div/div/div[3]/div/form/input[3]", "teste" + randomNum + "@email.com");        
        signUpPage.clicarXpath("/html/body/section/div/div/div[3]/div/form/button");
        System.out.println(randomNum);
    }

    @Then("User should be redirectioned to SignUp page")
    public void user_should_be_redirectioned_to_sign_up_page() {
        signUpPage.ehPaginaCerta("https://automationexercise.com/signup");
        signUpPage.verificarTextoPorXpath("/html/body/section/div/div/div/div[1]/h2/b","Enter Account Information");
    }

    @When("User enters an existing email on email field")
    public void user_enters_an_existing_email_on_email_field() {
        signUpPage.preencherCampoXpath("/html/body/section/div/div/div[3]/div/form/input[3]", "teste@email.com");
        signUpPage.clicarXpath("/html/body/section/div/div/div[3]/div/form/button");
    }

    @Then("User should get an error message")
    public void user_should_get_an_error_message() {
        signUpPage.verificarTextoPorXpath("/html/body/section/div/div/div[3]","Email Address already exist!");
    }

}
