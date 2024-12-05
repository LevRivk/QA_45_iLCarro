package tests;

import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.SearchPage;

import java.util.Random;

public class RegistrationTestsLombok extends ApplicationManager {
    RegistrationPage registrationPage;
    @Test
    public void registrationPositiveTestLombok(){
        int i = new Random().nextInt(1000)+1000;
        UserDtoLombok user = UserDtoLombok.builder()
                .name("Bob")
                .lastName("Doe")
                .email(i+"bob_mail@gmail.com")
                .password("Pass123!")
                .build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationFormlombok(user);
       // new RegistrationPage(getDriver()).typeRegistrationFormlombok(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();

        Assert.assertTrue(registrationPage.isPopUpRegistrationMessagePresent());

    }

}
