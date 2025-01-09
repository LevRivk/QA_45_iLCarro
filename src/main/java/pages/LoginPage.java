package pages;

import dto.UserDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{
        public LoginPage(WebDriver driver){
            setDriver(driver);
            PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);// ожидаем 10 сек появления Элемента на странице
        }
            @FindBy(xpath = "//span[text()='Click here']")
            WebElement btnRegistration_ClickHere;

        public void clickBtnRegistration_ClickHere(){
           btnRegistration_ClickHere.click();

        }
        @FindBy(xpath = "//input[@id='email']")
        WebElement loginInputEmail;
        @FindBy(xpath = "//label[@for='password']")
        WebElement loginInputPassword;
        @FindBy(xpath = "//label[@for='password']")   // НЕ РАБОТАЕТ ПОЧЕМУ ТО НЕ НАХОДИТ
        WebElement loginInputPassword_2;
        @FindBy(xpath = "//button[text()='Y’alla!']")
        WebElement btnLogin_Yalla_;
    public void typeLoginForm(String email,String password){

        loginInputEmail.sendKeys(email);
        loginInputPassword.sendKeys(password);
        loginInputPassword_2.click();
        btnLogin_Yalla_.click();
    }
    public void typeLoginForm(UserDto user){

        loginInputEmail.sendKeys(user.getEmail());
        loginInputPassword.sendKeys(user.getPassword());
        btnLogin_Yalla_.click();
    }

    }



