package main;

import instructions.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by Maria on 20.11.2016.
 */
public class InstructionChooser {

    public ResultOfInstruction chooseInstruction(String instruction, WebDriver driver) {

        String[] line = instruction.split(" ");
        ResultOfInstruction resultOfInstruction = null;

        if (line[0].equals("open")) {
            Open open = new Open();
            resultOfInstruction = open.open(line[1], driver);
        }
        if (line[0].equals("checkLinkPresentByHref")) {
            CheckLinkPresentByHref checkLinkPresentByHref = new CheckLinkPresentByHref();
            resultOfInstruction = checkLinkPresentByHref.checkLinkPresentHref(line[1], driver);
        }
        if (line[0].equals("checkLinkPresentByName")) {
            CheckLinkPresentByName checkLinkPresentByName = new CheckLinkPresentByName();
            resultOfInstruction = checkLinkPresentByName.checkLinkPresentByName(line[1], driver);
        }
        if (line[0].equals("checkPageTitle")) {
            CheckPageTitle checkPageTitle = new CheckPageTitle();
            resultOfInstruction = checkPageTitle.checkPageTitle(line[1], driver);
        }
        if (line[0].equals("checkPageContains")) {
            CheckPageContains checkPageContains = new CheckPageContains();
            resultOfInstruction = checkPageContains.checkPageContains(line[1], driver);

        }
        return resultOfInstruction;
    }
}
