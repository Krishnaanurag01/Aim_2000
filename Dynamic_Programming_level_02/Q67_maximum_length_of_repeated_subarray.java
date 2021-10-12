package Dynamic_Programming_level_02;

public class Q67_maximum_length_of_repeated_subarray {

    public static void main(String[] args) {
        
    }

    public static int get_length(int[] arr1, int[] arr2) {
        
        int[][] dp = new int[arr1.length + 1][arr2.length + 1] ;
        int ans = 0 ;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1 ; j < dp.length; j++) {
                
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }

                ans = Math.max(ans, dp[i][j]) ;
            }
        }

        return ans ;
    }
    
}
