public class reverseArray {
    public static int reverse(int numbers[]){
        int start =0;
        int end = numbers.length-1;

        while (start<end) {
            int temp = numbers[end];
            numbers[end]=numbers[start]; 
            numbers[start]=temp;
            start++;
            end--;
        }
        for (int i = 0; i <numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        return -1;
    }
    public static void main(String[] args) {
        int numbers[] = {0,1,2,3,4,5,6};
        reverse(numbers);
    }
}
//although we could have made another array in which we could have extracted value from original array in reverse order and then put elements of this array in the original array but via this our space complexity would have worsened . so we use this more optimise method