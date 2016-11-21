package instructions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * website opener
 * Created by Maria on 19.11.2016.
 */
public class Open {

    public static String url;

    /**
     * opens website on url
     * @param urlPart is a url of website
     * @param driver is an instance of chomeDriver
     * @return instance of result of instruction execution
     */
    public ResultOfInstruction open(String urlPart, WebDriver driver) {

        long start = System.currentTimeMillis();

        this.url = urlPart.replaceAll("\"", "");
        driver.get(url);

        long finish = System.currentTimeMillis();
        long time = finish - start;

        String instruction = "open " + urlPart;

        return (new ResultOfInstruction("+", instruction, time));
    }

}
