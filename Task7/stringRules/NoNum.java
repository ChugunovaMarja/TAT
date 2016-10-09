package stringRules;

/**
 * extended from Rule class that 
 * specifies rule №1 "Doesnt contain numbers"
 * @param line is an original line that must be
 * checked to compliance to described rule
 */
public class NoNum extends Rule {
    
    String line;
    
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
            return ("Complies rule 'Has no numbers'");
        } else {
            return null;
        }
    }
}
