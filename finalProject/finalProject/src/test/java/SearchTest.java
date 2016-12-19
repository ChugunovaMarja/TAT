import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Maria on 04.12.2016.
 */
public class SearchTest {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    }

    @Test
    public void searchTestPositive() {
        driver.get("http://localhost:8888");

        WebElement element;
        element = driver.findElement(By.className("search-toggle"));
        element.click();
        element = driver.findElement(By.className("search-field"));
        element.sendKeys("Aurora");
        element.submit();
        assertTrue(driver.getPageSource().contains("Search Results for:"));

    }

    @Test
    public void searchTestNegative() {
        driver.get("http://localhost:8888");

        WebElement element;
        element = driver.findElement(By.className("search-toggle"));
        element.click();
        element = driver.findElement(By.className("search-field"));
        element.sendKeys("Not existing postname");
        element.submit();
        assertTrue(driver.getPageSource().contains("Nothing Found"));
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
