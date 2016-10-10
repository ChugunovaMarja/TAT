package stringRules;

/**
 * extended from Rule class that 
 * specifies rule №1 "Doesnt contain numbers"
 * @param line is an original line that must be
 * checked to compliance to described rule
 */
public class NoNum extends Rule {
    
    String line;
    
    /**
     * Constructs instance with line from main class
     * @param line is a line from main class
     */
    public NoNum(String line) {
        this.line = line;
    } 
    
    /**
     * checks if line has no numbers
     * @return string message about compliance if it does
     */
    @Override
    public String checkRule() {
        if (line.matches("^\\D+$")) {
            return ("Complies rule 'Has no numbers' \n");
        } else {
            return "";
        }
    }
}
