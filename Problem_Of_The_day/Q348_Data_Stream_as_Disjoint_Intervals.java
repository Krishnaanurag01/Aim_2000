package Problem_Of_The_day;
import java.util.*;

public class Q348_Data_Stream_as_Disjoint_Intervals {

    class SummaryRanges {

        TreeSet<Integer> set ;
        public SummaryRanges() {
            set = new TreeSet<>() ;
        }
        
        public void addNum(int value) {
            set.add(value) ;
        }
        
        public int[][] getIntervals() {
            ArrayList<int[]> al = new ArrayList<>() ;
            int start = -1 ;
            int end = -1 ;
            
            for(int val : set){
                if(start ==  -1 ){
                    start = val ;
                    end = val ;
                    continue ;
                }
                else if(end + 1 != val){ // agar last +1 != current val then add the last interval
                    al.add(new int[]{start, end}) ;
                    start = val;
                    end = val ;
                }
                else{ // or extend the interval end
                    end = val ;
                }
            }
            
            
                if(end != -1){
                    al.add(new int[]{start, end}) ;
                    start = -1;
                    end = -1 ;
                }
            
            
            int[][] ans = new int[al.size()][2] ;
            int idx = 0 ;
            for(int[] a : al){
                ans[idx++] = a ;
            }
            
            return ans ;
        }
    }
    
}
