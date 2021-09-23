package Dynamic_Programming;

public class Q30_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    public static void main(String[] args) {
        
    }

    public int maxProfit(int[] prices) {
        
        int obsp = -prices[0]; // buying 1st day stocks.  // obsp : old buying state price.
        int ossp = 0 ; // it denotes old selling state price.
        int ocdp = 0 ; // it denotes old cooldown .
        
        for(int i = 1 ; i < prices.length ; i++){
         
            // making new buying state , new selling abd new cooldown.
            int nbsp = 0 ;  
            int nssp = 0; 
            int ncdp = 0 ;
            
            if(ocdp - prices[i] > obsp){  // checking if we buy on cooldown then we are at more loan or less. 
                nbsp = ocdp - prices[i];  // if old buying is larger ( here old buying is in negative eg. -9 so larger the - value , larger the loan we owe) . it store new buying if nbsp is bigger ( eg. ocdp - price[i] == -2 and obsp is -9 then ocdp - price[i] becomes our new buying price.)
            }
            else{
                nbsp = obsp ; // else continue with old buying price.
            }
            
            
            if( obsp + prices[i] > ossp){ // checking if we sold our stocks today then the profit we make is larger or not.
                nssp = obsp + prices[i] ; // as obsp is a negative value so adding it with positive prices[i] gives us the total profit.
                // eg. obsp is -9 and price is 15 then new sold value is 6. so check if it greater than previous if yes then update.
            }
            else{
                nssp = ossp ;  // else don't sale and continue with old sell value.
            }
            
            
            // this is the key moment. in the first if condition above we are cheking buying with previous cooldown value. if that value is lesser with cooldown value then this condition will get used next iteration.
            if(ossp > ocdp){  // now cheking if old sell value is greater than cooldown price then update it
                ncdp = ossp ;
            }
            else{ // else continue with old one.
                ncdp = ossp ;
            }
            
            // now updating the new values.
            obsp = nbsp;
            ossp = nssp ;
            ocdp = ncdp ;
            
            
            
        }
        
        return ossp ; // returning new selling value. or profit.
        
    }
}
