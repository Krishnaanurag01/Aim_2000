package Stack_and_Queue_level01;

import java.util.Arrays;
import java.util.Stack;

public class Q13_Overlapping_Intervals {


    public static void main(String[] args) {
        int[][] Intervals = {{1,3},{2,4},{6,8},{9,10}} ;

        int[][] ans = overlappedInterval(Intervals) ;

        for (int[] is : ans) {
            System.out.println(is[0] + " " + is[1]);
        }
    }

    public static int[][] overlappedInterval(int[][] Intervals)
    {
        Arrays.sort(Intervals , (a,b) -> a[0] - b[0] );

        Stack<int[]> stack = new Stack<>() ;
        stack.push(Intervals[0]) ;

        for (int i = 1 ; i < Intervals.length; i++) {
            
            int[] poppedArr = stack.pop();
            int f_u = poppedArr[0] ;
            int f_v = poppedArr[1] ;

            int s_u = Intervals[i][0] ;
            int s_v = Intervals[i][1] ;

            int end = Math.max(f_v, s_v) ;

            if(f_v >= s_u){

                stack.push( new int[]{f_u , end}) ;

            }
            else{

                stack.push(poppedArr) ;
                stack.push(Intervals[i]) ;

            }
        }

        int[][] ans = new int[stack.size()][2] ;

        for (int i = 0 ; i <= stack.size()  ; i++) {
            int[] popped = stack.pop() ;
            ans[i][0] = popped[0] ;
            ans[i][1] = popped[1] ;
        }

        return ans ;
    }
    
}
