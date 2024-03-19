package StepDefinition;

import PageFactory.LoginPage;
import PageFactory.SDIssuePage;
import config.env;
import io.cucumber.java.en.*;

public class SDIssueTest extends env {
    
    public SDIssueTest(){
        driver = Hooks.driver;
    }

    @Given("User in homepage")
    public void user_in_homepage() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.verifyLoginPage();
        login.inputCredentials("aurel@falahtech.co.id", "Falah0918");
        login.clickBtnLogin();
        login.verifyDashboard();
    }
    @And("User go to Projects page")
    public void user_go_to_projects_page() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.clickProjects();
    }
    @And("User go to SD Issues page")
    public void user_go_to_sd_issues_page() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.clickIssue();
    }
    @Then("User see list SD Issue")
    public void user_see_list_sd_issue() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.verifyIssuePage();
    }

    @Given("User on SD Issues Page")
    public void user_on_sd_issues_page() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.verifyLoginPage();
        login.inputCredentials("aurel@falahtech.co.id", "Falah0918");
        login.clickBtnLogin();
        login.verifyDashboard();
        SDIssuePage issue = new SDIssuePage(driver);
        issue.clickProjects();
        issue.clickProjects();
        issue.clickIssue();
        issue.verifyIssuePage();
    }
    @And("User click button Add SD Issue")
    public void user_click_button_add_sd_issue() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.addIssue();
        issue.verifyIssuePage();
    }
    @And("User input issue")
    public void user_input_issue() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.inputIssue("HIGH", "Testing Issue", "TESTING TASK", "Ini deskripsi buat test sd issue yaaa");
    }
    @And("User click button Save")
    public void user_click_button_save() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.clickBtnSave();
    }
    @Then("User success add SD Issue")
    public void user_success_add_sd_issue() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.verifyIssuePage();
    }
}
