import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by Maria on 18.12.2016.
 */
public class PostAdditionByAdminTest {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setDriverUp() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    }

    @BeforeMethod
    public void adminLogin() {
        driver.get("http://localhost:8888/wp-login.php");
        WebElement element = driver.findElement(By.id("user_login"));
        element.clear();
        element.sendKeys("Maria");
        element = driver.findElement(By.id("user_pass"));
        element.clear();
        element.sendKeys("#MbJG2J)P@A&Pc5cay");
        driver.findElement(By.id("wp-submit")).click();
    }
    @Test
    public void addingPostByAdminTest() {
        driver.get("http://localhost:8888/wp-admin/post-new.php");
        WebElement element = driver.findElement(By.id("title"));
        element.sendKeys("Post title");
        driver.findElement(By.id("publish")).click();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(driver.getTitle().equals("Edit Post ‹ Astro — WordPress"));
    }
    @AfterMethod
    public void logOut() {
        driver.close();
    }

}
