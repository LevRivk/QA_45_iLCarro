package pages;

import dto.UserDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }
    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
   @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement inputCheckBox;




    public void typeRegistrationForm(String name,String lastName,String email,String password){
        inputName.sendKeys(name);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
    }
    public void clickCheckBox(){

         inputCheckBox.click();
    }
    public void typeRegistrationForm(UserDto user){
        inputName.sendKeys(user.getName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        inputCheckBox.click();
    }
}
