package pages;

import dto.UserDtoLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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
    WebElement popUpLoginMessageSuccess;

    @FindBy(xpath = "//div[@class='error']")
    WebElement errorMessage;


    public void typeLoginFormLombok(UserDtoLombok user){
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
    }
    public void clickBtnLoginHeader(){
        btnLogInHeader.click();
    }
    public void clickBtnYallaLogin(){
        btnYalla.click();
    }
  //  public boolean isPopUpLoginMessagePresent(){
    //    pause(3);
      //  return isTextInElementPresent(popUpLoginMessageSuccess,"Logged in success");

    public boolean isPopUpLoginMessagePresent(String text){
        pause(3);
        return isTextInElementPresent(popUpLoginMessageSuccess,text);
    }

    public boolean validateErrorMessage(String text){
        pause(2);
        return isTextInElementPresent(errorMessage,text);
    }
}
