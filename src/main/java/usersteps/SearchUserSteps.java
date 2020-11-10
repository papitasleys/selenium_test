package usersteps;

import org.openqa.selenium.WebDriver;
import pages.SearchPageObject;

public class SearchUserSteps {
    private SearchPageObject searchPageObject;

    public SearchUserSteps(WebDriver driver) {
        this.searchPageObject = new SearchPageObject(driver);
    }

    public void enterSearchQuery(String query) {
        searchPageObject.clearSearchBox();
        searchPageObject.enterSearchQuery(query);
    }

    public String readHelperText() {
        return searchPageObject.readHelperTxt();
    }

    public void clickOnSearchButton() {
        searchPageObject.clickOnSearchBtn();
    }

    public void clearSearchBox(){
        searchPageObject.clearSearchBox();
    }

    public boolean searchBoxIsEmpty(){
        return searchPageObject.searchboxIsEmpty();
    }
}
