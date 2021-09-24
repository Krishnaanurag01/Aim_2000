package Dynamic_Programming_level_01;

public class Q32_Best_Time_to_Buy_and_Sell_Stocks_K_Transaction_Allowed {

    public static void main(String[] args) {
        
    }


    // method : 01 takes o(n3) time and o(n2) space.
    public static int max_profit_k_transaction(int k , int[] prices) {
        

        int[][] dp = new int[k+1][prices.length] ; // dp of transaction (k) rows and prices column.

        for (int ts = 0; ts < dp.length; ts++) {  // ts : transaction.
            for (int d = 1; d < dp[0].length; d++) {  // d : days.

                dp[ts][d] = dp[ts][d-1] ;  // storing the same row previous column data first and

                for (int pd = 0; pd < d ; pd++) {  // and now comparing with previous row data + that index price - current day price(d)
                    // and storing max in current transaction row and current col.
                    
                    dp[ts][d] = Math.max(dp[ts][d], dp[ts-1][pd] + prices[d] - prices[pd]) ;
                }
                
            }
            
        }

        return dp[k][prices.length-1] ;
    }
    

    // method - 02 :

    public static int max_profit_k_transaction_2(int k , int[] prices) {
        

        if(prices.length == 0){
            return 0 ;
        }

       int[][] dp = new int[k+1][prices.length] ; // dp of transaction (k) rows and prices column.

       for (int ts = 1; ts < dp.length; ts++) {  // ts : transaction.
           int max = Integer.MIN_VALUE ; // this will keep the max value of previous row so that we don't have to iterate for every data.
           for (int d = 1; d < dp[0].length; d++) {  // d : days.

             if(dp[ts-1][d-1] - prices[d-1] > max){   // updating max if previous row - prices[d-1] is larger.
                  max = dp[ts-1][d-1] - prices[d-1] ;
              }


              if(max + prices[d] > dp[ts][d-1]){   // now cheking if previous columnd data is less than max + prices[d] then update the larger value.

               dp[ts][d] = max + prices[d] ; 
              }
              else{

                // else store previous column data.
               dp[ts][d] = dp[ts][d-1] ;
              }

               
               
           }
           
       }

       return dp[k][prices.length-1] ;

    }
    
}
