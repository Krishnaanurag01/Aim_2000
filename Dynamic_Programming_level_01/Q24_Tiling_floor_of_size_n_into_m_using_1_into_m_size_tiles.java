package Dynamic_Programming_level_01;

public class Q24_Tiling_floor_of_size_n_into_m_using_1_into_m_size_tiles {

    public static void main(String[] args) {
        
    }

    public static void get_total_ways(int n , int m) {

        int[] dp = new int[n+1] ;

        for (int i = 1; i < dp.length; i++) {
            if(i < m){  // i which is our  width is less than length (m) then we only have one option to place tile vertically.
                dp[i] = 1 ;
            }
            else if(i == m){  // when i == m then we can store with 2 ways either vertically or horizontally.
                dp[i] = 2 ;
            }
            else{
                dp[i] = dp[i-1] + dp[i - m ] ; // else search in i-1 and i-m (when placed horizontally.) 
            }
        }

        System.out.println(dp[n]);
        
    }
    
}
