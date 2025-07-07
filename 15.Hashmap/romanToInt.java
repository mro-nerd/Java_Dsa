/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. */

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // To store these values for convenience
        HashMap<Character, Integer> value = new HashMap<>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);

        int ans = 0;             // It will calculate the answer.
        int length = s.length(); // Size of the string

        for (int i = 0; i < length - 1; i++) {
            // If the current value is smaller than the next value, then subtract it
            if (value.get(s.charAt(i)) < value.get(s.charAt(i + 1))) {
                ans -= value.get(s.charAt(i));
            } else {
                ans += value.get(s.charAt(i));
            }
        }
        // Add the value of the last Roman numeral
        ans += value.get(s.charAt(length - 1));
        return ans;
    }
}

public class romanToInt {
    public static void main(String[] args) {
        // Instantiate the Solution class
        Solution solution = new Solution();

        // Define test cases
        String roman1 = "III";
        String roman2 = "IV";
        String roman3 = "IX";
        String roman4 = "LVIII";
        String roman5 = "MCMXCIV";

        // Call romanToInt method and print results
        System.out.println("Integer value of " + roman1 + ": " + solution.romanToInt(roman1)); // Output: 3
        System.out.println("Integer value of " + roman2 + ": " + solution.romanToInt(roman2)); // Output: 4
        System.out.println("Integer value of " + roman3 + ": " + solution.romanToInt(roman3)); // Output: 9
        System.out.println("Integer value of " + roman4 + ": " + solution.romanToInt(roman4)); // Output: 58
        System.out.println("Integer value of " + roman5 + ": " + solution.romanToInt(roman5)); // Output: 1994
    }
}


