public class searchSorted {
    public static boolean search(int a[][],int key){
        int row=0;
        int col=a[0].length-1;
//staircase approach  
        while (row<a.length && col>=0) {
            if (a[row][col] == key) {
           System.out.println("At ("+row+","+col+")");
            return true;
            }
            else if(key < a[row][col]){
            col--;
            }
            else{
                row++;
            }
            
        }
      System.out.println("Key not found");
      return false;
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}};
        int key =111;

        search(matrix, key);
    }
}
