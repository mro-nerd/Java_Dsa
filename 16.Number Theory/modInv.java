/*Find Modulo Inverse of given number */

import java.util.*;

class Pair<T, U> {

    private final T key;
    private final U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }
}

public class modInv {

    final int mod = 1000000007;

    Pair<Integer, Integer> extendedEuclid(int a, int b) {
        if (b == 0) {
            return new Pair<>(1, 0);
        }
        Pair<Integer, Integer> partialSol = extendedEuclid(b, a % b);
        int xPartial = partialSol.getKey(), yPartial = partialSol.getValue();
        return new Pair<>(yPartial, xPartial - (a / b) * yPartial);
    }

    public int modInverse(int a) {
        int x = extendedEuclid(a, mod).getKey();
        x = (x % mod + mod) % mod;
        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to find modular inverse: ");
        int a = scanner.nextInt();

        modInv obj = new modInv();
        int inverse = obj.modInverse(a);
        System.out.println("Modular inverse of " + a + " under mod " + obj.mod + " is: " + inverse);

        scanner.close();
    }
}
