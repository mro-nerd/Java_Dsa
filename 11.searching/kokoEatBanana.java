/*Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours. */

public class kokoEatBanana {
    
    public static void main(String[] args) {
        int piles[]={30,11,23,4,20};
        int h=6;
        System.out.println(minEatingSpeed(piles, h));
    }
    public static long hoursRequired(int[] arr, int k) {
        // 'long' is important, because otherwise
        // 'hoursReq' can overflow
        long hoursReq = 0;
        for(int num : arr) {
            hoursReq += Math.ceil(num/(double)k);
        }
        return hoursReq;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = (int)1e9, ans = -1;
        while(l <= r) {
            int mid = (l + r)/2;
            if(hoursRequired(piles, mid) <= h) {
                ans = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
