package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends ApplicationManager {
    @Test
    public void loginPositiveTest() {
        new HomePage(getDriver()).clickBtnLoginHeader();
        new LoginPage(getDriver()).typeLoginForm("levrivk@gmail.com", "Lo!4815162342");

       /* WebElement element = getDriver().findElement(By.xpath("//[@id='password']"));


        if (element.isDisplayed()) {

            System.out.println("Элемент видим");
        } else {
            System.out.println("Элемент скрыт");
        }

        */


        WebElement element = getDriver().findElement(By.xpath("//*[@id='password']"));
        if (element.isDisplayed()) {
            element.sendKeys("your_password");
        } else {
            System.out.println("Элемент недоступен или скрыт");
        }

    }
}