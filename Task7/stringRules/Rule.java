package stringRules;

/**
 * parent abstract class 
 * colligates classes of specified rules
 */
abstract public class Rule {
    
    /**
     * abstract method for checking compliance to rule;
     * will be overloaded in child classes
     * @return string with message about compliance
     */
    abstract public String checkRule();
    
    /**
     * divides original line into
     * array of separate words
     * @param line is an original line
     * @return array with separate words
     */
    public String[] intoWordsArray(String line) {
        String[] words = line.split("[\\p{Punct}\\s]+");
        return words;
    } 
}
