package pages;

import dto.UserDto;
import dto.UserDtoLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        // наш конструктор
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;
    //@FindBy(id = 'name')

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement inputLastName;
    //@FindBy(id = 'inputLastName')

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;
    //@FindBy(id = 'inputEmail')

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
    //@FindBy(id = 'password')

    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement inputCheckBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//mat-dialog-container[@id='mat-dialog-0']")
    WebElement popUpRegistrationMessageSuccess;
    @FindBy(xpath = "//div[text()=' Name is required ']")
    WebElement popUpRegistrationMessageUnSuccess_Name_is_required;
    @FindBy(xpath = "//div[text()=' Last name is required ']")
    WebElement popUpRegistrationMessageUnSuccess_Last_name_is_required;
    @FindBy(xpath = "//div[text()='Email is required']")
    WebElement popUpRegistrationMessageUnSuccess_Email_is_required;
    @FindBy(xpath = "//div[text()='Password is required']")
    WebElement popUpRegistrationMessageUnSuccess_Password_is_required;
   // @FindBy(xpath ="//h2[text()='You are logged in success']")
   // WebElement popUpMessageRegistrationSuccess_for_Unchecked_Checkbox;
    @FindBy(xpath ="//mat-dialog-container[@id='mat-dialog-1']")
     WebElement popUpMessageRegistrationSuccess_for_Unchecked_Checkbox;


    public void typeRegistrationForm(String name, String lastName, String email, String password) {
        inputName.sendKeys(name);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
    }

    public void clickCheckBox() {

        //inputCheckBox.click();
        System.out.println(inputCheckBox.getRect().getWidth() + "X" + inputCheckBox.getRect().getHeight());
        //change size
        int widthCheckbox = inputCheckBox.getRect().getWidth();
        int heightCheckBox = inputCheckBox.getRect().getHeight();
        Actions actions = new Actions(driver);
        actions.moveToElement(inputCheckBox, -widthCheckbox / 3, -heightCheckBox / 4)
                .click().perform();

    }

    public void typeRegistrationForm(UserDto user) {
        inputName.sendKeys(user.getName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        inputCheckBox.click();
    }

    public void typeRegistrationFormlombok(UserDtoLombok user) {
        inputName.sendKeys(user.getName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
    }

    public void clickBtnYalla() {
        btnYalla.click();
    }

    public boolean isPopUpRegistrationMessagePresent() {
        pause(3);

        return isTextInElementPresent(popUpRegistrationMessageSuccess, "You are logged in success");
    }

    public boolean isPopUpRegistrationMessageUnSuccess_Name_is_required() {
        return isTextInElementPresent(popUpRegistrationMessageUnSuccess_Name_is_required, "Name is required");

    }
    public boolean isPopUpRegistrationMessageUnSuccess_Last_name_is_required(){
        return isTextInElementPresent(popUpRegistrationMessageUnSuccess_Last_name_is_required,"Last name is required");
    }
    public boolean isPopUpRegistrationMessageUnSuccess_Email_is_required(){
        return isTextInElementPresent(popUpRegistrationMessageUnSuccess_Email_is_required,"Email is required");
    }
    public boolean isPopUpRegistrationMessageUnSuccess_Password_is_required(){
        return isTextInElementPresent(popUpRegistrationMessageUnSuccess_Password_is_required,"Password is required");
    }
    public boolean isPopUpMessageRegistrationSuccess_for_Unchecked_Checkbox(){
        return isTextInElementPresent(popUpMessageRegistrationSuccess_for_Unchecked_Checkbox,"You are logged in success");
    }

    public boolean isYallaButtonInactive() {
        boolean isEnabled = btnYalla.isEnabled();
        if (isEnabled) {
            System.out.println("btnYalla is Active when the Checkbox is not checked");
            return false;
        } else {
            return true;
        }
    }
}