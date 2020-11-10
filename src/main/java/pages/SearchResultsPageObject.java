package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPageObject extends BasePage {
    /* locate elements */
    @FindBy(how = How.XPATH, using = "//div[@class='container']/h2")
    private WebElement searchResultsHeader;
    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
    private WebElement backBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='col s12']")
    private List<WebElement> resultsContainerList;

    public SearchResultsPageObject(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    /* interact with elements */
    public String readResultsHeader() {
        return searchResultsHeader.getText();
    }

    public void clickOnBackBtn() {
        backBtn.click();
    }

    public List<String> getResultsTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(searchResultsHeader));
        List<String> titleList = new ArrayList<String>();
        System.out.println(resultsContainerList.size());
        for (WebElement resultContainer : resultsContainerList) {
            WebElement title = resultContainer.findElement(By.xpath(".//span[@class='card-title']"));
            System.out.println(title.getText());
            titleList.add(title.getText());
        }

        return titleList;
    }

    public List<String> getResultsImage() {
        List<String> imageList = new ArrayList<String>();
        for (WebElement resultContainer : resultsContainerList) {
            try {
                WebElement image = resultContainer.findElement(By.xpath(".//img"));
                imageList.add(image.getAttribute("src"));
            }catch (NoSuchElementException e){
                imageList.add("No image");
            }
        }
        return imageList;
    }

    public void clickOnLinkAt(int index){
        WebElement linkInCard = resultsContainerList.get(index).findElement(By.xpath(".//a[text() = 'URL']"));
        linkInCard.click();
    }

    public void changeCardColor(String resultTitle){
        for (WebElement resultContainer : resultsContainerList) {
            WebElement title = resultContainer.findElement(By.xpath(".//span[@class='card-title']"));
            if (title.getText().equals(resultTitle)){
                WebElement background = resultContainer.findElement(By.xpath(".//div[@class='card light-blue darken-1']"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].setAttribute('background-color', '#4a148c')", background);
            }
        }
    }
}
