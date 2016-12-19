import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Maria on 03.12.2016.
 */
public class CommentAdditionTest {

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
    public void commentAdditionTest() {
        //TODO add query for last comment deletion
        DbWorker database = new DbWorker();
        int numberBefore = database.getNumberOfComments();
        driver.get("http://localhost:8888/?p=1");
        WebElement element = driver.findElement(By.id("comment"));
        element.sendKeys("Some new comment 3");
        element.submit();
        int numberAfter = database.getNumberOfComments();
        assertTrue((numberAfter - numberBefore) == 1);
    }

    @Test
    public void existingCommentAdditionTest() {
        DbWorker database = new DbWorker();
        int numberBefore = database.getNumberOfComments();
        driver.get("http://localhost:8888/?p=1");
        WebElement element = driver.findElement(By.id("comment"));
        element.sendKeys("Some comment");
        element.submit();
        int numberAfter = database.getNumberOfComments();
        assertTrue((numberAfter - numberBefore) == 0);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
