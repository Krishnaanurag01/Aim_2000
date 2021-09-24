package Dynamic_Programming_level_01;

public class Q29_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    public static void main(String[] args) {
        
    }

    public int maxProfit(int[] prices, int fee) {
        
        int obsp = -prices[0];  // concept like include and exclude.
        int ossp =  0 ;
        
        for(int i=1 ; i< prices.length ; i++){
            int nbsp = 0 ;
            int nssp = 0 ;
            
            if(ossp - prices[i] > obsp){  // check if previous sale - current stock price is better or previous buy value is better.
                nbsp = ossp - prices[i];  // if pre sale - current stock price is better then store it.
            }
            else{
                nbsp = obsp; /// otherwise continue with previous buy price
            }
            
            if(obsp + prices[i] - fee > ossp){ // check for current sale price.
                // checking if previous buy + current price - fee (gives current sale price)is better than previous sale.
                nssp = obsp + prices[i] - fee; // then store current sale.
            }
            else{
                nssp = ossp ; // else don't sale and continue with previous sale.
            }
            
            ossp = nssp ; // now storing the new sale state price
            obsp = nbsp ; // storeing the new buy state price.
        }
        
        return ossp;
    }
    
}
