import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by Maria on 03.12.2016.
 */

public class RegistrationTest {

    WebDriver driver = new ChromeDriver();
    DbWorker database = new DbWorker();

    @BeforeTest
    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    }

@Test
    public void succesfulRegistrationTest() {
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    database.addUserToDb("NewUser", "NewUserPassword");
    driver.get("http://localhost:8888/wp-login.php");
    WebElement element = driver.findElement(By.id("user_login"));
    element.sendKeys("NewUser");
    element = driver.findElement(By.id("user_pass"));
    element.sendKeys("NewUserPassword");
    driver.findElement(By.id("wp-submit")).click();
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    assertTrue(driver.getTitle().equals("Astro"));
}

@AfterMethod
    public void tearDown() {
    database.deleteUserFromDb("NewUser");
}

@Test
public void registrationOfExistingUserTest() {
    driver.get("http://localhost:8888/wp-login.php?action=register");
    WebElement element = driver.findElement(By.id("user_login"));
    element.sendKeys("User1");
    element = driver.findElement(By.id("user_email"));
    element.sendKeys("random_email@gmail.com");
    driver.findElement(By.id("wp-submit")).click();
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    assertTrue(driver.getPageSource().contains("This username is already registered. Please choose another one"));
}

@Test
public void registrationOfInvalidSymbolsTest() {
    driver.get("http://localhost:8888/wp-login.php?action=register");
    WebElement element = driver.findElement(By.id("user_login"));
    element.sendKeys("!@ #$");
    element = driver.findElement(By.id("user_email"));
    element.sendKeys("random_email@gmail.com");
    driver.findElement(By.id("wp-submit")).click();
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    assertTrue(driver.getPageSource().contains("This username is invalid because it uses illegal characters. Please enter a valid username."));
}

@Test void registrationOfExtremelyLongLoginTest() {
    driver.get("http://localhost:8888/wp-login.php?action=register");
    WebElement element = driver.findElement(By.id("user_login"));
    element.sendKeys(createLongLogin());
    element = driver.findElement(By.id("user_email"));
    element.sendKeys("random_email@gmail.com");
    driver.findElement(By.id("wp-submit")).click();
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    assertTrue(driver.getPageSource().contains("ERROR"));
}


@AfterTest
    public void tearDriverDown() {
    driver.quit();
}

private String createLongLogin() {
        //TODO rewrite with StringBuilder
        String login = "";
        for(int i = 0; i < 61; i++) {
            login+="a";
    }
    return login;
}
}
