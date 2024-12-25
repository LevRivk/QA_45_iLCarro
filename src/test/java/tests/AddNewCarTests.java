package tests;

import dto.CarDto;
import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LetCarWorkPage;
import pages.LoginPageLombok;
import pages.SearchPage;
import utils.Fuel;
//import utils.RetryAnalyzer;

import java.util.Random;

public class AddNewCarTests extends ApplicationManager {
    LoginPageLombok loginPageLombok;
    LetCarWorkPage letCarWorkPage;

    @BeforeMethod
    public void login() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("shendonlevka@gmail.com")
                .password("Lost4815!")
                .build();
        new SearchPage(getDriver()).clickBtnLoginHeader();
        loginPageLombok = new LoginPageLombok(getDriver());
        loginPageLombok.typeLoginFormLombok(user);
        loginPageLombok.clickBtnYallaLogin();
        if (loginPageLombok.isPopUpLoginMessagePresent("Logged in success")) {
            System.out.println("login success");
            loginPageLombok.clickBtnOK();
            loginPageLombok.validateElemenIsNotPresent("");
            loginPageLombok.clickBtnLetCarWork();
        } else System.out.println("Something went wrong");
    }

    @Test//(retryAnalyzer = RetryAnalyzer.class,invocationCount = 2)

    public void addNewCarPositiveTest() {
        CarDto car = CarDto.builder()

                .serialNumber(new Random().nextInt(1000)+"-055")
                .city("Haifa")
                .manufacture("Mazda")
                .model("CX-90")
                .year("2022")
                .fuel(Fuel.HYBRID.getLocator())
                .seats(4)
                .carClass("A")
                .pricePerDay(123.99)
                .about("About my car")
                .build();
       // new letCarWorkPage(getDriver()).typeLetCarWorkForm(car);
        letCarWorkPage = new LetCarWorkPage(getDriver());
        letCarWorkPage.typeLetCarWorkForm(car);
       Assert.assertTrue(letCarWorkPage
                .isPopUpMessagePresent(car.getManufacture() + " " + car.getModel() + " " + "added successful"));
        getDriver().quit();

    }
    //Lesson 14
    @Test//(retryAnalyzer = RetryAnalyzer.class,invocationCount = 2)
    public void addNewCarNegativeTest_WOMake() {
        CarDto car = CarDto.builder()

                .serialNumber(new Random().nextInt(1000)+"-055")
                .city("Haifa")
                .manufacture("")
                .model("CX-90")
                .year("2022")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(4)
                .carClass("A")
                .pricePerDay(123.99)
                .about("About my car")
                .build();
        new LetCarWorkPage(getDriver()).typeLetCarWorkForm(car);
        letCarWorkPage = new LetCarWorkPage(getDriver());
        letCarWorkPage.typeLetCarWorkForm(car);
        Assert.assertTrue(letCarWorkPage.isElementPresentDOM("//*[text()=' Make is required ']", 5));
    }
    @Test
    public void addNewCarNegativeTest_WOModel() {
        CarDto car = CarDto.builder()

                .serialNumber(new Random().nextInt(1000) + "-055")
                .city("Haifa")
                .manufacture("Mazda")
                .model("")
                .year("2022")
                .fuel(Fuel.HYBRID.getLocator())
                .seats(3)
                .carClass("A")
                .pricePerDay(123.99)
                .about("About my car")
                .build();
        new LetCarWorkPage(getDriver()).typeLetCarWorkForm(car);
        letCarWorkPage = new LetCarWorkPage(getDriver());
        letCarWorkPage.typeLetCarWorkForm(car);
        Assert.assertTrue(letCarWorkPage.isElementPresentDOM("//*[text()=' Make is required ']", 5));
    }
}



