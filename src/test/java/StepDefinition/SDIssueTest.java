package StepDefinition;

import org.openqa.selenium.By;

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
        driver.get(SDErpLink); //endpoint url sd erp
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
        driver.get(SDErpLinkIssue); //endpoint url sd issue
        driver.findElement(By.xpath("(//a[contains(text(),'Login')])[2]")).click();
        LoginPage login = new LoginPage(driver);
        login.verifyLoginPage();
        login.inputCredentials("aurel@falahtech.co.id", "Falah0918");
        login.clickBtnLogin();
    }

    @And("User input issue")
    public void user_input_issue() throws InterruptedException {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.inputIssue("Testing Issue ", "Ini deskripsi buat test sd issue yaaa");
    }

    @And("User click button Save")
    public void user_click_button_save() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.clickBtnSave();
    }

    @Then("User success add SD Issue")
    public void user_success_add_sd_issue() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.verifySuccess();
    }

    @Then("User get alert require field")
    public void user_get_alert_require_field() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.getAlertRequired();
    }
    
    @Then("User choose Issue")
    public void user_choose_issue() throws InterruptedException {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.chooseIssue();
    }
    @Then("User edit Issue")
    public void user_edit_issue() throws InterruptedException {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.editDesc(". Ini deskripsi edit edit edit");
    }
    @Then("User get alert success")
    public void user_get_alert_success() throws InterruptedException {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.verifSuccess();
    }

    @And("User search issue by subject")
    public void user_search_issue_by_subject() throws InterruptedException {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.search("Testing Issue");
    }
    @Then("User get the result")
    public void user_get_the_result() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.verifyResult();
    }

    @And("User search invalid issue by subject")
    public void user_search_invalid_issue_by_subject() throws InterruptedException {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.search("Testinggggggg");
    }
    @Then("User get no result")
    public void user_get_no_result() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.verifyResultInvalid();
    }

    @And("User click assign to me")
    public void user_click_assign_to_me() throws InterruptedException {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.assignToMe();
    }
    @Then("User get result")
    public void user_get_result() {
        SDIssuePage issue = new SDIssuePage(driver);
        issue.verifyAssign();
    }

}
