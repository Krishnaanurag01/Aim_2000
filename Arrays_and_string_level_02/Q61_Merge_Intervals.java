package Arrays_and_string_level_02;

import java.util.Arrays;
import java.util.Stack;

public class Q61_Merge_Intervals {


    public static void main(String[] args) {
        
        int[][] intervals = { {1,3},{2,6},{8,10},{15,18} } ;

        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
     
        Arrays.sort(intervals, (a,b) -> a[0] - b[0] );

        Stack<int[]> st = new Stack<>() ;

        st.push(intervals[0]) ;

        for (int i = 1 ; i < intervals.length ; i++) {
            int[] arr1 = st.pop() ;
            int[] arr2 = intervals[i] ;

            int si1 = arr1[0] ;
            int ei1 = arr1[1] ;

            int si2 = arr2[0] ;
            int ei2 = arr2[1] ;

            if(si2 < ei1 ){

                // int ei = Math.max
                // st.push(arr1) ;
                int ei = Math.max(ei1, ei2) ;
                st.push(new int[]{si1,ei}) ;
            }
            else{
                st.push(arr1) ;
                st.push(arr2) ;
            }
        }

       
        for (int[] is : st) {
             // System.out.println(st);
             System.out.println("( "+is[0]+ " "+is[1] + " )" );

        }

        int[][] ans = new int[st.size()][2] ;

        for (int i = ans.length - 1 ; i >= 0 ; i-- ) {
            ans[i] = st.pop() ;
        }

        return ans ;
    }
    
}
