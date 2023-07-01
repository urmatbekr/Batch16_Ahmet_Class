package com.test.etsy.tests;

import com.test.blaze.pages.HomePage;
import com.test.etsy.pages.EtsyHomepage;
import com.test.etsy.pages.SearchResultPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchingTest extends EtsyBase{
    @Parameters ({"searchkeywords", "keyword1", "keyword2", "keyword3"})
    @Test
    public void validateSearchFunction(String searchkeywords, String keyword1,String keyword2,String keyword3) throws InterruptedException {
    EtsyHomepage etsyHomepage = new EtsyHomepage(driver);
        etsyHomepage.searchFunction(searchkeywords);

    SearchResultPage searchResultPage = new SearchResultPage(driver);
    searchResultPage.checkingName(keyword1,keyword2,keyword3); //"iphone", "13", "case"
    }
}
