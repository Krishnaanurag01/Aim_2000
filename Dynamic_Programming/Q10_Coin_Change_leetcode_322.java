package Dynamic_Programming;

public class Q10_Coin_Change_leetcode_322 {

    public static void main(String[] args) {
        
    }

    public static void get_fewest_coin(int[] coins,  int sum) {
        
        int[] dp = new int[sum+1] ;

        dp[0] = 1 ;

        for (int i = 0; i < dp.length; i++) {
        
            for (int coin : coins) {
                
                if(i >= coin && dp[i] == 0){
                    
                }
            }
            
        }


    }
    
}
