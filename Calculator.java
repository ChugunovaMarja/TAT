/** 
 * main class for calculating sum, 
 * difference, cup product and 
 * quotient of two numbers
 */
public class Calculator {
/**
 * displays sum, difference, cup product and quotient of two numbers
 */
public static void main(String[] args) { 

double a = Double.parseDouble(args[0]);
double b = Double.parseDouble(args[1]);

if (Double.isInfinite(a/b)) {
    System.out.println("Division by zero");
    System.exit(0);
    }
if (Double.isNaN(a/b)){
    System.out.println("Division zero by zero");
    System.exit(0);
    }

System.out.println("Sum = " + sum(a,b));
System.out.println("Difference = " + dif(a,b));
System.out.println("Cup Product = " + cupProduct(a,b)); 
System.out.println("Quotient = " + quotient(a,b));

}
/**
 * calculates sum of two numbers
 */
public static double sum(double a, double b) {
    return (a+b);
}
/**
 * calculates difference of two numbers
 */
public static double dif(double a, double b) { 
    return (a-b);
}
/**
 * calculates cup product of two numbers
 */
public static double cupProduct(double a, double b) { 
    return (a*b);
} 
/**
 * calculates quotient of two numbers
 */
public static double quotient(double a, double b) { 
    return (a/b);
}
}
