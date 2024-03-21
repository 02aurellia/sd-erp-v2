package PageFactory;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TimesheetPage {
    WebDriver driver;

	@FindBy(xpath = "//*[@id='editorjs']/div/div[1]/div[5]/div/div/div/div[3]")
	@CacheLookup // ensure the web elements load just once and do not have to reload whenever the method is called
	WebElement btnViewList;

    @FindBy(xpath = "//h3[normalize-space()='SD Timesheets']")
    WebElement verifyList;

    @FindBy(xpath = "(//button[@class='btn btn-primary btn-sm primary-action'])[1]")
    WebElement btnAdd;

    @FindBy(xpath = "//h3[normalize-space()='New SD Timesheets']")
    WebElement verifyTimesheet;

    @FindBy(xpath = "//*[@id=\"page-SD Timesheets\"]/div[1]/div/div/div[2]/div[2]/button")
    WebElement btnStartTimer;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    WebElement inputProject;

    @FindBy(xpath = "//ul[@id='awesomplete_list_2']//li")
    List<WebElement> listProject;

    @FindBy(xpath = "(//input[@type='text'])[5]")
    WebElement inputType;

    @FindBy(xpath = "//ul[@id='awesomplete_list_3']//li")
    List <WebElement> listType;

    @FindBy(xpath = "(//input[@type='text'])[6]")
    WebElement inputTask;

    @FindBy(xpath = "//ul[@id='awesomplete_list_4']//li")
    List <WebElement> listTask;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    WebElement inputSubTask;

    @FindBy(xpath = "//ul[@id='awesomplete_list_5']//li")
    List <WebElement> listSubTask;

    @FindBy(xpath = "(//input[@type='text'])[8]")
    WebElement inputMinutes;

    @FindBy(css = ".btn-start")
    WebElement btnStart;

    @FindBy(xpath = "//div[@class='modal-dialog msgprint-dialog']//div[@class='modal-content']")
    WebElement modalAlert;

    @FindBy(xpath = "//div[@class='modal-content']")
    WebElement modalMessage;

    @FindBy(xpath = "//button[@class='btn btn-modal-close btn-link']")
    WebElement btnCloseMessage;

    @FindBy(xpath = "//div[@class='btn-open-row']")
    WebElement btnEdit;

    @FindBy(xpath = "//div[@class='form-column col-sm-6']//div[@title='expected_hours']//input[@type='text']")
    WebElement editMinutes;

    @FindBy(xpath = "//button[@class='btn btn-secondary btn-sm pull-right grid-collapse-row']")
    WebElement btnCloseEdit;

    @FindBy(xpath = "//div[@class='ce-block col-xs-12 col-sm-5']//div[@class='widget-body']//div[1]//div[1]//div[1]")
    WebElement timesheet;

    @FindBy(xpath = "//*[@id='page-SD Timesheets']/div[1]/div/div/div[2]/div[3]/button[2]")
    WebElement btnSave;

    @FindBy(xpath = "//div[@class='menu-btn-group']")
    WebElement btnDDMenu;

    @FindBy(xpath = "//li[8]//a[1]")
    WebElement btnDelete;

    @FindBy(xpath = "//div[@class='modal fade show']//button[@type='button'][normalize-space()='Yes']")
    WebElement btnConfirmYes;

    @FindBy(xpath = "//div[@class='modal fade show']//button[@type='button'][normalize-space()='No']")
    WebElement btnConfirmNo;

    @FindBy(xpath = "//button[normalize-space()='Resume Timer']")
    WebElement btnTimer;

    @FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-dialog']//div[@class='modal-content']//div[@class='modal-body ui-front']//div//button[@class='btn btn-primary btn-complete'][normalize-space()='Complete']")
    WebElement btnComplete;

    @FindBy(xpath = "//button[@data-label='Submit']")
    WebElement btnSubmit;

    @FindBy(xpath = "//span[@class='indicator-pill whitespace-nowrap blue']")
    WebElement verifySubmit;

    
    public TimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
	}

    public void clickView() throws InterruptedException{
        btnViewList.click();
        Thread.sleep(1000);
    }

    public void listview(){
        verifyList.isDisplayed();
    }

    public void clickbtnAdd() throws InterruptedException{
        btnAdd.click();
        Thread.sleep(2000);
        verifyTimesheet.isDisplayed();
        // if (modalMessage.isDisplayed()) {
        //     btnCloseMessage.click();
        // } else {
        //     verifyTimesheet.isDisplayed();
        //     System.out.println("Timesheet");
        // }
    }

    public void clickStartTimer() throws InterruptedException{
        btnStartTimer.click();
        Thread.sleep(2000);
    }

    public void inputProject() throws InterruptedException{
        inputProject.sendKeys("General Work");
        Thread.sleep(1000);
        inputProject.sendKeys(Keys.ENTER);
    }

    public void inputProjectTest() throws InterruptedException{
        Thread.sleep(2000);
        inputProject.click();
        String OptionToSelect="General Work";
        int count=0;
        inputProject.sendKeys("Gen");
        
        Thread.sleep(1000);

        List<WebElement> optionList=listProject;

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
    }

    public void inputType() throws InterruptedException{
        inputType.sendKeys("Testing");
        // Thread.sleep(1000);
        inputType.sendKeys(Keys.ENTER);
    }

    public void inputTypeTest() throws InterruptedException{
        Thread.sleep(2000);
        inputType.click();
        String OptionToSelect2="Testing";
        int count1=0;
        inputType.sendKeys("Tes");
        
        Thread.sleep(1000);

        List<WebElement> optionList1=listType;

        for(WebElement ele:optionList1){
            String currentOption1=ele.getText();
            if(currentOption1.contains(OptionToSelect2)){
                ele.click();
                count1++;
                break;
            }
        }
        if (count1!=0) {
            System.out.println(OptionToSelect2 + " has been selected");
        }
        else {
            System.out.println("Option you want to select is not available");
        }
    }

    public void inputTask() throws InterruptedException{
        inputTask.sendKeys("Testing Task");
        // Thread.sleep(1000);
        inputTask.sendKeys(Keys.ENTER);
    }

    public void inputTaskTest() throws InterruptedException{
        Thread.sleep(2000);
        inputTask.click();
        String OptionToSelect3="Testing Task";
        int count2=0;
        inputTask.sendKeys("Tes");
        
        Thread.sleep(1000);

        List<WebElement> optionList2=listTask;

        for(WebElement ele:optionList2){
            String currentOption2=ele.getText();
            if(currentOption2.contains(OptionToSelect3)){
                ele.click();
                count2++;
                break;
            }
        }
        if (count2!=0) {
            System.out.println(OptionToSelect3 + " has been selected");
        }
        else {
            System.out.println("Option you want to select is not available");
        }
    }

    public void inputSubTask() throws InterruptedException{
        inputSubTask.sendKeys("subtask1");
        // Thread.sleep(1000);
        // inputSubTask.sendKeys(Keys.ENTER);
    }

    public void inputSubTaskTest() throws InterruptedException{
        Thread.sleep(2000);
        inputSubTask.click();
        String OptionToSelect4="subtask1";
        int count3=0;
        inputSubTask.sendKeys("sub");
        
        Thread.sleep(1000);

        List<WebElement> optionList3=listSubTask;

        for(WebElement ele:optionList3){
            String currentOption3=ele.getText();
            if(currentOption3.contains(OptionToSelect4)){
                ele.click();
                count3++;
                break;
            }
        }
        if (count3!=0) {
            System.out.println(OptionToSelect4 + " has been selected");
        }
        else {
            System.out.println("Option you want to select is not available");
        }
    }

    public void inputMinutes() {
        inputMinutes.sendKeys("120");
        inputMinutes.sendKeys(Keys.ENTER);
    }

    public void clickBtnStart(){
        btnStart.click();
    }

    public void getAlert() throws InterruptedException{
        Thread.sleep(2000);
        modalAlert.isDisplayed();
    }

    public void chooseTimesheet(){
        timesheet.click();
    }

    public void clickBtnEdit(){
        btnEdit.click();
    }

    public void editValue() throws InterruptedException{
        editMinutes.clear();
        editMinutes.sendKeys("123");
        Thread.sleep(1000);
        btnCloseEdit.click();
    }

    public void clickBtnSave(){
        btnSave.click();
        System.out.println("Berhasil edit data");
    }

    public void clickBtnDelete() throws InterruptedException{
        btnDDMenu.click();
        Thread.sleep(1000);
        btnDelete.click();
        Thread.sleep(2000);
    }

    public void confirmYes(){
        btnConfirmYes.click();
    }

    public void confirmNo(){
        btnConfirmNo.click();
    }

    public void clickBtnTimer(){
        btnTimer.click();
    }

    public void clickBtnComplete(){
        btnComplete.click();
    }

    public void clickBtnSubmit() throws InterruptedException{
        btnSubmit.click();
        Thread.sleep(1000);
        btnConfirmYes.click();
        Thread.sleep(1000);
    }

    public void successSubmit(){
        verifySubmit.isDisplayed();
    }
}
