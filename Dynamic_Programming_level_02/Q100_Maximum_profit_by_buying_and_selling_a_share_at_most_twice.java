package Dynamic_Programming_level_02;

public class Q100_Maximum_profit_by_buying_and_selling_a_share_at_most_twice {

    public static void main(String[] args) {
        int price[] = { 2, 30, 15, 10, 8, 25, 80 } ;
        get_max_profit(price);
    }

    // check Q31 of dp level-01 for explanation.

    public static void get_max_profit(int[] prices) {
        
        // max profit if sold up to today.

        int[] mpist = new int[prices.length] ;
        int least = prices[0] ;

        for (int i = 1; i < mpist.length; i++) {
            if(prices[i] < least){
                least = prices[i] ;
            }

            int max_price = prices[i] - least ;

            mpist[i] = Math.max(max_price, mpist[i-1]) ;
        }


        // max profit if bought up to today

        int[] mpibt = new int[prices.length] ;
        int max = prices[prices.length-1] ;

        for (int i = prices.length-2; i >= 0 ; i--) {
            if(prices[i] > max ){
                max = prices[i] ;
            }

            int max2 =  max - prices[i] ;

            mpibt[i] = Math.max(max2, mpibt[i+1]) ;
        }


        int output = 0 ;
        
        for (int i = 0; i < mpibt.length; i++) {
            output = Math.max( mpist[i] + mpibt[i] , output );
        }

        System.out.println( output );

    }
    
}
