package tests;

import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.SearchPage;

import java.util.NoSuchElementException;
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
@Test
    public void registrationNegativeTest_WrongName(){
        UserDtoLombok user  = UserDtoLombok.builder()
                .name("")
                .lastName("Ivanov")
                .email("ivanov@gmail.com")
                .password("Ivanov123!")
                .build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationFormlombok(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
    Assert.assertTrue(registrationPage.isPopUpRegistrationMessageUnSuccess_Name_is_required());
}
    @Test
    public void registrationNegativeTest_WrongLastName(){
        UserDtoLombok user  = UserDtoLombok.builder()
                .name("Vanya")
                .lastName("")
                .email("ivanov@gmail.com")
                .password("Ivanov123!")
                .build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationFormlombok(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.isPopUpRegistrationMessageUnSuccess_Last_name_is_required());


    }
    @Test
    public void registrationNegativeTest_WrongEmail(){
        UserDtoLombok user  = UserDtoLombok.builder()
                .name("Vanya")
                .lastName("Ivanov")
                .email("")
                .password("Ivanov123!")
                .build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationFormlombok(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.isPopUpRegistrationMessageUnSuccess_Email_is_required());

    }
    @Test
    public void registrationNegativeTest_WrongPassword(){
        UserDtoLombok user  = UserDtoLombok.builder()
                .name("Vanya")
                .lastName("Ivanov")
                .email("ivanov@gmail.com")
                .password("")
                .build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationFormlombok(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.isPopUpRegistrationMessageUnSuccess_Password_is_required());
    }

    @Test
    public void registrationNegativeTest_Unchecked_Checkbox(){
        UserDtoLombok user  = UserDtoLombok.builder()
                .name("Vanya")
                .lastName("Ivanov")
                .email("ivanov@gmail.com")
                .password("Ivan123!")
                .build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationFormlombok(user);
        registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.isYallaButtonInactive());
    }

    @Test
    public void registrationNegativeTest_WO_Checkbox(){
        UserDtoLombok user  = UserDtoLombok.builder()
                .name("Vanya")
                .lastName("Ivanov")
                .email("ivanov@gmail.com")
                .password("Ivan123!")
                .build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationFormlombok(user);
        registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.btnYallaIsDisabled2());
    }
}
