public class diagonalSum {
    public static int diagonalAdd(int a[][]){
        int sum=0;
        //brute force approach:-

        // for (int i = 0; i < a.length; i++) {
        //     for (int j = 0; j < a[0].length; j++) {
        //         if (i==j) {
        //             sum+= a[i][j];
        //         }
        //         else if(i+j==a.length-1) {
        //             sum+= a[i][j];
        //         }
        //     }
        // }

        //optimised approach:-

        for (int i = 0; i < a.length; i++) {
            sum+= a[i][i];

            if(i != a.length-1-i) //if nxn is odd then 2 diagonals would have one common element ,so this condition make sure that no such common element is taken twice 
            {
              sum+= a[i][a.length-1-i];//since i+j=a.length-1 is condition for second diagonal
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}};

       System.out.println(diagonalAdd(matrix)) ;
    }
}
