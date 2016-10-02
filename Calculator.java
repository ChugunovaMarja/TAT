/** main class for calculating sum, 
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

if (b != 0) {
    System.out.println("Sum = " + sum(a,b));
    System.out.println("Difference = " + dif(a,b));
    System.out.println("Cup Product = " + cupProduct(a,b)); 
    System.out.println("Quotient = " + quotient(a,b));
} else
    System.out.println("Cannot divide by zero");
}

public static double sum(double a, double b) { //calculates sum of two numbers
    return (a+b);
}
public static double dif(double a, double b) { //calculates difference of two numbers
    return (a-b);
}
public static double cupProduct(double a, double b) { //calculates cup product of two numbers
    return (a*b);
} 
public static double quotient(double a, double b) { //calculates quotient of two numbers
    return (a/b);
}
}
