package StepDefinition;

import PageFactory.LoginPage;
import config.env;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginTest extends env{

    public LoginTest(){
        driver = Hooks.driver;
    }

    @Given("User on login Page")
    public void user_on_login_page() throws InterruptedException {
        driver.get(SDErpLink);
        LoginPage login = new LoginPage(driver);
        login.verifyLoginPage();
    }
    @Then("User click button login")
    public void user_click_button_login() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.clickBtnLogin();
    }

    //Positive
    @Then("User input credentials")
    public void user_input_credentials() {
        LoginPage login = new LoginPage(driver);
        login.inputCredentials("aurel@falahtech.co.id", "Falah0918");
    }

    @Then("User go to dashboard page")
    public void user_go_to_dashboard_page() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.verifyDashboard();
    }

    //Negative
    @Then("User input invalid credentials")
    public void user_input_invalid_credentials() {
        LoginPage login = new LoginPage(driver);
        login.inputCredentials("jennie@falahtech.com", "Falah0918");
    }

    @Then("User get alert")
    public void user_get_alert() {
        LoginPage login = new LoginPage(driver);
        login.verifyAlert();
    }
}
