package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ApplicationManager {

    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;

    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

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
