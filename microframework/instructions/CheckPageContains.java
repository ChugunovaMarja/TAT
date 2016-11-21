package instructions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ckecker of containing of text on the page
 * Created by Maria on 19.11.2016.
 */
public class CheckPageContains {

    /**
     * checks if page contains expected text
     * @param text expected text
     * @param driver is an instance of chromeDriver
     * @return instance of result of instruction execution
     */
    public ResultOfInstruction checkPageContains(String text, WebDriver driver) {

        String result;
        String instruction = "CheckPageContains " + text;
        text = text.replaceAll("\"", "");

        long start = System.currentTimeMillis();

        if (driver.getPageSource().contains(text)) {
            result = "+";
        } else {
            result = "!";
        }

        long finish = System.currentTimeMillis();
        long time = finish - start;

        return (new ResultOfInstruction(result, instruction, time));
    }
}
