public class sumTarget {
    public static void main(String[] args) {
        int a[]={3,5,7,0,6,2,8,1};
        int x=4;
        System.out.println(isAvailable(a, x));
    }
    public static boolean isAvailable(int[]a , int x){
        int memory[]=new int[1000000];
        for(int i =0;i<a.length;i++){
            int curr = a[i];
            int req_num = x-curr;
            if (req_num<a.length && req_num>0 && memory[req_num]==1) {
                return true;
            }
            memory[curr]=1;
        }
        return false;
    }
}
