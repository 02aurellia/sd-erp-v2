package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.env;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends env {
    static WebDriver driver;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // automation screenshot
    @AfterStep
    public void getResultStatus (Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

    // @After
    // public void browserTeardown() throws InterruptedException{
    //     Thread.sleep(5000);
    //     driver.quit();
    // }

    // @AfterAll
    // public static void finish(){
    //     DriverSingleton.delay(3);
    //     DriverSingleton.closeObjectInstance();
    // }
}
