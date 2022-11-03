package Problem_Of_The_day;
import java.util.*;

public class Q275_Enemy {

    public static int largestArea(int n,int m,int k,int[][] enemy) {
       
        HashSet<Integer> blocked_rows = new HashSet<>(); // blocked rows 
        ArrayList<Integer> cols = new ArrayList<>() ; // blocked columns.
        
        for(int[] e : enemy){
            int col = e[1] - 1 ;
            cols.add(col) ;
            blocked_rows.add(e[0] - 1) ;
        }
        cols.add(m) ; // adding Cols size also so that when no column is blocked it will help
        Collections.sort(cols) ;
        
       
        int max_conti = 0 ; // this is max continuos space between any two columns.
        
        for(int c = 0 ; c < cols.size() ; c++){
             int col = cols.get(c) ;
             if(c == 0){
                 max_conti = col - 0 ;
             }
             else{
                 max_conti = Math.max(max_conti, col - cols.get(c-1) - 1) ;
             }
         }
         
          
        int ans = 0 ;
        int prev = 0 ; // total space in previous continuos row
        
        for(int i = 0; i < n ; i++){
            if(blocked_rows.contains(i)){ // if current row is blocked then skip
                prev = 0 ;
                continue;
            } 
            
            // othwerwise max continuos gap
            prev += max_conti ;
            ans = Math.max(ans, prev) ; // and update the answer
        }
        
        return ans ;
     }
}
