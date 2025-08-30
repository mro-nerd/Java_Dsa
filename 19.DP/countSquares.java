/*Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15. */

public class countSquares {
    static int count(int[][]mat){
        int ans=0;
        int dp[][]=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)dp[i][0]=mat[i][0];
        for(int j=0;j<mat[0].length;j++)dp[0][j]=mat[0][j];

        for(int i=1;i<mat.length;i++){
            for(int j=1;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                ans+=dp[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int mat[][] = {{1,0, 1,},{1, 1,0},{1,1,0}};
        int ans=count(mat);
        System.out.println(ans);
    }
}