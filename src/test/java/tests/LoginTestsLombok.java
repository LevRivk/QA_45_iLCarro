package tests;

import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPageLombok;
import pages.SearchPage;


public class LoginTestsLombok extends ApplicationManager {
    LoginPageLombok loginPageLombok;
    @Test
    public void loginPositiveTestLombok(){
        UserDtoLombok user = UserDtoLombok.builder()
                .email("shendonlevka@gmail.com")
                .password("Lost4815!")
                .build();
        new SearchPage(getDriver()).clickBtnLoginHeader();
        loginPageLombok = new LoginPageLombok(getDriver());
        loginPageLombok.typeLoginFormLombok(user);
        loginPageLombok.clickBtnYallaLogin();

       Assert.assertTrue(loginPageLombok.isPopUpLoginMessagePresent());

    }
}
