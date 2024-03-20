package PageFactory;

import java.util.List;
import java.util.Random;

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

    @FindBy(xpath = "//*[@id='page-SD Issue']/div[1]/div/div/div[1]/div/div/div[1]/h3")
    WebElement verifyIssueSuccess;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm primary-action']")
    WebElement btnAddIssue;

    @FindBy(xpath = "(//input[@type='text'])[5]")
    WebElement inputPriority;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    WebElement inputSubject;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    WebElement inputTask;

    @FindBy(xpath = "//div[@class='ql-container ql-snow']//div[@class='ql-editor ql-blank']")
    WebElement inputDesc;

    @FindBy(xpath = "//button[@data-label='Save']")
    WebElement btnSave;

    @FindBy(xpath = "//div[@class='msgprint']")
    WebElement alertRequired;

    @FindBy(xpath = "//ul[@id='awesomplete_list_4']//li")
    List<WebElement> listTask;

    @FindBy(xpath = "//ul[@id='awesomplete_list_15']//li")
    List<WebElement> listPriority;

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

    public void inputIssue(String subject, String desc) throws InterruptedException{
        Thread.sleep(2000);
        String OptionToSelect="High";
        int count=0;
        inputPriority.sendKeys("High");
        
        Thread.sleep(1000);

        List<WebElement> optionList=listTask;

        for(WebElement ele:optionList){
            String currentOption=ele.getText();
            if(currentOption.contains(OptionToSelect)){
                ele.click();
                count++;
                break;
            }
        }
        if (count!=0) {
            System.out.println(OptionToSelect + " has been selected");
        }
        else {
            System.out.println("Option you want to select is not available");
        }

        //Random number for subject Issue
        Random rand = new Random();
        int issueRand = rand.nextInt(10000);
        inputSubject.sendKeys(subject+issueRand);

        Thread.sleep(2000);
        inputTask.click();
        String OptionToSelect1="Testing Task";
        int count1=0;
        inputTask.sendKeys("Testing Task");
        
        Thread.sleep(1000);

        List<WebElement> optionList1=listTask;

        for(WebElement ele:optionList1){
            String currentOption1=ele.getText();
            if(currentOption1.contains(OptionToSelect1)){
                ele.click();
                count1++;
                break;
            }
        }
        if (count1!=0) {
            System.out.println(OptionToSelect1 + " has been selected");
        }
        else {
            System.out.println("Option you want to select is not available");
        }

        inputDesc.sendKeys(desc);
        Thread.sleep(2000);
    }

    public void clickBtnSave(){
        btnSave.click();
    }

    public void verifySuccess(){
        verifyIssueSuccess.isDisplayed();
    }

    public void getAlertRequired(){
        alertRequired.isDisplayed();
    }

}
