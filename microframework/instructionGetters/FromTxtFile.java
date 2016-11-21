package instructionGetters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * getter of instructions from txt file
 * Created by Maria on 19.11.2016.
 */
public class FromTxtFile {

    /**
     * reads lines in txt file
     * @return list with lines with instructions
     */
    public ArrayList reader() {

        ArrayList instructions = new ArrayList();

        BufferedReader br = null;
        String instruction;

        try {
            br = new BufferedReader(new FileReader("./instructions.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while ((instruction = br.readLine()) != null) {
                instructions.add(instruction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instructions;
    }
}
