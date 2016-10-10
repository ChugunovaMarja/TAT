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
}
