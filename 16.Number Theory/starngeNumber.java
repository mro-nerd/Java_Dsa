/*The guard gave Varsha two integers X and K. Varsha needs to determine whether there is an integer A such that it has exactly X positive integer divisors and exactly K of them are prime numbers.
Example:
Input:1
      4 2
Output:1

Explaination: If A=6 then X=4(1,2,3,6) and K=2(2,3)
*/

import java.util.*;

public class starngeNumber {
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int X = sc.nextInt();
			int K = sc.nextInt();
			
			// prime factors of X
			int sumPrimePowers = 0;
			for(int i = 2; i*i <= X; ++i) {
				while(X%i == 0) {
					sumPrimePowers += 1;
					X /= i;
				}
			}
			if(X > 1)
				sumPrimePowers += 1;
            System.out.println(sumPrimePowers);

			if(sumPrimePowers >= K)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}

