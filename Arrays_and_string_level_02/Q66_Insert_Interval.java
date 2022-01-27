package Arrays_and_string_level_02;
import java.util.*;

public class Q66_Insert_Interval {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        if(intervals.length == 0){ // when intervals empty then simply return the new new interval as answer.
            return new int[][]{newInterval} ;
        }
        
        ArrayList<int[]> list = new ArrayList<>() ;
        
        boolean isInserted = false ; // this will denote whether new interval is inserted or not.
        for(int i = 0 ; i < intervals.length ; i++){
            if( intervals[i][0] <= newInterval[0] || isInserted == true ){
                list.add(intervals[i]) ; 
            }
            else{
                list.add(newInterval) ;
                isInserted = true ;
                list.add(intervals[i]) ;
            }
        } 
        
        /// this happens when the new intervals start point is largest so it should be inserted in last in list .
        if(intervals.length + 1 != list.size()){
            list.add(newInterval) ;
        }
        
                // System.out.println(list + " " + list.size()) ;

        
        // now list has all intervals so check if any interval is overlapping if yes then merge it.
        

        // from this onwards code is same as merge interval. check merge interval code for explanation of the below code.

        Stack<int[]> st = new Stack<>() ;
        st.push(list.get(0)) ;
        
        for(int i = 1 ; i < list.size() ; i++ ){
            int[] curr = list.get(i) ;
            int[] prev = st.pop() ;
            
            int si1 = prev[0] ;
            int ei1 = prev[1] ;
            
            int si2 = curr[0] ;
            int ei2 = curr[1] ;
            
            if( ei1 >= si2 ){
                int ei = Math.max(ei1,ei2) ;
                st.push(new int[]{si1,ei}) ;
            }
            else{
                st.push(prev) ;
                st.push(curr) ;
            }
        }
        
        int[][] ans = new int[st.size()][2] ;
        
        // System.out.println(st.size()) ;
        
        for(int i = ans.length - 1 ; i >= 0 ; i--){
            int[] top = st.pop() ;
            ans[i][0] = top[0] ;
            ans[i][1] = top[1] ;
        }
        
        return ans ;
        
    }

}
