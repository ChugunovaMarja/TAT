/**
 * 
 */
package productList;

import java.util.ArrayList;

/**
 * class for searching for entered command
 * @param commandList if a list of commands
 * @param productlist is a list of products
 * @param enteredCommand is an entered by user command
 */
public class CommandChooser {

     private ArrayList<Command> commandList = new ArrayList<>();
     
     /**
      * constructs command in list
      * @param command is command that'll be added in list
      * @return
      */
     public CommandChooser add(Command command) {
        commandList.add(command);
        return this;
    }
     
     /**
      * searches for command corresponding to entered
      * @param enteredCommand is an entered by user command
      * @param productList
      */
     public void commandChooser(String enteredCommand, ArrayList<Product> productList) {
         for (Command i : commandList) {
             if (enteredCommand.equals(i.getCommandName())) {
                 i.doCommand(productList);
             }
          }
     }
}
