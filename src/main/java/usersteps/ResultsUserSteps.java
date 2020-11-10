package usersteps;

import org.openqa.selenium.WebDriver;
import pages.SearchResultsPageObject;

public class ResultsUserSteps {
    private SearchResultsPageObject searchResultsPageObject;

    public ResultsUserSteps(WebDriver driver) {
        this.searchResultsPageObject = new SearchResultsPageObject(driver);
    }

    public boolean resultsAreEmpty() {
        return searchResultsPageObject.getResultsTitle().isEmpty();
    }

    public int resultsSize() {
        return searchResultsPageObject.getResultsTitle().size();
    }

    public String getResultTitleAt(int index) {
        return searchResultsPageObject.getResultsTitle().get(index);
    }

    public String getResultImageAt(int index) {
        return searchResultsPageObject.getResultsImage().get(index);
    }

    public void clickOnURLAt(int index) {
        searchResultsPageObject.clickOnLinkAt(index - 1);
    }

    public void changeResultColor(String resultTitle){
        searchResultsPageObject.changeCardColor(resultTitle);
    }

    public void clickBackButton(){
        searchResultsPageObject.clickOnBackBtn();
    }

    public String readHeader(){
        return searchResultsPageObject.readResultsHeader();
    }

}
