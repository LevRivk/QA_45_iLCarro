package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;

    }

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");//для того чтобы система принужденно переводила нам на англ яз.
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

     //   var wnd = driver.manage().window();
     //   wnd.setSize(600,800);
     //   wnd.maximize();



    }
    @AfterMethod
    public void  tearDown(){
        //   if (driver != null)
        //  driver.quit();
    }

}
