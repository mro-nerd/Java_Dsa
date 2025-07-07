// # Rotate a array by k on the right side.


public class rotateArray {
    public static void main(String[] args) {
        int a[]={2,4,6,7,11,19,21};
        int k = 3;
        rotate(a,k);
        for(int nums : a){
            System.out.println(nums);
        }
    }
    public static void rotate(int[] a, int k){
          reverse(a, 0, a.length-1);
          reverse(a, 0, k-1);
          reverse(a, k, a.length-1);
    }
    public static void reverse(int[] a, int i , int j){
       while(i<j){
        int temp = a[i]; 
        a[i] = a[j];
        a[j] = temp;
        i++; 
        j--;
       }
    }
}
