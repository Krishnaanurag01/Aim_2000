package Dynamic_Programming_level_02;

public class Q49_Optimal_Strategy_For_A_Game {


    public static void main(String[] args) {
        
    }
    
    public static long get_optimal_strategy(int[] arr) {
        
        long[][] dp = new long[arr.length][arr.length] ;

        // using gap strategy.
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g ; j < dp.length; i++,j++) {
                
                if( g == 0 ){ // when gap is 0 then this is our answer as only one element present.
                    dp[i][j] = arr[i] ;
                }
                else if( g == 1){ /// at gap 1 , two elements present so store the max one.
                    dp[i][j] = Math.max(arr[i], arr[j]) ;
                }
                else{
                    // val1 is : if we choose arr[i] then arr[i+1] to arr[j] element will be left for opponent so if opponent chose arr[i+1] then left array is arr[i+2][j] and if opponent choose arr[j] then left element is arr[i+1] to arr[j-1].
                    long val1 = arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]) ;

                    // val2 is : if we choose arr[j] then arr[i] to arr[j-1] left for opponent to choose so if opponent choose arr[i] then arr[i+1] to arr[j-1] left for us else if opponent chooses arr[j-1] then arr[i] to arr[j-2] would be left for us.
                    long val2 = arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]) ;

                    // so we choose the max value ( means max profit for ourselevs).

                    long max = Math.max(val1, val2) ;

                    dp[i][j] = max ;

                }

            }
        }

        return dp[0][arr.length];
    }
}
