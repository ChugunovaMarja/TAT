package stringRules;

/**
 * extended from Rule class that 
 * specifies rule №3 "Contains more that five words"
 * @param line is an original line that must be
 * checked to compliance to described rule
 */
public class MoreThanFiveWords extends Rule {

    String line;
            
    /**
     * Constructs instance with line from main class
     * @param line is a line from main class
     */
    public MoreThanFiveWords(String line) {
        this.line = line;
    }
    
    /**
     * divides original line into
     * array of separate words
     * @param line is an original line
     * @return array with separate words
     */
    public String[] intoWordsArray() {
        String[] words = line.split("[\\p{Punct}\\s]+");
        return words;
    }
    
    /**
     * checks if line has more than five words
     * @param words is the array of separate words from
     * original line
     * @return string message about compliance if it does
     */
    @Override
    public String checkRule() {
        String[] words = intoWordsArray(line);
        if (words.length>5) {
            return ("Complies rule 'Has more than 5 words' \n");
        } else {
            return "";
        }
    }
}
