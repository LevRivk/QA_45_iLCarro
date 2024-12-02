package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTestsDto extends ApplicationManager {
    @Test
    public void RegistrationPositiveTest(){
        UserDto user = new UserDto("Vasya","Pupkin","vasya@gmail.com","Vasya12345!");
        new HomePage(getDriver()).clickBtnLoginHeader();
        new LoginPage(getDriver()).clickBtnRegistration_ClickHere();
        new RegistrationPage(getDriver()).typeRegistrationForm(user);



    }
}
