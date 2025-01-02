package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LetCarWorkPage;
import pages.ResultsPage;
import pages.SearchPage;

import static java.sql.DriverManager.getDriver;


import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
//import pages.ResultsPage;
import pages.SearchPage;
import utils.TestNGListener;

@Listeners(TestNGListener.class)

    public class SearchCarTests extends ApplicationManager {
        SearchPage searchPage;
        LetCarWorkPage letCarWorkPage;

        @Test
        public void searchCarPositiveTest(){
            searchPage = new SearchPage(getDriver());
            searchPage.fillSearchCarFormWOCalendar("Haifa", "12/27/2024", "12/29/2024");
             Assert.assertTrue(new ResultsPage(getDriver()).isUrlResultsPresent());
        }
        @Test
        public void searchCarNegativeTest_wrongDate(){
            searchPage = new SearchPage(getDriver());
            searchPage.fillSearchCarFormWOCalendar("Haifa", "12/25/2024", "12/29/2024");
            Assert.assertTrue(searchPage.isElementPresentDOM("//div[@class='ng-star-inserted']", 5));
        }
        @Test
        public void searchCarNegativeTest_wrongCity() {
            searchPage = new SearchPage(getDriver());
            searchPage.fillSearchCarFormWOCalendar("", "12/27/2024", "12/29/2024");
             Assert.assertTrue(searchPage.isElementPresentDOM("//*[text()=' City is required ']", 5));
        }

        @Test
        public void searchCarPositiveTestWithCalendar() {
            logger.info("test searchCarPositiveTestWithCalendar with data ---->"+"Haifa"+"Jun/1/2025"+"Aug/27/2025");
            searchPage = new SearchPage(getDriver());
            searchPage.fillSearchCarFormWithCalendar("Haifa", "Jun/1/2025", "Aug/27/2025");
            Assert.assertTrue(new ResultsPage(getDriver()).isUrlResultsPresent());
        }
    }

