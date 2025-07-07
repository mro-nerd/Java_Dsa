/*You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxes(i) is the number of boxes of type i.
numberOfUnitsPerBox(i) is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck. */

import java.util.Arrays;

public class maxUnit {
    public static void main(String[] args) {
        int nums[][]={{1,3},{2,2},{3,1}};
        int t=4;
        System.out.println(maximumUnits(nums,t));
    }
    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int[] b : boxTypes) {
            int count = Math.min(b[0], truckSize);
            ans += count * b[1];
            truckSize -= count;
            if (truckSize == 0)
                return ans;
        }
        return ans;

    }
}
