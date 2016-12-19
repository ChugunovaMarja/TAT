import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by Maria on 03.12.2016.
 */
public class UserDelTest {
    WebDriver driver = new ChromeDriver();
    DbWorker database = new DbWorker();

    @BeforeTest
    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        database.addUserToDb("NewUser", "NewUserPassword");
    }

    @Test
    public void deleteTest() {
        database.deleteUserFromDb("NewUser");
        driver.get("http://localhost:8888/wp-login.php");
        WebElement element = driver.findElement(By.id("user_login"));
        element.sendKeys("NewUser");
        element = driver.findElement(By.id("user_pass"));
        element.sendKeys("NewUserPassword");
        driver.findElement(By.id("wp-submit")).click();
        assertTrue(driver.getTitle().equals("Astro ‹ Log In"));
    }

    @AfterTest
    public void tearDriverDown() {
        driver.quit();
    }
}
