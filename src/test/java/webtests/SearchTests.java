package webtests;

import org.testng.Assert;
import org.testng.annotations.Test;
import usersteps.ResultsUserSteps;
import usersteps.SearchUserSteps;

public class SearchTests extends Baseclass {
    SearchUserSteps searchUserSteps;
    ResultsUserSteps resultsUserSteps;

    @Test
    public void searchEmptyQuery() {
        searchUserSteps = new SearchUserSteps(driver);
        searchUserSteps.clickOnSearchButton();

        searchUserSteps = new SearchUserSteps(driver);
        Assert.assertTrue(searchUserSteps.readHelperText().contains("Search cannot be empty"));
    }

    @Test
    public void searchWithResults() {
        searchUserSteps = new SearchUserSteps(driver);
        searchUserSteps.enterSearchQuery("Action");
        searchUserSteps.clickOnSearchButton();

        resultsUserSteps = new ResultsUserSteps(driver);
        Assert.assertFalse(resultsUserSteps.resultsAreEmpty());
    }

    @Test
    public void imageInSearch() {
        searchUserSteps = new SearchUserSteps(driver);
        searchUserSteps.enterSearchQuery("Batman");
        searchUserSteps.clickOnSearchButton();

        resultsUserSteps = new ResultsUserSteps(driver);
        Assert.assertFalse(resultsUserSteps.resultsAreEmpty());
        Assert.assertEquals(resultsUserSteps.getResultImageAt(0), "No image");

    }

    @Test
    public void searchBatmanFlow(){
        searchUserSteps = new SearchUserSteps(driver);
        searchUserSteps.enterSearchQuery("Batman");
        searchUserSteps.clickOnSearchButton();

        resultsUserSteps = new ResultsUserSteps(driver);
        resultsUserSteps.clickOnURLAt(2);

        driver.navigate().back();
        resultsUserSteps = new ResultsUserSteps(driver);
        Assert.assertEquals(resultsUserSteps.readHeader(), "Search results:");
        resultsUserSteps.changeResultColor("Batman Unlimited");

        resultsUserSteps = new ResultsUserSteps(driver);
        resultsUserSteps.clickBackButton();

        searchUserSteps = new SearchUserSteps(driver);
        searchUserSteps.clearSearchBox();
        Assert.assertTrue(searchUserSteps.searchBoxIsEmpty());



    }
}
