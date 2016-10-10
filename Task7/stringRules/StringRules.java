package stringRules;

import java.util.Scanner;

/**
 * Main class, contains point of entrance
 * @author Maria
 */
public class StringRules {

    /**
     * point of entrance,
     * asks for string line and creates 
     * instances of the rule classes
     * 
     * @param line is a string that will be checked
     * for compliance to rules;
     * @param args is ignored;
     */
    public static void main(String[] args) {
        
        try {
          Scanner sc = new Scanner(System.in);
          System.out.println("Print line");
          String line = sc.nextLine();
        
          NoNum noNum = new NoNum(line);
          printResults(noNum);
          OnlyNum onlyNum = new OnlyNum(line);
          printResults(onlyNum);
          MoreThanFiveWords moreThanFiveWords = new MoreThanFiveWords(line);
          printResults(moreThanFiveWords);
          DictionaryWord dictionaryWord = new DictionaryWord(line);
          printResults(dictionaryWord);
        } catch (Exception e) {
            System.out.println("Something went wrong, restart the program");
        }
    }
    
    /**
     * prints the results of overloaded method checkRule, 
     * that checks if line complies to rule
     * @param rule is an instance of specific rule
     */
    public static void printResults(Rule rule) {
      System.out.print(rule.checkRule());    
    }
}
