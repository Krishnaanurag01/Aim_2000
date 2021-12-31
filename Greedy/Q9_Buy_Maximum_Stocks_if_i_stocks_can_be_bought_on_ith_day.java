package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q9_Buy_Maximum_Stocks_if_i_stocks_can_be_bought_on_ith_day {

    static class Pair {
        int val ; // this denotes price of stock
        int quan ; // and this denotes the max quantity we can buy.

        Pair(int  x , int y){
            val = x ;
            quan = y ;
        }
    }

    static class comp implements Comparator<Pair> {
    
        // sorting based on value.
        public int compare(Pair p1, Pair p2){
            return p1.val - p2.val ;
        }
        
    }


    public static int maxStock(int[] prices, int n, int amount ) {
        
        PriorityQueue<Pair> q  = new PriorityQueue<>( new comp() ) ;

        for (int i = 0; i < prices.length; i++) { // adding to q with value of stock and quantity.
            q.add(new Pair(prices[i], i+1)) ; // here adding quantity with 1 based indexing so that 0th index can buy 1 stock and so on.
        }

        int count = 0 ; 

        while (q.size() > 0) { 
            Pair rp = q.poll() ;  // removing the top most element with minimum value.

            if(rp.val <= amount){ // if it is lesser and equals to amount then incrementing count.
                count++ ;
                amount -= rp.val ; // and subtracting value from amount.
                if(rp.quan > 1) // if we have more than 1 quantity then adding back to queue with 1 lesser quantiy (as  we have already used that one quantity)
                q.add( new Pair(rp.val, rp.quan - 1)) ;

            }
            else{
                // if the removed pair value which is minimum because we used priority queue and it's top always point to min is not less than or equals to amount then no other pairs can be less than as well(as others are greater than top pair)
                break ;  // so break directly instead of iterating again.
            }
        }


        
        return count;
    }
    
}
