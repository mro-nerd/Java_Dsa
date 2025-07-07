//here we are removing duplicate strings
public class dupicateString {
     public static void main(String[] args) {
        String str="aadityamishra";
        removeDuplicate(str,0,new StringBuilder(""),new boolean[26]);

     }
     public static void removeDuplicate(String str,int i,StringBuilder newStr,boolean map[]){
        if(i==str.length()){//base case
            System.out.println(newStr);
            return;
        }

        char currChar=str.charAt(i);
        if(map[currChar-'a']==true){
            //char already exist in newStr
            removeDuplicate(str, i+1, newStr, map);
        }else{
            map[currChar-'a']=true;
            removeDuplicate(str,i+1,newStr.append(currChar),map);//char doesn't exist so we add it in newStr
        }


     }
}
