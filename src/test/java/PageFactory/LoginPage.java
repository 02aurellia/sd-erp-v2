package PageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    WebDriver driver;

	@FindBy(xpath = "//h4[contains(text(),'Login to SD-ERP')]")
	@CacheLookup // ensure the web elements load just once and do not have to reload whenever the method is called
	WebElement verifyLogin;

    @FindBy(id = "login_email")
    WebElement email;

    @FindBy(id = "login_password")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//h3[@title='Home']")
    WebElement verifDashboard;

    @FindBy(xpath = "//button[normalize-space()='Invalid Login. Try again.']")
    WebElement alertFailed;

    public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
	}

    public void verifyLoginPage() throws InterruptedException{
        Thread.sleep(1000);
        verifyLogin.isDisplayed();
    }

    public void inputCredentials(String mail, String pass){
        email.sendKeys(mail);
        password.sendKeys(pass);
    }

    public void clickBtnLogin() throws InterruptedException{
        Thread.sleep(1000);
        btnLogin.click();
    }

    public void verifyDashboard() throws InterruptedException{
        Thread.sleep(2000);
        String ActualTitle = verifDashboard.getText();
        Assert.assertEquals("Home", ActualTitle);
        System.out.println("Berhasil Login");
    }

    public void verifyAlert(){
        // alertFailed.isDisplayed();
        String ActualTitle = alertFailed.getText();
        Assert.assertEquals("Invalid Login. Try again.", ActualTitle);
        System.out.println("Gagal Login");
    }

}
