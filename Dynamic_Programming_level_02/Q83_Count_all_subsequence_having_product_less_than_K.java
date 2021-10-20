package Dynamic_Programming_level_02;

public class Q83_Count_all_subsequence_having_product_less_than_K {
    
    public static void main(String[] args) {
        
    }

    public static int get_count(long[] a , long k) {
        
        if( k <= 1){ /// if k is 1 or less than 1 then return  0 ; because we have to find subarray whose product is less than k and  should be positive.
            return  0 ;
        }
        
        long prod = 1 ; // we multiply with this.
        int answer = 0 ;
        
        // using sliding window technique.
        int left  = 0 ;
        int right = 0 ;
        
        while(right < a.length){
          
          prod *= a[right] ; // we multiply right window element with product.
          
          while(prod >= k){ // if the product becomes larger then divide it with the left window. think of it as we are sliding the left side of the window toward right side.
              prod /= a[left] ;
              left++ ; // now increament the  left window .
          }
          
          answer += right - left + 1 ;  //if both left and right at the same positio then we add 0-0+1 for only element else if right side is at 2nd index and left side is at 0th index then 2-0 = 2 that is subarray from 0 to 2 and +1 for current element itself. 
          
          right++; // incrementing the right window. 
            
        }
        
        return answer ;

    }
}
