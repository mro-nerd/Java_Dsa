public class largestInArray {

    public static int largest(int numbers[]){
        int largest = Integer.MIN_VALUE;//it means -infinity
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]>largest) {
                largest=numbers[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int numbers[] = {1,5,6,45,3,14,0};
        System.out.println(largest(numbers));
    }
}