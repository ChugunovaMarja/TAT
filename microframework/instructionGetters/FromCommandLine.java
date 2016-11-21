package instructionGetters;

import java.util.ArrayList;

/**
 * getter of instructions from command line
 * Created by Maria on 19.11.2016.
 */
public class FromCommandLine {

    /**
     * makes list of instructions from command line
     * @param parts is a string array with instructins and
     *              arguments in different cells
     * @return instance of result of instruction execution
     */
    public ArrayList reader(String[] parts) {

        ArrayList<String> instructions = new ArrayList();

        String line = parts[0];

// i know it's not a good way :(
        for (int i = 0; i < parts.length; i++) {
            if (instructionsDivider(parts[i])) {
                line = parts[i] + " " + parts[i + 1];
                instructions.add(line);
            }
        }

        return instructions;
    }

    /**
     * checks if cell of array is an instruction
     * @param part is a value of cell
     * @return true if it's an instruction
     */
    private boolean instructionsDivider(String part) {
        if (part.equals("open") || part.equals("checkLinkPresentByHref") || part.equals("checkLinkPresentByName")
                || part.equals("checkPageTitle") || part.equals("checkPageContains")) {
            return true;
        }
        return false;
    }

}
