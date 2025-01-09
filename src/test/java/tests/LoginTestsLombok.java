package tests;

import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPageLombok;
import pages.SearchPage;
import utils.TestNGListener;

@Listeners(TestNGListener.class)
public class LoginTestsLombok extends ApplicationManager {

    @BeforeMethod
            public void goToLoginPage(){
        new SearchPage(getDriver()).clickBtnLoginHeader();
    }
    LoginPageLombok loginPageLombok;


    @Test
    public void loginPositiveTestLombok(){
        UserDtoLombok user = UserDtoLombok.builder()
                .username("shendonlevka@gmail.com")
                .password("Lost4815!")
                .build();
        new SearchPage(getDriver()).clickBtnLoginHeader();
        loginPageLombok = new LoginPageLombok(getDriver());
        loginPageLombok.typeLoginFormLombok(user);
        loginPageLombok.clickBtnYallaLogin();
       Assert.assertTrue(loginPageLombok.isPopUpLoginMessagePresent("Logged in success"));

    }

    @Test
    public void loginNegativeTestLombok_wrongEmail(){
        UserDtoLombok user = UserDtoLombok.builder()
                .username("shendonlevkagmail.com")
                .password("Lost4815!")
                .build();
        new SearchPage(getDriver()).clickBtnLoginHeader();
        loginPageLombok = new LoginPageLombok(getDriver());
        loginPageLombok.typeLoginFormLombok(user);
        loginPageLombok.clickBtnYallaLogin();

        Assert.assertTrue(loginPageLombok.validateErrorMessage("It'snot look like email"));

    }
    @Test
    public void loginNegativeTestLombok_emptyPassword(){
        UserDtoLombok user = UserDtoLombok.builder()
                .username("shendonlevka@gmail.com")
                .password("")
                .build();
        new SearchPage(getDriver()).clickBtnLoginHeader();
        loginPageLombok = new LoginPageLombok(getDriver());
        loginPageLombok.typeLoginFormLombok(user);
        loginPageLombok.clickBtnYallaLogin();

        Assert.assertTrue(loginPageLombok.validateErrorMessage("Password is required"));

    }

}
