package Arrays_and_string_level_02;

public class Q77_Number_of_Smooth_Descent_Periods_of_a_Stock {

    public long getDescentPeriods(int[] prices) {
        
        long count = 1 ; // as we are starting from 1'st index so taking 0th index value by default thats why taking 1 in count.
        int j = 0 ;
        int lastPrice = prices[0] ;
        
        for(int i = 1 ; i < prices.length ; i++){
            int currPrice = prices[i] ;
            
            if(currPrice + 1 == lastPrice){ // curr day price is 1 less than previous then count all the continuous day
                count += (i-j+1) ;
                lastPrice = currPrice ;
            }
            else{
                j = i ; // else update j (first index value)
                lastPrice = currPrice ;
                count++ ;
            }
        }
        
        return count; 
    }
}
