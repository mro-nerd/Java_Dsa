/*Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.

For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.

For example, "m.y+name@email.com" will be forwarded to "my@email.com".
It is possible to use both of these rules at the same time.

Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.

Example 1:

Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails. */

import java.util.*;

// Solution class implementing the numUniqueEmails method
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> mp = new HashMap<>();
        for (String email : emails) {
            StringBuilder real_email = new StringBuilder();
            boolean ignore = false;
            for (char c : email.toCharArray()) {
                if (c == '+' || c == '@') {
                    ignore = c == '+';
                    continue;
                }
                if (!ignore && c != '.') {
                    real_email.append(c);
                }
            }
            real_email.append(email.substring(email.indexOf('@')));
            mp.put(real_email.toString(), mp.getOrDefault(real_email.toString(), 0) + 1);
        }
        return mp.size();
    }
}

// Main class to test the numUniqueEmails method
public class uniqueEmail {
    public static void main(String[] args) {
        // Instantiate the Solution class
        Solution solution = new Solution();

        // Define test cases
        String[] emails1 = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        };
        String[] emails2 = {
            "a@leetcode.com",
            "a+b@leetcode.com",
            "c@leetcode.com"
        };
        String[] emails3 = {
            "test.email+alex@leetcode.com",
            "test.email@leetcode.com"
        };

        // Call numUniqueEmails method and print results for each test case
        System.out.println("Number of unique emails in emails1: " + solution.numUniqueEmails(emails1)); // Output: 2
        System.out.println("Number of unique emails in emails2: " + solution.numUniqueEmails(emails2)); // Output: 3
        System.out.println("Number of unique emails in emails3: " + solution.numUniqueEmails(emails3)); // Output: 1
    }
}


