package Searching_and_Sorting;

import java.util.*;

public class Q20_Kth_smallest_number_again {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int NumberOfTestCases = sc.nextInt();
           for (int m = 0; m < NumberOfTestCases; m++) {
               
           int n = sc.nextInt();
           int Q = sc.nextInt();
   
   
           int[][] pairs = new int[n][2];
           for (int i = 0; i < n ; i++) {
               pairs[i][0] = sc.nextInt();
               pairs[i][1] = sc.nextInt();
           }
   
               Arrays.sort(pairs , (a,b) -> a[0] - b[0]);
   
           Stack<int[]> stack = new Stack<>();
           stack.push(pairs[0]);
   
           for (int i = 1 ; i < pairs.length; i++) {
               // int startpoint1 = pairs[i][0];
               // int endpoint1 = pairs[i][1];
   
               int[] temp = stack.pop();
   
               if (temp[1] >= pairs[i][0]) {
                   temp[1] = Math.max(temp[1], pairs[i][1]);
                   stack.push(temp);                
               }else{
                   stack.push(temp);
                   stack.push(pairs[i]);
               }
           }
   
           int[][] outputIntervals = new int[stack.size()][2];
           for (int i = outputIntervals.length-1 ; i >= 0; i--) {
               int[] stackInterval = stack.pop();
               outputIntervals[i][0] = stackInterval[0];
               outputIntervals[i][1] = stackInterval[1];            
           }
   
   
           while (Q-- > 0) {
               int k = sc.nextInt();
               int ans = -1;
               for (int i = 0; i < outputIntervals.length; i++) {
                   if(outputIntervals[i][1] - outputIntervals[i][0] + 1 > k){
                       ans  = outputIntervals[i][0] + k -1;
                   }
                   else{
                       k = k - outputIntervals[i][1] ;
                   }
               }
   
               System.out.println(ans);
               
           }}

           
           sc.close();
    }
}
