package Arrays_and_string;
import java.util.*;

public class Q1_Range_Addition {
    

    public static int[] Range(int length, int[][] updates) {
       
        int[] arr = new int[length] ; 
 
        for(int i = 0 ; i < updates.length ; i++){
 
            int start_idx = updates[i][0] ;
            int end_idx = updates[i][1] ;
            int value = updates[i][2] ;
            arr[start_idx] += value ;  // adding value at starting index.

            if(end_idx + 1 < length){ // and checking if end index + 1 less than length then only assign - value.
                 // this -value helps us to reduce the current value with value.

                arr[end_idx+1] += -value ;
            }
 
        }
 
        for(int i = 1 ; i < arr.length ; i++){
            arr[i] += arr[i-1] ;
        }
 
        return arr ;
        
          
      }
  
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
  
          // Input for length of first array.
          int length = sc.nextInt();
  
          int K = sc.nextInt();
  
          int[][] updates = new int[K][3];
  
          for (int i = 0; i < updates.length; i++) {
              for (int j = 0; j < updates[0].length; j++) {
                  updates[i][j] = sc.nextInt();
              }
          }
  
          int[] result = Range(length, updates);
          display(result);

          sc.close(); 
      }
  
      // function to display an array.
      public static void display(int[] arr) {
  
          for (int i = 0; i < arr.length; i++) {
              System.out.print(arr[i] + " ");
          }
  
          System.out.println();
      }

}
