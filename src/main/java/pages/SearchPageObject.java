package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPageObject extends BasePage {
    /* locate elements */
    @FindBy(how = How.XPATH, using = "//input[@name='search']")
    private WebElement searchBox;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement searchBtn;
    @FindBy(how = How.XPATH, using = "//span[@class='helper-text']")
    private WebElement helperTxt;

    public SearchPageObject(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    /* interact with elements */
    public void enterSearchQuery(String query) {
        searchBox.sendKeys(query);
    }

    public void clearSearchBox(){
        searchBox.clear();
    }

    public void clickOnSearchBtn() {
        searchBtn.click();
    }

    public String readHelperTxt() {
        return helperTxt.getText();
    }

    public boolean searchboxIsEmpty(){
        return searchBox.getText().equals("");
    }

}
