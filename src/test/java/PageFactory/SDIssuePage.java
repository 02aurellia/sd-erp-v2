package PageFactory;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath = "//a[@title='Testing Issue 9937']")
    WebElement issue;

    @FindBy(xpath = "//h3[@title='Testing Issue 9937']")
    WebElement titleIssue;

    @FindBy(xpath = "//div[@class='ql-editor']")
    WebElement editDesc;

    @FindBy(xpath = "//div[contains(text(),'Saved')]")
    WebElement MsgSuccess;

    @FindBy(xpath = "//input[@placeholder='ID']")
    WebElement inputSearch;

    @FindBy(xpath = "//p[normalize-space()='No SD Issue found']")
    WebElement resultInvalidSearch;

    @FindBy(xpath = "//a[@data-label='Assigned To']")
    WebElement btnAssignTo;

    @FindBy(xpath = "//span[normalize-space()='Me']")
    WebElement btnMe;

    @FindBy(xpath = "(//a[@data-filter='contact,=,Aurellia Az Zahra Ugan'][normalize-space()='Aurellia Az Zahra Ugan'])[1]")
    WebElement checkContact;

    @FindBy(xpath = "//select[@placeholder='Status']")
    WebElement status;

    @FindBy(xpath = "//select[@class='input-with-feedback form-control ellipsis']")
    WebElement changeStatus;

    @FindBy(xpath = "//*[@id=\"page-List/SD Issue/List\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[1]/span[1]/input")
    WebElement checklistIssue;

    @FindBy(xpath = "//div[@class='actions-btn-group']//button[@type='button']")
    WebElement btnActions;

    @FindBy(xpath = "//*[@id=\"page-List/SD Issue/List\"]/div[1]/div/div/div[2]/div[2]/div[2]/ul/li[5]/a")
    WebElement btnAddTags;

    @FindBy(xpath = "//input[@aria-expanded='true']")
    WebElement inputTags;

    @FindBy(xpath = "//ul[@id='awesomplete_list_6']//li")
    List<WebElement> listTags;

    @FindBy(css = "button[class='btn btn-primary btn-sm btn-modal-primary']")
    WebElement btnAdd;

    @FindBy(xpath = "//div[@title='tags']//div[@class='clearfix']")
    WebElement forClick;

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

    public void chooseIssue() throws InterruptedException{
        Thread.sleep(2000);
        issue.click();
        Thread.sleep(3000);
        String ActualTitle = titleIssue.getText();
        Assert.assertTrue(ActualTitle.contains("Testing Issue"));
    }

    public void editDesc(String desc) throws InterruptedException{
        editDesc.sendKeys(desc);
        Thread.sleep(1000);
    }

    public void verifSuccess() throws InterruptedException{
        Thread.sleep(2000);
        MsgSuccess.isDisplayed();
    }

    public void search(String search) throws InterruptedException{
        inputSearch.sendKeys(search);
        Thread.sleep(2000);
    }

    public void verifyResult(){
        String ActualResult = issue.getText();
        Assert.assertTrue(ActualResult.contains("Testing Issue"));
    }

    public void verifyResultInvalid() throws InterruptedException{
        Thread.sleep(2000);
        String ActualResult = resultInvalidSearch.getText();
        Assert.assertEquals("No SD Issue found", ActualResult);
    }

    public void assignToMe() throws InterruptedException{
        btnAssignTo.click();
        Thread.sleep(1000);
        btnMe.click();
    }

    public void verifyAssign(){
        String ActualResult = checkContact.getText();
        Assert.assertTrue(ActualResult.contains("Aurellia"));
    }

    public void chooseStatus(){
        Select select_status = new Select(status);
        select_status.selectByValue("Closed");
    }

    public void verifyStatus(){
        String ActualResult = status.getText();
        Assert.assertTrue(ActualResult.contains("Closed"));
    }

    public void chooseStatusIssue() throws InterruptedException{
        Select select_status = new Select(status);
        select_status.selectByIndex(0);
        Thread.sleep(2000);

        issue.click();
        Thread.sleep(3000);
        String ActualTitle = titleIssue.getText();
        Assert.assertTrue(ActualTitle.contains("Testing Issue"));
    }

    public void changeStatus(){
        Select select_status = new Select(changeStatus);
        select_status.selectByVisibleText("Closed");
    }

    public void selectIssue(){
        checklistIssue.click();
    }

    public void clickActions(){
        btnActions.click();
    }

    public void clickAddTags() throws InterruptedException{
        btnAddTags.click();
        Thread.sleep(2000);
    }

    public void addTags() throws InterruptedException{
        inputTags.sendKeys("quality"); //Quality Assurance Team, Backend Programmer, Document & UX Engineer, Frontend Programmer, Unity Level Design, Unity Programmer
        inputTags.sendKeys(Keys.ENTER);
        forClick.click();
        Thread.sleep(2000);
    }

    public void clickBtnAddTags(){
        btnAdd.click();
        verifyIssue.isDisplayed();
    }
}
