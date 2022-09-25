package LeetCode_Contests.Contest_12;
import java.util.*;

public class Q1_Sort_the_people {

    public String[] sortPeople(String[] names, int[] heights) {
        
        Pair[] cnh = new Pair[names.length] ;
        String[] ans = new String[names.length] ;;
        
        for(int i = 0 ; i < names.length ; i++){
            cnh[i] = new Pair(names[i], heights[i]) ;
        }
        
        Arrays.sort(cnh) ;
        
        for(int i = 0  ; i < names.length ; i++){
            ans[i] = cnh[i].name ;
        }
        
        return ans ;
    }
    
    class Pair implements Comparable<Pair>{
        String name ;
        int height ;
        
        Pair(String x, int h){
            name= x ;
            height = h ;
        }
        
        public int compareTo(Pair o){
            return o.height - this.height ;
        }
    }
}
