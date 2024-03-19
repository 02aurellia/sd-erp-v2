package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SDIssuePage {
    WebDriver driver;

    @FindBy(xpath = "//span[@class='sidebar-item-label'][normalize-space()='Projects']")
	@CacheLookup // ensure the web elements load just once and do not have to reload whenever the method is called
	WebElement btnProjects;

    @FindBy(xpath = "//span[@title='SD Issues']")
    WebElement btnSDIssues;

    @FindBy(xpath = "//h3[normalize-space()='SD Issue']")
    WebElement verifyIssue;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm primary-action']")
    WebElement btnAddIssue;

    @FindBy(xpath = "//div[@title='priority']//input[@role='combobox']")
    WebElement inputPriority;

    @FindBy(xpath = "//div[@title='subject']//input[@type='text']")
    WebElement inputSubject;

    @FindBy(xpath = "//div[@title='task_issue']//input[@role='combobox']")
    WebElement inputTask;

    @FindBy(xpath = "//div[@class='ql-container ql-snow']//div[@class='ql-editor ql-blank']")
    WebElement inputDesc;

    @FindBy(xpath = "//button[@data-label='Save']")
    WebElement btnSave;

    public SDIssuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
	}

    public void clickProjects(){
        btnProjects.click();
    }

    public void clickIssue(){
        btnSDIssues.click();
    }

    public void verifyIssuePage(){
        verifyIssue.isDisplayed();
    }

    public void addIssue(){
        btnAddIssue.click();
    }

    public void inputIssue(String priority, String subject, String task, String desc){
        inputPriority.sendKeys(priority);
        inputPriority.sendKeys(Keys.ENTER);
        inputSubject.sendKeys(subject);
        inputTask.sendKeys(task);
        inputTask.sendKeys(Keys.ENTER);
        inputDesc.sendKeys(desc);
    }

    public void clickBtnSave(){
        btnSave.click();
    }

}
