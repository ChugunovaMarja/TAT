import java.util.Scanner;

/** 
 * main class  
 * showing type of
 * triangle
 */

public class Triangle {
/**
 * main method 
 * gets data and calls 
 * functions checking data 
 * and showing type of triangle
 */
public static void main(String[] args) { 

double a;
double b;
double c;

Scanner sc = new Scanner(System.in);		
System.out.println("Enter sides \n");
a = sc.nextDouble();
b = sc.nextDouble();
c = sc.nextDouble();

checkValid(a);
checkValid(b);
checkValid(c);

if(checkExistence(a,b,c)==true) {
    getType(a,b,c);
}
}

/**
 * checking sides for zeros
 */
public static void checkValid(double k) {
if (Double.isInfinite(1/k)) {
    System.out.println("No zeros");
    System.exit(0);
    }
}

/**
 * checking if triangle exists
 */
public static boolean checkExistence (double a, double b, double c) { 
   boolean i = false;
   if ((a+b>c) && (a+c>b) && (b+c>a)) {
   i = true;
   } else {
         System.out.println("Triangle doesn't exist");
         System.exit(0);
    }
return i;
}
/**
 * determines type of triangle
 */
public static void getType(double a, double b, double c) { 
   if ((a==b) && (b==c) && (a==c)) {
   System.out.println("Ravnostoronnij");
   } else {
       if (((a==b) && (a!=c)) || ((a==c) && (a!=b)) || ((b==c) && (b!=a))) {
         System.out.println("Ravnobokij");
        } else {
            System.out.println("Obychnyj");
        }
    }
}

}