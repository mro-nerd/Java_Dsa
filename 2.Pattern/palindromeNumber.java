import java.util.Scanner;

public class palindromeNumber {
     public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter no. of rows");
        int n= sc.nextInt();
        
        for (int i =1 ; i <=n; i++) {
            //for spaces
            for(int j =1; j<=n-i;j++){
               
                System.out.print(" ");
               

            }
            //for desc no. series
            for(int l =i ; l>=1; l--){
                 System.out.print(l);
            }
            //for asc no. series
            for(int k =2 ; k<=i; k++){
                 System.out.print(k);
            }
            
            System.out.println();
        }
        
  System.out.println();
        
        sc.close();
    }
}
