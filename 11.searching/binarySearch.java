public class binarySearch {
    public static int search(int numbers[],int key){
        int start =0;
        int end = numbers.length-1;

        while (start <= end) {
            int mid=(start+end)/2;
            if(numbers[mid] == key){
                return mid;
            }
            if (numbers[mid] <key) {
                start=mid+1;
                
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int numbers[] = {1,3,5,6,7,11,23,33};
        int key = 43;
        System.out.println(search(numbers , key));
    }
}


//binary search has less time complexity than linear search

/*cause ,
first iteration - happens in n times
2nd iterartion - ,,       ,,  n/2 ,, 
3rd ,,         - ,,       ,,  n/8  ,,
similarly kth iteration in - n/2^k =1 ,in worst of worst case 


so, n/2^k = 1
=>  n=2^k
=>  k=log(n) {with base 2}


so it has time complexity of O(log n) which is better than O(n) of linear search.
 */