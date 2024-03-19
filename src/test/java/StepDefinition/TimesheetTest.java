package StepDefinition;

import org.openqa.selenium.By;

import PageFactory.LoginPage;
import PageFactory.TimesheetPage;
import config.env;
import io.cucumber.java.en.*;

public class TimesheetTest extends env {
    //View

    public TimesheetTest(){
        driver = Hooks.driver;
    }

    @Given("User on homepage")
    public void user_on_homepage() throws InterruptedException {
        driver.get(SDErpLink);
        LoginPage login = new LoginPage(driver);
        login.verifyLoginPage();
        login.inputCredentials("aurel@falahtech.co.id", "Falah0918");
        login.clickBtnLogin();
        login.verifyDashboard();
    }

    @Given("User on timesheet page")
    public void user_on_timesheet_page() throws InterruptedException {
        driver.get(SDErpLinkTS);
        driver.findElement(By.xpath("(//a[contains(text(),'Login')])[2]")).click();
        LoginPage login = new LoginPage(driver);
        login.verifyLoginPage();
        login.inputCredentials("aurel@falahtech.co.id", "Falah0918");
        login.clickBtnLogin();
    }

    @Then("User click button view list")
    public void user_click_button_view_list() throws InterruptedException { 
        TimesheetPage timesheet = new TimesheetPage(driver);
        timesheet.clickView();
    }

    @Then("User see the list")
    public void user_see_the_list() {
        TimesheetPage timesheet = new TimesheetPage(driver);
        timesheet.listview();
    }

    //Add
    @Then("User click button Start Timer")
    public void user_click_button_start_timer() throws InterruptedException {
        Thread.sleep(2000);
        TimesheetPage timesheet = new TimesheetPage(driver);
        timesheet.clickStartTimer();
    }

    @Then("User choose project")
    public void user_choose_project() throws InterruptedException {
        TimesheetPage timesheet = new TimesheetPage(driver);
        timesheet.inputProjectTest();
        timesheet.inputTypeTest();
        timesheet.inputTaskTest();
        timesheet.inputSubTaskTest();
        timesheet.inputMinutes();
    }

    @Then("User click button Start")
    public void user_click_button_start() {
        TimesheetPage timesheet = new TimesheetPage(driver);
        timesheet.clickBtnStart();
    }

    @Then("User get modal alert required")
    public void user_get_modal_alert_required() throws InterruptedException {
        TimesheetPage timesheet = new TimesheetPage(driver);
        timesheet.getAlert();
    }

    @Then("User choose timesheet")
    public void user_choose_timesheet() {
        TimesheetPage timesheet = new TimesheetPage(driver);
        timesheet.chooseTimesheet();
    }

    @And("User click button edit timesheet")
    public void user_click_button_edit_timesheet() {
        TimesheetPage timesheet = new TimesheetPage(driver);
        timesheet.clickBtnEdit();
        timesheet.editValue();
    }

    @Then("User click button save")
    public void user_click_button_save() {
        TimesheetPage timesheet = new TimesheetPage(driver);
        timesheet.clickBtnSave();
    }
}
