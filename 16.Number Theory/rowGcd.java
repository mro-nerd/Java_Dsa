/*You are given two positive integer sequences a1,…,an and b1,…,bm. For each j=1,…,m find the greatest common divisor of a1+bj,…,an+bj.
 
Example:
Input:
4 4
1 25 121 169
1 2 7 23
Output:
2 3 8 24
*/

import java.util.Arrays;
import java.util.Scanner;
public class rowGcd{
   static Scanner sc = new Scanner(System.in);
   public static void main(String...c){
    int n=sc.nextInt();
    int m=sc.nextInt();
    long a[]=new long[n],b[]=new long[m],ans[]=new long[m];
    int i;
    for(i=0;i<n;i++) a[i]=sc.nextLong();
    for(i=0;i<m;i++) b[i]=sc.nextLong();
    Arrays.sort(a);
    long gd=0;
    for(i=1;i<n;i++) gd=gcd(gd,a[i]-a[i-1]);
    for(i=0;i<m;i++) ans[i]=gcd(gd,a[0]+b[i]);
    
    for(i=0;i<m;i++) System.out.print(ans[i]+" ");
  }
  public static long gcd(long a,long b){
     if(a==0) return b;
     return gcd(b%a,a); 
  }
}
