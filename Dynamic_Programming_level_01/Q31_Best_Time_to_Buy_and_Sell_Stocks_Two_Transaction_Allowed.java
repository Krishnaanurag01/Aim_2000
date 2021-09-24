package Dynamic_Programming_level_01;

public class Q31_Best_Time_to_Buy_and_Sell_Stocks_Two_Transaction_Allowed {

    public static void main(String[] args) {
        
    }

    public static int maxProfit(int[] prices) {
        

        // max profit if sold up to today.

        int mpist = 0 ;
        int[] mpist_arr = new int[prices.length] ;
        int least = prices[0] ;

        for (int i = 1; i < mpist_arr.length; i++) {
        
            if(least > prices[i]){
                least = prices[i] ;
            }

            mpist = prices[i] - least ;

            if(mpist > mpist_arr[i-1]){
                mpist_arr[i] = mpist ;
            }
            else{
                mpist_arr[i] = mpist_arr[i-1] ;
            }

        }



        // max profit if buy up to today 

        int mpibt = 0 ;
        int[] mpibt_arr = new int[prices.length] ;
        int maxprice = prices[prices.length -1] ; 

        for (int i = prices.length - 2 ; i >= 0; i--) {
            
            if(maxprice < prices[i]){
                maxprice = prices[i] ;
            }

            mpibt = maxprice - prices[i] ;

            if(mpibt > mpibt_arr[i+1]){
                mpibt_arr[i] = mpibt ;
            }
            else{
                mpibt_arr[i] = mpibt_arr[i+1] ;
            }
        }


        // now finding the max sum of both loop.
        int output = 0 ;

        for (int i = 0; i < prices.length ; i++) {
            output = Math.max(output,mpibt_arr[i] + mpist_arr[i] );
        }

        return output ;
    }
    
}
