package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FindYourCarPage extends BasePage{
    public FindYourCarPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
        @FindBy(xpath = "//a[text()=' Logout ']")
        WebElement btnLogout;

    public void ClickBtnLogout(){
        pause(3);
        btnLogout.click();

    }
    public boolean isLogoutPresent(){
        pause(3);
       return btnLogout.isDisplayed();
    }
}
