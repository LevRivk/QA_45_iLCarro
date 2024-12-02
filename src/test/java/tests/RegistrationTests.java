package tests;

import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.Random;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        new HomePage(getDriver()).clickBtnLoginHeader();
        new LoginPage(getDriver()).clickBtnRegistration_ClickHere();
        new RegistrationPage(getDriver()).typeRegistrationForm("my_name","my_last_name","my_email"+i+"@gmail.com","Lo!4815162342");
        new RegistrationPage(getDriver()).clickCheckBox();


    }
}
