package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FindYourCarPage;
import pages.SearchPage;
import pages.LoginPage;

import java.util.Random;

public class LoginTestsDto extends ApplicationManager {

    private String email,password;

    @BeforeMethod
    public void registration(){
        int i = new Random().nextInt(1000);
                email ="my_email"+i+"@gmail.com";
                password ="Lost!4815162342";
        new SearchPage(getDriver()).clickBtnLoginHeader();
        new LoginPage(getDriver()).typeLoginForm(email,password);
        new FindYourCarPage(getDriver()).ClickBtnLogout();
    }
    @Test
    public void loginPositiveTest() {
        UserDto user = new UserDto(email, password);
        new SearchPage(getDriver()).clickBtnLoginHeader();
        new LoginPage(getDriver()).typeLoginForm(user);
        Assert.assertTrue(new FindYourCarPage(getDriver()).isLogoutPresent());


    }
}
