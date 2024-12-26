package tests;

import manager.ApplicationManager;
import org.testng.Assert;
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
        public void searchCarNegativeTestWrongDate(){
            searchPage = new SearchPage(getDriver());
            searchPage.fillSearchCarFormWOCalendar("Haifa", "12/25/2024", "12/29/2024");
            Assert.assertTrue(letCarWorkPage.isElementPresentDOM("//div[@class='ng-star-inserted']", 5));
        }

    }

