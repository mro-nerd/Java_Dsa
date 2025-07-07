public class upperToLower {
    public static void main(String[] args) {
        for(char ch='A';ch<='Z';ch++){
            System.out.print((char)(ch | ' '));//as diff btw ascii code of any uppercase and lower case char in of 32 ,also 32 represents ' '(space) in ascii code
        }
    }
}
