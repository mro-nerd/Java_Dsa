/*In a garden represented as an infinite 2D grid, there is an apple tree planted at every integer coordinate. The apple tree planted at an integer coordinate (i, j) has |i| + |j| apples growing on it.

You will buy an axis-aligned square plot of land that is centered at (0, 0).

Given an integer neededApples, return the minimum perimeter of a plot such that at least neededApples apples are inside or on the perimeter of that plot. */

public class appleGarden {
    public static void main(String[] args) {
        int neededApples=15;
        System.out.println(minimumPerimeter(neededApples));
    }
    public static  long minimumPerimeter(long neededApples) {
        int beg = 1, end = (int)1e5;
        long minL = -1;

        while(beg <= end) {
            long L = (beg + end)/2;
            long curApples = 2*L*(L+1)*(2*L+1);

            if(curApples >= neededApples) {
                minL = L;
                end = (int)L - 1;
            }
            else
                beg =(int) L + 1;
        }

        return 8*minL;
    }
}
