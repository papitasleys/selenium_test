package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected String baseURL;

    public BasePage(WebDriver driver, String baseURL) {
        this.driver = driver;
        this.baseURL = baseURL;
        PageFactory.initElements(driver, this);
    }

}
