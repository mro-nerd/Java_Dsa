import java.util.Scanner;

public class PrimeNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number");
        int n = sc.nextInt();
        if(n == 2){
        System.out.println(n+" is prime");
       }

        boolean isPrime= true;
        for(int i=2;i<=n-1;i++){
            if(n%i == 0){
                isPrime=false;
            }
        }
       
        if(isPrime){
            System.out.println(n+" is prime");
        }
        else{
            System.out.println(n+" is not prime");
        }
        sc.close();
    }
}

/*------------------------------------------------------------------------------------------------------------------------------------------------ */

//since n=root(n) x root(n)

// so its factors start repeating after reaching max value i.e root(n)

//so for optimising this code we can run the loop from 2 to root(n) i.e root(n)-2 times intstead of n-2 times