package com.test.spruceeats.tests;

import com.test.spruceeats.pages.SeaFoodPage;
import com.test.spruceeats.pages.SearchResultPage;
import com.test.spruceeats.pages.SpruceEatsHomePage;
import org.testng.annotations.Test;

public class HomePageTest extends SpruceEatsTestBase{

    @Test
    public void validateClick() throws InterruptedException {
        SpruceEatsHomePage spruceEatsHomePage = new SpruceEatsHomePage(driver);
        SeaFoodPage seaFoodPage = new SeaFoodPage(driver);
        spruceEatsHomePage.selectFishAndSeaFood(driver, "Fish & Seafood");
        Thread.sleep(1000);
        seaFoodPage.searchFunction(driver, "Fish for dinner");
        Thread.sleep(1000);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.searchingRoasterSalmon("6-Ingredient Roasted Salmon Fillets");
        Thread.sleep(1000);
    }
}
