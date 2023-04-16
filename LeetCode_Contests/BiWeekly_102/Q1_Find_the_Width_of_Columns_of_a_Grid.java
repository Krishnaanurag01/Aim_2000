package LeetCode_Contests.BiWeekly_102;

public class Q1_Find_the_Width_of_Columns_of_a_Grid {
    
    public int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length] ;
        
        for(int i = 0; i < grid.length ; i++){
            
            for(int j = 0 ; j < grid[0].length ; j++){
                int val = grid[i][j] ;
                int size = val <= 0 ? 1 : 0 ;
                val = val < 0 ? -val : val ;
                
                // if(val == 0){
                //     size = 1 ;
                // }
                
                while(val > 0){
                    val = val/10 ;
                    size++ ;
                }
                ans[j] = Math.max(ans[j], size) ;
            }
        }
        
        return ans ;
    }
}
