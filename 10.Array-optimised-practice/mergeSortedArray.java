/* merge two sorted arrays into one sorted array*/

import java.util.ArrayList;
//we can do this like we did in merge sorting where we merged subarrays into sorted array
public class mergeSortedArray {
    public static void main(String[] args) {
        int a1[]= {1,2,3,4,5,0,0,0,0};
        int a2[]={4,6,8,9};
        int n= 4;
        int m= 5;
        merge(a1,a2 , n, m);
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);    
        }
       
    }
    public static void merge(int a1[], int a2[], int n, int m){
        int i =0, j=0;
        ArrayList <Integer> aux = new ArrayList<Integer>();
        while (i<m && j<n) {
            if(a1[i]<a2[j]){
                aux.add(a1[i]);
                i++;
            }
            else{
                aux.add(a2[j]);
                j++;
            }
        }
        while (i<m) { //remaining elements of a1
            aux.add(a1[i]);
            i++;
        }
        while (j<n) {//remaining elements of a2
            aux.add(a2[j]);
            j++;
        }
        for(int x=0; x<n+m;x++){
            a1[x]=aux.get(x);
        }
    }
}
