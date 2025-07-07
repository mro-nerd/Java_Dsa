//here we are finding the last ouccurrence of any given key in array
public class lastOccurrence {
    public static void main(String[] args) {
        int a[]={1,3,2,4,1,5,1,7,8};
        System.out.println( lastOccurredIndex(a,1,0));
    }
    public static int lastOccurredIndex(int a[], int key,int i){
        if(i==a.length-1){//base case
            return -1;//if key is not in array
        }
        int isFound= lastOccurredIndex(a,key,i+1);
        if(isFound==-1 && a[i]==key){
            return i;//if key has only one occurrence
        }
        return isFound;
    }
}
