/*There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
Given the array points, return the minimum number of arrows that must be shot to burst all balloons. */

import java.util.Arrays;

public class arrowShorts {
    public static void main(String[] args) {
        int points[][]={{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }
        public static int findMinArrowShots(int[][] points) {
         Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
         int result=1;
         int previous = 0;
         for(int current=1;current<points.length;current++){
            if(points[current][0]>points[previous][1]){
                result++;
                previous=current;
            }

         }
        return result; 
    }
}
