public class fnOverloading {

   public static int sum(int a , int b){
     return a+b;
   }

   public static int sum(int a , int b,int c){
     return a+b+c;
   }
    public static void main(String[] args) {
        System.out.println(sum(1,2));
        System.out.println(sum(1,2,3));
    }
}

/*------------------------------------------------------------------------------------ */

//In fn overloading fn(s) can have same name but differ no. of arguments or diff types of argument