package main;

/**
 * chooser of type of source of instructions according to command line arguments
 * Created by Maria on 20.11.2016.
 */
public class SourceChooser {

    /**
     * chooses type of source of instructions according to command line arguments.
     * now this method seems me to be senseless, but i'm not sure and have no time for fixing :(
     * @param args command line arguments
     * @return type of source
     */
    public String chooseSource(String[] args) {

        if(args.length > 1) {
            return "command line";
        }
        if(args[0].equals("txt")) {
            return "txt";
        }
        if(args[0].equals("xml")) {
            return "xml";
        }
        if(args[0].equals("json")) {
            return "json";
        }

        return "Wrong arguments";
    }
}
