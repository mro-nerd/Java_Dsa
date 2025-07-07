public class subArray {
    public static void sub(int numbers[]){
        int ts=0;
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j ;
                for (int k = start; k <=end; k++) {
                    System.out.print(numbers[k]+" ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total sub array: "+ts);
        
     
    }
    
    public static void main(String[] args) {
        int numbers[]={1,2,3,4,5,6,7};
        sub(numbers);
        
    }
}
