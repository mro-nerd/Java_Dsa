import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class triangle{
    public static void main(String args[]){
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(-1));
        arr.add(Arrays.asList(2,3));
        arr.add(Arrays.asList(1,-1,-3));
        //arr.add(Arrays.asList(4,1,8,3));
        int minDist=0;
        int res=solve(0,0,arr,minDist);
        System.out.println(res);
    }
    private static int solve(int j, int i, List<List<Integer>>triangle, int minDist){
        if(triangle.size()==0)return triangle.get(0).get(0);
        if(j==triangle.size()-1 && i<triangle.get(j).size()-1){
            minDist+=Math.min(triangle.get(j).get(i),triangle.get(j).get(i+1));
            return minDist;
        }
        if(j>=triangle.size())return minDist;
        int x =minDist+ triangle.get(j).get(i)+solve(j+1,i,triangle,minDist);
        System.out.println("x:"+triangle.get(j).get(i));
        int y=Integer.MAX_VALUE;
        if(i<triangle.get(j).size()-1){
         y =minDist+ triangle.get(j).get(i)+solve(j+1,i+1,triangle,minDist);
         System.out.println("y:"+triangle.get(j).get(i+1));
        }
        //
        minDist=Math.min(x,y);
        return minDist;
    }
}