package Dynamic_Programming_level_01;

public class Q28_Best_Time_to_Buy_and_Sell_Stocks_2_Infinite_Transactions {


    public static void main(String[] args) {
        
    }
    
    public static int max_profit_with_infinite_transac(int[] prices) {
        
        int bp = 0 ;
        int sp = 0 ;
        int profit = 0 ;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] >= prices[i-1]){
                sp++;
            }
            else{
                profit += prices[sp] - prices[bp];
                bp = sp = i ;
            }
        }

        profit += prices[sp] - prices[bp] ;

        return profit ;
    }
}
