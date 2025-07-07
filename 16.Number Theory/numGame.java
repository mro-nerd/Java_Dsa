/*Two soldiers are playing a game. At the beginning first of them chooses a positive integer n and gives it to the second soldier. Then the second one tries to make maximum possible number of rounds. Each round consists of choosing a positive integer x > 1, such that n is divisible by x and replacing n with n / x. When n becomes equal to 1 and there is no more possible valid moves the game is over and the score of the second soldier is equal to the number of rounds he performed.

To make the game more interesting, first soldier chooses n of form a! / b! for some positive integer a and b (a ≥ b).
What is the maximum possible score of the second soldier?

Input
First line of input consists of single integer t (1 ≤ t ≤ 1 000 000) denoting number of games soldiers play.
Then follow t lines, each contains pair of integers a and b (1 ≤ b ≤ a ≤ 5 000 000) defining the value of n for a game.

Output
For each game output a maximum score that the second soldier can get.

Examples
Input
2
3 1
6 3
Output
2
5
 */

import java.io.*;

public class numGame {

    final static int LIMIT = 5000000;
    static int[] primeSieve() {
        int n = LIMIT;
        int spf[] = new int[n+1]; // each value is 0 initially

        for(int i = 2; i <= n; ++i) {
            if(spf[i] > 0)
                continue;

            spf[i] = i;
            if((long)i*i > (long)n)
                continue;

            for(int j = i*i; j <= n; j += i) // multiples of i
                if(spf[j] == 0)
                    spf[j] = i;
        }

        return spf;
    }
    static int getPrimeCnt(int num, int spf[]) {
        int ans = 0;
        while(num > 1) {
            int pf = spf[num], cnt = 0;
            while(num%pf == 0) {
                num /= pf;
                cnt += 1;
            }
            ans += cnt;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());

        int spf[] = primeSieve();
        int pref[] = new int[LIMIT+1];

        for(int i = 1; i <= LIMIT; ++i) {
            int ansOfI = getPrimeCnt(i, spf);
            pref[i] = pref[i-1] + ansOfI;
        }

        while(t-- > 0) {
            String line[] = r.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            w.print(pref[a] - pref[b]);
            w.print('\n');
        }

        r.close();
        w.close();
    }
}

