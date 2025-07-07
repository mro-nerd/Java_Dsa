/*Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.

Example 1:

Input: nums = [21,4,7]
Output: 32
Explanation: 
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only. */

public class fourDivisor {

    public static int sumFourDivisors(int[] nums) {
        // find max element
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }

        int[] countDivisors = new int[mx + 1]; // for storing divisor count
        int[] sumDivisors = new int[mx + 1];   // for storing sum of divisors

        for (int i = 1; i <= mx; i++) {
            for (int j = i; j <= mx; j += i) {
                countDivisors[j]++;
                sumDivisors[j] += i;
            }
        }

        int sum = 0;
        for (int num : nums) {
            if (countDivisors[num] == 4) {
                sum += sumDivisors[num];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        
        int[] nums = {21, 4, 7};
        int result = sumFourDivisors(nums);
        System.out.println("Sum of elements with exactly four divisors: " + result);
    }
}


