package webtests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import setup.WebDriverSetup;

import java.util.concurrent.TimeUnit;

public class Baseclass {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = WebDriverSetup.getWebDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://localhost:3000/shows");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
