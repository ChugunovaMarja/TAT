import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by Maria on 04.12.2016.
 */
public class LogOutTest {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://localhost:8888/wp-login.php");
        WebElement element = driver.findElement(By.id("user_login"));
        element.sendKeys("user1");
        element = driver.findElement(By.id("user_pass"));
        element.sendKeys("user1");
        driver.findElement(By.id("wp-submit")).click();
    }

    @Test
    public void logOutTest() {

        driver.get("http://localhost:8888/");
        WebElement element = driver.findElement(By.linkText("Log out"));
        element.click();
        assertTrue(driver.getTitle().equals("Astro ‹ Log In"));
    }

    @AfterTest
    public void quit() {

        driver.quit();
    }
}
