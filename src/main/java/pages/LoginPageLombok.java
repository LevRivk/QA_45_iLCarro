package pages;

import dto.UserDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageLombok extends BasePage {
    public LoginPageLombok(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        // наш конструктор
    }

    @FindBy(xpath = "//a[text()=' Log in ']")
    WebElement btnLogInHeader;
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//mat-dialog-container[@id='mat-dialog-0']")
    WebElement popUpMessage;

    @FindBy(xpath = "//div[@class='error']")
    WebElement errorMessage;

    @FindBy(xpath = "//a[@ng-reflect-router-link='let-car-work']")
    WebElement btnLetCarWork;

    @FindBy(xpath = "//button[@type='button']")
    WebElement btnOk;

    public void clickBtnOK() {
        clickWait(btnOk, 5);
    }

    public void clickBtnLetCarWork() {
        // btnLetCarWork.click();
        clickWait(btnLetCarWork, 5);
        // btnLetCarWork.click();
    }

    public boolean validateElemenIsNotPresent(String locator) {
        try {
            return new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementLocated
                    (By.xpath("//div[@class='cdk-overlay-backdrop cdk-overlay-dark-backdrop cdk-overlay-backdrop-showing']")));
        } catch (Exception e) {
            return false;
        }
    }


    public void typeLoginFormLombok(UserDtoLombok user) {
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
    }

    public void clickBtnLoginHeader() {
        btnLogInHeader.click();
    }

    public void clickBtnYallaLogin() {
        btnYalla.click();
    }
    //  public boolean isPopUpLoginMessagePresent(){
    //    pause(3);
    //  return isTextInElementPresent(popUpLoginMessageSuccess,"Logged in success");

    public boolean isPopUpLoginMessagePresent(String text) {
        pause(3);
        return isTextInElementPresent(popUpMessage, text);
    }

    public boolean validateErrorMessage(String text) {
        pause(2);
        return isTextInElementPresent(errorMessage, text);
    }
}
