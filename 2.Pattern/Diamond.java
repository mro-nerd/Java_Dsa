import java.util.Scanner;

public class Diamond {
     public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter no. of rows");
        int n= sc.nextInt();
        
        for (int i =1 ; i <=n; i++) {
            //for spaces
            for(int j =1; j<=n-i;j++){
               
                System.out.print(" ");
               

            }
            //for stars
            for(int l =1 ; l<=(2*i)-1; l++){
                 System.out.print("*");
            }
            
            System.out.println();
        }
        //lower inverted part
        for (int i =n ; i >=1; i--) {
            //for spaces
            for(int j =1; j<=n-i;j++){
               
                System.out.print(" ");
               

            }
            //for stars
            for(int l =1 ; l<=(2*i)-1; l++){
                 System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
