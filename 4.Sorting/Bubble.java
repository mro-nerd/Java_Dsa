public class Bubble {

    public static void main(String[] args) {
        int nums[]={5,4,1,3,2};
        bubbleSort(nums, 5);
    }
    public static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) { // outer loop should start from 0
            for (int j = 0; j < n - i - 1; j++) { // inner loop should start from 0 and go up to n - i - 1
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int num:arr){
            System.out.println(num);
        }
    }
    
}