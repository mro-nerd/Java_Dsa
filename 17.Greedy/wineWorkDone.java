/*Gergovia consists of one street, and every inhabitant of the city is a wine salesman. Everyone buys wine from other inhabitants of the city. Every day each inhabitant decides how much wine he wants to buy or sell. Interestingly, demand and supply is always the same, so that each inhabitant gets what he wants.

There is one problem, however: Transporting wine from one house to another results in work. Since all wines are equally good, the inhabitants of Gergovia don't care which persons they are doing trade with, they are only interested in selling or buying a specific amount of wine.

In this problem you are asked to reconstruct the trading during one day in Gergovia. For simplicity we will assume that the houses are built along a straight line with equal distance between adjacent houses. Transporting one bottle of wine from one house to an adjacent house results in one unit of work.

Example:

Input:
5
5 -4 1 -3 1

Output:
9

SOL:

💡 Key Insight
Instead of matching buyers and sellers, track the net wine balance as you walk through the street from left to right.

⚙️ Core Logic
Loop from house 1 to n - 1.

At each step:

Sum = Bottles[i - 1] → wine moved so far

Bottles[i] += Bottles[i - 1] → update running wine balance

Result += abs(Sum) → accumulate the work done

🧠 Why It Works
Bottles[i] carries the running total of wine balance.

At each step, the abs(Sum) is the amount of wine moved to get to the current house.

Summing all those gives the minimum total work.

📈 Time Complexity
O(n) — single pass through the list.*/

import java.io.IOException;
import java.util.Scanner;

public class wineWorkDone {
    public static long NumberOfPersons;
    public static long[] Bottles;
    public static long Sum;

    public static void main(String args[]) throws NumberFormatException, IOException {
        Scanner Input = new Scanner(System.in);

        while (Input.hasNext()) {
            NumberOfPersons = Input.nextLong();
            if (NumberOfPersons == 0) break;

            Bottles = new long[(int) NumberOfPersons];

            // Reading the input values
            for (int i = 0; i < NumberOfPersons; i++) {
                Bottles[i] = Input.nextLong();
            }

            long Result = 0;
            for (int i = 1; i < NumberOfPersons; i++) {
                Sum = Bottles[i - 1];
                Bottles[i] += Bottles[i - 1];

                Result += Math.abs(Sum);
            }

            System.out.println("Total Work: " + Result);
        }

        Input.close();
    }
}


