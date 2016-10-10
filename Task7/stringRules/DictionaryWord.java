package stringRules;

/**
 * extended from Rule class that 
 * specifies rule №4 "Contains word from dictionary"
 * @param line is an original line that must be
 * checked to compliance to described rule
 * @param dictionary is an array of dictionary words
 * @param result contains message about compliance
 */
public class DictionaryWord extends Rule {
    
    String line;
    private String[] dictionary = {"mama", "myla", "ramu"};
    private String result = null;
    
        
    /**
     * Constructs instance with line from main class
     * @param line is a line from main class
     */
    public DictionaryWord(String line) {
        this.line = line;
    }
    
    /**
     * checks if line contains word from dictionary
     * @param words is the array of separate words from
     * original line
     * @param result contains message about compliance
     * @return message about compliance if it does
     */
    @Override
    public String checkRule() {
        String[] words = intoWordsArray(line);
        for(int i = 0; i<words.length; i++) {
            for(int j = 0; j<dictionary.length; j++) {
                if (words[i].equals(dictionary[j])) {
                    result = ("Complies rule 'Contains word from dictionary' \n");
                    break;
                }
            }
        }
        return result;
    }
}
