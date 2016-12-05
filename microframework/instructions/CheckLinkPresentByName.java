package instructions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

/**
 * checker of link present by name
 * Created by Maria on 19.11.2016.
 */
public class CheckLinkPresentByName {

    /**
     * ckecks link present by name
     * @param name is expected name
     * @param driver is an instance of chromeDriver
     * @return instance of result of instruction execution
     */
    public ResultOfInstruction checkLinkPresentByName(String name, WebDriver driver) {

        String result;
        String instruction = "CheckLinkPresentByName " + "name";
        name = name.replaceAll("\"", "");

        long start = System.currentTimeMillis();

        try {
            driver.findElement(By.name(name));
            result = "+";
        } catch (NoSuchElementException e) {
            result = "!";
        }

        long finish = System.currentTimeMillis();
        long time = finish - start;

        return (new ResultOfInstruction(result, instruction, time));
    }
}
