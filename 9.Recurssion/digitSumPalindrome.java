/*Given a number n.Find if the digit sum(or sum of digits) of n is a Palindrome number or not.
Example- if n=679 then sum of digit is 6+7+9=22 which is palindrome.*/

public class digitSumPalindrome{
   public static  int reverseNum;
    public static void main(String[] args) {
        int n=1028;
        System.out.println(isDigitSumPalindrome(n));
    }
    public static int isDigitSumPalindrome(int n) {
        int sum = sumOfDigit(n); // Calculate the sum of digits of n
        reverseNum = 0; // Reset the reverseNum before use
        reverseNumber(sum); // Reverse the sum of digits
        if (sum == reverseNum) { // Check if the sum is a palindrome
            return 1;
        } else {
            return 0;
        }
    }

   public static int sumOfDigit(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigit(n / 10); // Recursive sum of digits
    }

    public static void reverseNumber(int n) {
        if (n == 0) {
            return;
        }
        int lastDigit = n % 10;
        reverseNum = (reverseNum * 10) + lastDigit; // Construct the reverse number
        reverseNumber(n / 10);
    }
}