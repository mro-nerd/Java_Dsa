/*You have K magical pens, each numbered from 1 to K. Each pen can write only certain letters — given as strings P₁, P₂, ..., Pₖ. You want to write a word S of length N using these pens.

You can:
Start writing with any pen.
Switch pens any number of times.
Use each pen multiple times or not at all.

Your goal is to write the word S with the fewest possible pen switches. For each character in S, output the pen number used to write it.

Input Format:
T               // Number of test cases
For each test case:
  N K           // Length of word S and number of pens
  S             // The word to write
  P₁            // Letters pen 1 can write
  P₂            // Letters pen 2 can write
  ...
  Pₖ            // Letters pen K can write
Output Format:
For each test case, print N space-separated integers — the pen number used for each character in S.

Constraints:
1 ≤ T ≤ 10

1 ≤ N ≤ 10⁶

1 ≤ K ≤ 10⁵

Each Pᵢ contains 1 to 20 distinct letters from 'a' to 't'

Total input size ≤ 2 × 10⁶ characters

It is guaranteed that S can be written using the pens

Sample Input:
1
4 2
abcd
ab
cd

Sample Output:
1 1 2 2
*/

import java.io.*;

public class pen {
    static int stringToMask(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); ++i) {
            int bit = s.charAt(i) - 'a';
            ans += (1<<bit);
        }
        return ans;
    }
    static int mask(char ch) {
        int bit = ch - 'a';
        return 1 << bit;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());

        while(t-- > 0) {
            String line[] = r.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            String s = r.readLine();
            
            int pen[] = new int[1<<20];
            for(int i = 0; i < k; ++i) {
                String Pi = r.readLine();
                int m = stringToMask(Pi);
                pen[m] = i + 1;
            }

            /*
                Do some processing on the pen array.
                So, that it also starts considering
                all the subsets of the Pi strings.
            */
            for(int m = (1<<20) - 1; m >= 1; --m) {
                for(int i = 0; i < 20; ++i) {
                    if(pen[m] > 0)
                        break;
                    if(((m>>i)&1) > 0)
                        continue;
                    pen[m] = pen[m | (1<<i)];
                }
            }
            /*
                pen[m] = 0 : if it's impossible to write that set of characters with a single pen
                pen[m] = i : ith pen can be used to write this particular set of character.
            */

            int i = 0;
            while(i < n) {
                int curSet = mask(s.charAt(i)), j = i + 1; // next probable character
                while(j < n && pen[curSet | mask(s.charAt(j))] > 0) {
                    curSet |= mask(s.charAt(j));
                    j++;
                }

                for(int id = i; id < j; ++id)
                    w.print(pen[curSet] + " ");

                i = j;
            }

            w.print("\n");
        }
        r.close();
        w.close();
    }
}