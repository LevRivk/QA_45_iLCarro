package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchPage extends BasePage {
    //  тут мы делаем Конструктор Объекта HomePage
    public SearchPage(WebDriver driver) {
        setDriver(driver);
        driver.get("https://ilcarro.web.app/search");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);// ожидаем 10 сек появления Элемента на странице
    }


    @FindBy(xpath = "//a[text()=' Log in ']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[text()=' Sign up ']")
    WebElement btnSignUp;

public void clickBtnSignUp(){
    btnSignUp.click();
}
    // Аналог записи WebElement.findElement(By.xpath("//a[text()='Log in']")
    public void clickBtnLoginHeader() {
        btnLogin.click();
        pause(3);
    }
}
