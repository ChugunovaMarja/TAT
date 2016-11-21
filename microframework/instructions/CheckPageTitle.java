package instructions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


/**
 * page title checker
 * Created by Maria on 19.11.2016.
 */
public class CheckPageTitle {

    /**
     * checks page title complying to expected title
     * @param title is an expected title
     * @param driver is an instance of chromeDriver
     * @return instance of result of instruction execution
     */
    public ResultOfInstruction checkPageTitle(String title, WebDriver driver) {

        String result;
        String instruction = "CheckPageTitle " + title;
        title = title.replaceAll("\"", "");

        long start = System.currentTimeMillis();

        if (title.equals(driver.getTitle())) {
            result = "+";
        } else {
            result = "!";
        }
        long finish = System.currentTimeMillis();
        long time = finish - start;

        return (new ResultOfInstruction(result, instruction, time));
    }
}
