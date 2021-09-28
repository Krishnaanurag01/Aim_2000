package Dynamic_Programming_level_02;

public class Q19_Unique_Binary_Search_Trees {

    public static void main(String[] args) {
        
    }
    
    // same as catalan number! check copy for better explanation.

    public static int get_total_unique_bst(int n ) {
        
        if(n == 0 || n == 1) return 1 ;

        int[] dp = new int[n+1] ;

        dp[0] = 1 ; // with 0 node bst is 1 ;
        dp[1] = 1 ;  // with 1 node 1 can be formed .

        for (int i = 2; i < dp.length; i++) {
            
            int l = 0 ;// starting from left.
            int r = i-1 ; // till the i - 1.

            while (l <= i-1) {

                dp[i] = dp[l]*dp[r] ;  // multiply left with right.
                l++ ; // increament left.
                r-- ; // decreament right.
            }
        }

        return dp[n] ;  // returing answer.

    }
}
