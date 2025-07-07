public class maxSumOfSubArray {
    public static void sumSub(int numbers[]){
      int tp=0;
        int maxSum=Integer.MIN_VALUE;
        
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j ;
                int currSum=0;
                tp++;
                for (int k = start; k <=end; k++) {
                    
                    System.out.print(numbers[k]+" ");

                    currSum += numbers[k];
                
                }
                if (currSum > maxSum) {
                       maxSum = currSum;                        
                    }
            
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Max-sum in  sub array: "+maxSum);
        System.out.println("Total no. of  sub array: "+tp);
        
     
    }
    
    public static void main(String[] args) {
        int numbers[]={1,2,3,4,5,6,7};
        sumSub(numbers);
        
    }
}
