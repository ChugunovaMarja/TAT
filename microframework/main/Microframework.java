package main;

import instructions.ResultOfInstruction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * contains entry point
 * Created by Maria on 20.11.2016.
 */
public class Microframework {

    /**
     * entry point
     * @param args gets instructions or type of source of instructions
     */
    public static void main(String[] args) {
        //TODO add timeout for open instruction
        //TODO add reading instructions from xml and json files
        //TODO check for validity entered data and validity of instructions

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        ArrayList<String> instructions;
        ListOfInstructionsGetter listOfInstructionsGetter = new ListOfInstructionsGetter();
        instructions = listOfInstructionsGetter.getListOfInstructions(args);
        InstructionChooser instructionChooser = new InstructionChooser();

        ArrayList<ResultOfInstruction> results = new ArrayList();

        for (String instruction : instructions) {
            results.add(instructionChooser.chooseInstruction(instruction, driver));
        }

        File log = new File("log.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(log));
            for (ResultOfInstruction result : results) {
                String line = result.getIsPassed() + " [" + result.getInstruction() + "] " + result.getTime() + "\r\n";
                bw.write(line);
            }
            bw.write(statistics(results));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    static String statistics(ArrayList<ResultOfInstruction> results) {
        int totalTests = results.size();
        int passed = 0;
        int failed = 0;
        long totalTime = 0;

        for(ResultOfInstruction result : results) {
            if(result.getIsPassed().equals("+")) {
                passed++;
            }
            if(result.getIsPassed().equals("!")) {
                failed++;
            }
            totalTime += result.getTime();
        }

        return ("Total tests: " + totalTests + "\r\n" + "Passed/Failed: " + passed + "/" + failed +
        "\r\n" + "Total time: " + totalTime + "\r\n" + "Average time: " + (totalTime/totalTests));
    }
}
