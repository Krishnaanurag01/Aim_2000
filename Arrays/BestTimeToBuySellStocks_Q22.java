package Arrays;

public class BestTimeToBuySellStocks_Q22 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(getMaxProfit(arr));
    }
    // not efficient as it's order of : - o(n2)

    // public static int getMaxProfit(int[] prices) {
    //     int buyPrice = 0;
    //     int currentProfit = 0;
    //     int maxProfitSoFar = 0;

    //     for (int i = 1; i < prices.length; i++) {
    //         if(prices[buyPrice] > prices[i]){
    //             buyPrice = i ;
    //         }
    //         for (int j = prices.length-1 ; j >=i; j--) {
    //             currentProfit = prices[j] - prices[buyPrice]; 
    //         }
    //         if(currentProfit > maxProfitSoFar){
    //             maxProfitSoFar = currentProfit;
    //         }
    //     }
    //     return maxProfitSoFar;
    // }

    // same code with bit modification giving :- o(n) complexicity

    public static int getMaxProfit(int[] prices) {
            int buyPriceIndex = 0;
            int currentProfit = 0;
            int maxProfitSoFar = 0;
    
            for (int i = 0; i < prices.length-1; i++) {
                if(prices[buyPriceIndex] > prices[i]){
                    buyPriceIndex = i ;
                }
                currentProfit = prices[i+1] - prices[buyPriceIndex];
    
                // for (int j = prices.length-1 ; j >=i; j--) {
                //     currentProfit = prices[j] - prices[buyPrice]; 
                // }
                if(currentProfit > maxProfitSoFar){
                    maxProfitSoFar = currentProfit;
                }
            }
            return maxProfitSoFar;
        }


    // one more solution with a bit faster algo : o(n)

    // public static int getMaxProfit(int[] prices) {
    //     int minprice = Integer.MAX_VALUE;
    //     int maxprofit = 0;
    //     for (int i = 0; i < prices.length; i++) {
    //         if (prices[i] < minprice)
    //             minprice = prices[i];
    //         else if (prices[i] - minprice > maxprofit)
    //             maxprofit = prices[i] - minprice;
    //     }
    //     return maxprofit;
        
    // }


    }