package stringRules;

/**
 * extended from Rule class that 
 * specifies rule №2 "Contains only numbers"
 * @param line is an original line that must be
 * checked to compliance to described rule
 */
public class OnlyNum extends Rule {
    
    String line;
    
    /**
	 * Constructs instance with line from main class
	 * @param line is a line from main class
	 */
    public OnlyNum(String line) {
        this.line = line;
    }
    
    /**
     * checks if line has only numbers
     * @return string message about compliance if it does
     */
    @Override
    public String checkRule() {
        if (line.matches("^\\d+$")) {
            return ("Complies rule 'Has only numbers' \n");
        } else {
            return null;
        }
    }
}
