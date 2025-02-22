package tests;

import data_providers.CarDP;
import dto.CarDto;
import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LetCarWorkPage;
import pages.LoginPageLombok;
import pages.SearchPage;
import utils.Fuel;
import utils.TestNGListener;

import java.lang.reflect.Method;
import java.util.Random;
import static utils.PropertiesReader.*;
import static utils.TakeScreenShot.*;


@Listeners(TestNGListener.class)

public class AddNewCarTests extends ApplicationManager {
    LoginPageLombok loginPageLombok;
    LetCarWorkPage letCarWorkPage;

    @BeforeMethod
    public void login() {
//        UserDtoLombok user = UserDtoLombok.builder()
//                .email("shendonlevka@gmail.com")
//                .password("Lost4815!")
//                .build();
        UserDtoLombok user = UserDtoLombok.builder()
              .username(getProperty("login.properties","email"))
                .password(getProperty("login.properties","password"))
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
        takeScreenShot((TakesScreenshot) getDriver());
       Assert.assertTrue(letCarWorkPage
                .isPopUpMessagePresent(car.getManufacture() + " " + car.getModel() + " " + "added successful"));
        getDriver().quit();

    }
    //Lesson 14
    @Test
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
    @Test
    public void addNewCarNegativeTest_WOYear() {
        CarDto car = CarDto.builder()

                .serialNumber(new Random().nextInt(1000)+"-055")
                .city("Haifa")
                .manufacture("Mazda")
                .model("CX-90")
                .year("")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(4)
                .carClass("A")
                .pricePerDay(123.99)
                .about("About my car")
                .build();
        new LetCarWorkPage(getDriver()).typeLetCarWorkForm(car);
        letCarWorkPage = new LetCarWorkPage(getDriver());
        letCarWorkPage.typeLetCarWorkForm(car);
        Assert.assertTrue(letCarWorkPage.isElementPresentDOM("//*[contains(text(), ' Year required ')]", 5));
    }
    @Test(dataProvider = "dataProviderCarFile",dataProviderClass = CarDP.class)
    public void addNewCarPositiveTestDP(CarDto car, Method method) {
       logger.info(method.getName()+"Start with data -->" + car.toString());
        letCarWorkPage = new LetCarWorkPage(getDriver());
        letCarWorkPage.typeLetCarWorkForm(car);
        Assert.assertTrue(letCarWorkPage
                .isPopUpMessagePresent(car.getManufacture() + " " + car.getModel() + " " + "added successful"));
        getDriver().quit();

    }

    @Test(dataProvider = "dataProviderCarFileProperties",dataProviderClass = CarDP.class)
    public void addNewCarPositiveTestDPProperties(CarDto car, Method method) {
        logger.info(method.getName()+"Start with data -->" + car.toString());
        letCarWorkPage = new LetCarWorkPage(getDriver());
        letCarWorkPage.typeLetCarWorkForm(car);
        Assert.assertTrue(letCarWorkPage
                .isPopUpMessagePresent(car.getManufacture() + " " + car.getModel() + " " + "added successful"));
        getDriver().quit();

    }
}



