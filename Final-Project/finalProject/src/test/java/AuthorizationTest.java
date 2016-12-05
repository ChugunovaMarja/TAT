import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.DOM.$;
import static com.codeborne.selenide.DOM.followLink;
import static com.codeborne.selenide.DOM.setValue;
import static com.codeborne.selenide.Navigation.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
//import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition.*;
/**
 * Created by Maria on 03.12.2016.
 */
public class AuthorizationTest {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    }

    @Test
    public void authorizationPositive() {

        driver.get("http://localhost:8888/wp-login.php");
        WebElement element = driver.findElement(By.id("user_login"));
        element.clear();
        element.sendKeys("user1");
        element = driver.findElement(By.id("user_pass"));
        element.sendKeys("user1");
        driver.findElement(By.id("wp-submit")).click();
        assertTrue(driver.getTitle().equals("Profile ‹ Astro — WordPress"));
    }

    @Test
    public void authorizationNegative() {
        driver.get("http://localhost:8888/wp-login.php");
        WebElement element = driver.findElement(By.id("user_login"));
        element.clear();
        element.sendKeys("notExistingUser");
        element = driver.findElement(By.id("user_pass"));
        element.sendKeys("notExistingUser");
        driver.findElement(By.id("wp-submit")).click();
        assertFalse(driver.getTitle().equals("Profile ‹ Astro — WordPress"));
    }

    @Test
    public void authorizationInvalidData() {
        //TODO add data provider for more invalid combinations
        driver.get("http://localhost:8888/wp-login.php");
        WebElement element = driver.findElement(By.id("user_login"));
        element.clear();
        element.sendKeys("!@# $%");
        element = driver.findElement(By.id("user_pass"));
        element.sendKeys("!@#$%^");
        driver.findElement(By.id("wp-submit")).click();
        assertFalse(driver.getTitle().equals("Profile ‹ Astro — WordPress"));
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
