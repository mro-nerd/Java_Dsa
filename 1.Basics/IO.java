import java.util.*;

public class IO {
    public static void main(String[] args) {
        // creating object named sc of Scanner class 
        Scanner sc =new Scanner(System.in);
    //    sc is getting input via next 
    // next() can only fetch input without spaces like in Adi Mishra it will only
    //  take Adi 
       
    
    // String input = sc.next();
    //     System.out.println(input);

 //this fn is used to get input with spaces btw them
    // String name = sc.nextLine();
    // System.out.println(name);



    //fn for getting int
    int number = sc.nextInt();
    System.out.println(number);

    // for byte,float,double boolean,short and long fn is nextByte,nextFloat,nextDouble,nextLong respectively

    sc.close();//remember to close this obj
        
    }
}
