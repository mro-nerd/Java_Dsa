import java.util.*;
public class matrixFormatter{

  public static void main(String[] args){
  
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    int r=sc.nextInt();
    int c=sc.nextInt();
    sc.nextLine();
    
    int[][][]matrices=new int[N][r][c];
    for(int i=0;i<r;i++){
    
      String[] rowValues = sc.nextLine().split(" ");
      int index=0;
      for(int j=0;j<N;j++){
      
        for(int k=0;k<c;k++){
        
          matrices[j][i][k]=Integer.parseInt(rowValues[index++]);
        }
      }
    }
    
    List<List<Integer>>instructions=new ArrayList<>();
    while(sc.hasNextLine()){
    
      String line=sc.nextLine();
      if(line.isEmpty())break;
      List<Integer> instruction=new ArrayList<>();
      for(String num: line.split(" ")){
      
        instruction.add(Integer.parseInt(num));
      }
      instructions.add(instruction);
    }
    for(List<Integer>instruction:instructions){
    
      for(int matrixNum:instruction){
      
        int[][] matrix = matrices[matrixNum-1];
        for(int i=0;i<r;i++){
        
          for(int j=0;j<c;j++){
          
            System.out.print(matrix[i][j]+" ");
          }
        }
      }
      System.out.println();
      sc.close();
    }
  }
}