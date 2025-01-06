package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import static utils.PropertiesReader.*;

public class SearchPage extends BasePage {
    //  тут мы делаем Конструктор Объекта HomePage
    public SearchPage(WebDriver driver) {
        setDriver(driver);

      //  driver.get("https://ilcarro.web.app/search");
        driver.get(getProperty("login.properties","urlStart"));



        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);// ожидаем 10 сек появления Элемента на странице
    }


    @FindBy(xpath = "//a[text()=' Log in ']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[text()=' Sign up ']")
    WebElement btnSignUp;

    @FindBy(id = "city")
    WebElement inputCity;
    @FindBy(id = "dates")
    WebElement inputDates;
    //_________________________CALENDAR
    @FindBy(xpath = "//button[@aria-label='Choose month and year']")
    WebElement buttonMonthYear;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;


public void clickBtnSignUp(){
    btnSignUp.click();
}
    // Аналог записи WebElement.findElement(By.xpath("//a[text()='Log in']")
    public void clickBtnLoginHeader() {
        btnLogin.click();
        pause(3);
    }

    public void fillSearchCarFormWOCalendar(String city, String startDate, String endDate) {
        inputCity.click();
        inputCity.sendKeys(city);

        Actions actions = new Actions(driver);
        actions.moveToElement(inputCity, 0, 40).pause(2000).click().perform();
        //=======================================
        inputDates.click();
        inputDates.sendKeys(startDate + " - " + endDate);
        inputDates.sendKeys(Keys.ENTER);
    }
    public void fillSearchCarFormWithCalendar(String city, String startDate, String endDate) {
        inputCity.click();
        inputCity.sendKeys(city);

        Actions actions = new Actions(driver);
        actions.moveToElement(inputCity, 0, 40).pause(2000).click().perform();
        //=======================================
        inputDates.click();

        String[] startdayArray = startDate.split("/");
        String[] enddayArray = endDate.split("/");
        typeYearMonthDay(startdayArray[2],startdayArray[0],startdayArray[1]);
        typeYearMonthDay(enddayArray[2],enddayArray[0],enddayArray[1]);
        clickWait(btnSubmit,3);

    }
    private void typeYearMonthDay(String year,String month,String day){

        buttonMonthYear.click();
       // driver.findElement(By.xpath("//div[contains(text(), '"+year+"')]")).click();
        //     "//div[contains(text(),'2024')]"
        //     "//div[contains(text(), '" + "2025" + "')]"
        driver.findElement(By.xpath("//div[contains(text(),'"+year+"')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + month.toUpperCase() + "')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]")).click();

    }
}
