/*You are given an unsorted array with unique elements.Apply Bs on it ,also this is modified Bs algorithm here mid is not equal to (start +end)/2 here each time mid is any random index number .Due to this modification in algo sometimes Bs works sometime it does'nt also it is applied on unsorted array so that also halt its working .

Return the number of element that will be found even after this modification in algo in this unsorted array.
*/

import java.util.Scanner;

public class randomBinarySearch {
    public static int randomBinarySearchable(int arr[], int n) {
        int preMax[] = new int[n];
        int sufMin[] = new int[n];

        for(int i = 0; i < n; ++i)
            preMax[i] = i == 0? arr[i] : Math.max(arr[i], preMax[i-1]);

        for(int i = n - 1; i >= 0; --i)
            sufMin[i] = i == n - 1? arr[i] : Math.min(arr[i], sufMin[i+1]);

        int cnt = 0;

        for(int i = 0; i < n; ++i) {
            int leftMax = (i == 0)? Integer.MIN_VALUE : preMax[i - 1];
            int rightMin = (i == n-1)? Integer.MAX_VALUE : sufMin[i + 1];

            if(arr[i] > leftMax && arr[i] < rightMin)
                cnt++;
                
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();

        System.out.println(randomBinarySearchable(arr, n));
        sc.close();
    }
}
