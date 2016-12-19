import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by Maria on 18.12.2016.
 */
public class PostAdditionBySubscriberTest {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void subscriberLogin() {
        driver.get("http://localhost:8888/wp-login.php");
        WebElement element = driver.findElement(By.id("user_login"));
        element.clear();
        element.sendKeys("user1");
        element = driver.findElement(By.id("user_pass"));
        element.clear();
        element.sendKeys("user1");
        driver.findElement(By.id("wp-submit")).click();
    }
    @Test
    public void addingPostBySubscriberTest() {
        driver.get("http://localhost:8888/wp-admin/post-new.php");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(driver.getPageSource().contains("Sorry, you are not allowed to access this page."));
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
