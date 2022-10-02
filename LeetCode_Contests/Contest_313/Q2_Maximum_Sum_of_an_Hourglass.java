package LeetCode_Contests.Contest_313;

public class Q2_Maximum_Sum_of_an_Hourglass {

    public int maxSum(int[][] grid) {
        
        int ans = 0 ;
        
        for(int i = 0 ; i < grid.length  - 2 ; i++ ){
            int up_sum = 0 ; // sum of upper layer of hourglass
            int count = 0 ;
            for(int r1 = 0 ; r1 < grid[0].length ; r1++){
                if(count < 3){
                    up_sum += grid[i][r1] ;
                    count++ ;   
                    if(count == 3){
                       int temp = up_sum ;
                       temp += grid[i+1][r1 - 1] ; // adding mid of hourglass
                        // now adding lower layer of hourglass.
                       temp += grid[i+2][r1] + grid[i+2][r1-1] + grid[i+2][r1-2] ;
                       ans = Math.max(ans,temp) ; // now checking ans.
                    }
                }
                else{
                    up_sum += grid[i][r1] - grid[i][r1 - 3] ; // adding current jth value and removing previous left of window
                    int temp = up_sum ; // upper layer
                    temp += grid[i+1][r1 - 1] ; // mid cell of hourglass
                    // adding the lower layer of hourglass
                    temp += grid[i+2][r1] + grid[i+2][r1-1] + grid[i+2][r1-2] ;
                    ans = Math.max(ans,temp) ;
                }
            }
        }
        
        return ans ;
    }
}
