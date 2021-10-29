package Dynamic_Programming_level_02;

public class Q98_Coin_game_winner_where_every_player_has_three_choices {

    public static void main(String[] args) {
     
        printWinner(5, 3, 4);
    }

    public static void printWinner(int coins , int x , int y) {
        
        boolean[] dp = new boolean[coins+1] ;

        dp[0] = false ; // dp[0] denotes if there are 0 coins then A can win if A take the first moves ? so, false beacuse there's 0 coins.
        dp[1] = true ;  // dp[1] denotes if there are 1 coins then A can win if A take the first moves ? true becuase theres 1 coin.

        for (int i = 2 ; i < dp.length; i++) {
            
            if(i-1 >= 0 && dp[i-1] == false){ // if i - 1 is false then it means A will win (as answer is alternate) 
                dp[i] = true ;
            }
            else if( i-x >= 0 && dp[i-x] == false){// if i - x is false then it means A will win (as answer is alternate)
                dp[i] = true ;
            }
            else if( i-y >= 0 && dp[i-y] == false){ // if i - y is false then it means A will win (as answer is alternate)
                dp[i] = true ;
            }
            else{
                dp[i] = false ;
            }
        }

        System.out.println( dp[coins] == true ? "A" : "B");
    }
    
}
