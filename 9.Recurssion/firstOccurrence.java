public class firstOccurrence {
    //here we are finding the first ouccurrence of any given key in array

    public static void main(String[] args) {
        int a[]={1,3,2,4,1,5,1,7,8};
        System.out.println( firsttOccurredIndex(a,1,0));
    }
    public static int firsttOccurredIndex(int a[], int key,int i){
        if(i==a.length-1){//base case
            return -1;//if key is not in array
        }
       
        if(a[i]==key){
            return i;
        }
        return firsttOccurredIndex(a, key, i+1);
    }


}
