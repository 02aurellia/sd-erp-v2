package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.LoginPage;
import PageFactory.TimesheetPage;
import config.env;

public class TimesheetTest2 extends env {
    //View

    public static void main(String[] args) throws InterruptedException {
        coba();
    }

    public static void coba() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.101.88:3033/app/sd-timesheets/new-sd-timesheets-1");

        driver.findElement(By.xpath("(//a[contains(text(),'Login')])[2]")).click();
        LoginPage login = new LoginPage(driver);
        login.verifyLoginPage();
        login.inputCredentials("aurel@falahtech.co.id", "Falah0918");
        login.clickBtnLogin();
        System.out.println("Dah masuk nih");

        TimesheetPage timesheet = new TimesheetPage(driver);
        timesheet.clickStartTimer();
        timesheet.inputProjectTest();
        timesheet.inputTypeTest();
        timesheet.inputTaskTest();
        timesheet.inputSubTaskTest();
        timesheet.inputMinutes();
        
        // //Select Project
        // Thread.sleep(2000);
        // String OptionToSelect="General Work";
        // int count=0;
        // driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Gen");
        
        // Thread.sleep(1000);

        // List<WebElement> optionList=driver.findElements(By.xpath("//ul[@id=\"awesomplete_list_2\"]//li"));

        // for(WebElement ele:optionList){
        //     String currentOption=ele.getText();
        //     if(currentOption.contains(OptionToSelect)){
        //         ele.click();
        //         count++;
        //         break;
        //     }
        // }
        // if (count!=0) {
        //     System.out.println(OptionToSelect + " has been selected");
        // }
        // else {
        //     System.out.println("Option you want to select is not available");
        // }

        // //Select Activity Type
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("(//input[@type='text'])[5]")).click();
        // String OptionToSelect2="Testing";
        // int count1=0;
        // driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("Tes");
        
        // Thread.sleep(1000);

        // List<WebElement> optionList1=driver.findElements(By.xpath("//ul[@id=\"awesomplete_list_3\"]//li"));

        // for(WebElement ele:optionList1){
        //     String currentOption1=ele.getText();
        //     if(currentOption1.contains(OptionToSelect2)){
        //         ele.click();
        //         count1++;
        //         break;
        //     }
        // }
        // if (count1!=0) {
        //     System.out.println(OptionToSelect2 + " has been selected");
        // }
        // else {
        //     System.out.println("Option you want to select is not available");
        // }

        // //Select Task
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("(//input[@type='text'])[6]")).click();
        // String OptionToSelect3="Testing Task";
        // int count2=0;
        // driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("Tes");
        
        // Thread.sleep(1000);

        // List<WebElement> optionList2=driver.findElements(By.xpath("//ul[@id=\"awesomplete_list_4\"]//li"));

        // for(WebElement ele:optionList2){
        //     String currentOption2=ele.getText();
        //     if(currentOption2.contains(OptionToSelect3)){
        //         ele.click();
        //         count2++;
        //         break;
        //     }
        // }
        // if (count2!=0) {
        //     System.out.println(OptionToSelect3 + " has been selected");
        // }
        // else {
        //     System.out.println("Option you want to select is not available");
        // }

        // //Select Sub Task
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("(//input[@type='text'])[7]")).click();
        // String OptionToSelect4="subtask1";
        // int count3=0;
        // driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("sub");
        
        // Thread.sleep(1000);

        // List<WebElement> optionList3=driver.findElements(By.xpath("//ul[@id=\"awesomplete_list_5\"]//li"));

        // for(WebElement ele:optionList3){
        //     String currentOption3=ele.getText();
        //     if(currentOption3.contains(OptionToSelect4)){
        //         ele.click();
        //         count3++;
        //         break;
        //     }
        // }
        // if (count3!=0) {
        //     System.out.println(OptionToSelect4 + " has been selected");
        // }
        // else {
        //     System.out.println("Option you want to select is not available");
        // }

        // //Input Timer
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("120");
        // driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys(Keys.ENTER);
        
        // //Click button
        // driver.findElement(By.cssSelector(".btn-start")).click();
    }
}
