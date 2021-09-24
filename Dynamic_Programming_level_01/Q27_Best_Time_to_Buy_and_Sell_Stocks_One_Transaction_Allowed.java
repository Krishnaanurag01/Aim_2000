package Dynamic_Programming_level_01;

public class Q27_Best_Time_to_Buy_and_Sell_Stocks_One_Transaction_Allowed {
    

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4} ;

        System.out.println( getMax_profit(prices));
    }

    public static int getMax_profit(int[] prices) {
        
        int min_price = Integer.MAX_VALUE ;
        int max_profit = 0 ;

        for (int i = 0; i < prices.length; i++) {
            if(min_price > prices[i]){
                min_price = prices[i];
            }
            else if( max_profit < prices[i] - min_price){
                max_profit  = prices[i] - min_price ;
            }
        }

        return max_profit ;
    }
}
