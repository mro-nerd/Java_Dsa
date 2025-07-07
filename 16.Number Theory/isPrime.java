public class isPrime{
     public static boolean PrimeCheck(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i ++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 29;
        if (PrimeCheck(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}