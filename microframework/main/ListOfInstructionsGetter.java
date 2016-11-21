package main;

import instructionGetters.FromCommandLine;
import instructionGetters.FromTxtFile;

import java.util.ArrayList;

/**
 * getter of list of instructions from the chosen source
 * Created by Maria on 20.11.2016.
 */
public class ListOfInstructionsGetter {

    /**
     * gets list of instructions from the chosen source
     * @param args command line arguments, containing instructions or type of source of instructions
     * @return list of instructions
     */
    public ArrayList getListOfInstructions(String[] args) {

        ArrayList instructions = new ArrayList();

        SourceChooser sourceChooser = new SourceChooser();
        String source = sourceChooser.chooseSource(args);

        if(source.equals("command line")) {
            FromCommandLine fromCommandLine = new FromCommandLine();
            instructions = fromCommandLine.reader(args);
        }
        if(source.equals("json")) {

        }
        if(source.equals("txt")) {
            FromTxtFile fromTxtFile = new FromTxtFile();
            instructions = fromTxtFile.reader();
        }
        if(source.equals("xml")) {

        }

        return instructions;
    }
}
