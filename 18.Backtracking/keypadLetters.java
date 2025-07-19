/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"] */

import java.util.*;

public class keypadLetters {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        Map<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");

        backtrack(0, digits, "", digitToChar, res);
        return res;
    }

    private void backtrack(int index, String digits, String curStr,
                           Map<Character, String> digitToChar, List<String> res) {
        if (index == digits.length()) {
            res.add(curStr);
            return;
        }

        String chars = digitToChar.get(digits.charAt(index));
        for (char c : chars.toCharArray()) {
            backtrack(index + 1, digits, curStr + c, digitToChar, res);
        }
    }

    public static void main(String[] args) {
        keypadLetters obj = new keypadLetters();
        String inputDigits = "367";

        List<String> combinations = obj.letterCombinations(inputDigits);

        System.out.println("Letter combinations for digits \"" + inputDigits + "\":");
        for (String s : combinations) {
            System.out.println(s);
        }
    }
}

