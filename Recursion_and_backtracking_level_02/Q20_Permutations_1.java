package Recursion_and_backtracking_level_02;
import java.io.*;

public class Q20_Permutations_1 {

    // ci -> current item
    // ti -> total item

    public static void permutations(int[] boxes, int ci, int ti){
    
        if(ci > ti){ // base case when current item exceeded
          for (int item : boxes) { 
            System.out.print(item);
          }
          System.out.println();
          return ;
        }
    
        for(int i = 0 ; i < boxes.length ; i++){
          if(boxes[i] == 0){ // if box is empty then store item and move forward
          boxes[i] = ci ; // storing current item
          permutations(boxes,ci+1,ti) ; // moving forward
          boxes[i] = 0 ; // backtracking
          }
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
        br.close();
      }
    
}
