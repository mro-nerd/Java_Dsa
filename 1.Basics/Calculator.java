import java.util.Scanner;

public class Calculator {
 public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
      System.out.println("Enter 1st no."); 
    int a = sc.nextInt();
     System.out.println("Enter 2nd no."); 
    int b= sc.nextInt();
     System.out.println("Enter operator"); 
    char operator = sc.next().charAt(0);//since next() takes string and we want to give only one char

    switch (operator) {
        case '+':
           System.out.println(a+b); 
            break;

         case '-':
           System.out.println(a-b); 
            break;   
            
         case '*':
           System.out.println(a*b); 
            break;    

         case '/':
           System.out.println(a/b); 
            break;    
    
        default:
        System.out.println("wrong operator"); 
            break;

    }
sc.close();
 }
}
