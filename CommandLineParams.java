/**
* main class for displaying lines 
* in reverse order
*/
public class CommandLineParams {
/**
* displays lines in reverse order
*/
public static void main(String[] args) { 

for(int i = args.length-1; i >= 0 ; i--) {
        
            System.out.println("Argument " + i + " = " 

+ args[i]);
        }

}
}

