package instructions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

/**
 * checker of link presented by href
 * Created by Maria on 19.11.2016.
 */
public class CheckLinkPresentByHref {

    /**
     * checks ling presented by href
     * @param href is a link for checking
     * @param driver is an instance of chomeDriver
     * @return instance of result of instruction execution
     */
    public ResultOfInstruction checkLinkPresentHref(String href, WebDriver driver) {

        String result;
        String instruction = "CheckLinkPresentByHref ";

        long start = System.currentTimeMillis();

        try {
            driver.findElement(By.xpath("//a[@href='/" + href + "']"));
            result = "+";
        } catch (NoSuchElementException e) {
            result = "!";
        }

        long finish = System.currentTimeMillis();
        long time = finish - start;

        return (new ResultOfInstruction(result, instruction, time));
    }
}
