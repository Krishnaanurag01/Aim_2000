package Dynamic_Programming_level_02;

public class Q25_Rod_Cutting_Problem {

    public static void main(String[] args) {
        
    }
    

    // method 01 : (left right strategy)

    public static int get_max_price(int[] prices , int n) {
        
        if(n < 2) return prices[n-1] ;

        int[] np = new int[n+1] ; // arranging in new array as prices at 0th index is value of 1 length rod and 2 length rod value stored in 1st index. so creating a new array where 0 length , 1 length .. values stored in 0 , 1 index and so on..

        for (int i = 0 ; i < n; i++) {
            np[i+1] = prices[i] ; 
        }

        int[] dp = new int[n+1] ;
        dp[0] = 0 ;
        dp[1] = np[1] ; // 1 length rod value is np[1]

        for (int i = 2; i < dp.length; i++) {

            dp[i] = np[i] ; // storing the original value by default.

            int l = 1 ;  // something like catalan numbers.
            int r = i-1 ;

            while (l <= r) { // the moment l == r that point is mid point so stoping after that
                dp[i] = Math.max(dp[i], dp[l] + dp[r]);  // here getting both cut value from dp till 0 to half.

                l++;
                r-- ;
            }
            
        }


        return  dp[n] ;

    }



    // method - 02 : ( cut strategy )

     
 public static int road_cut(int[] arr , int n) {
     
    if(n < 2) return arr[n-1] ;
      
      int[] narr = new int[n+1] ;

      for (int i = 0; i < n; i++) {
          narr[i+1] = arr[i] ;
      }

      int[] dp = new int[n+1] ;
      dp[1] = narr[1] ;

      for (int i = 2 ; i < dp.length; i++) {
          
          int l = 1 ;
          int r = i-1 ;

          while (r >= 0) {  // L+ r == i // eg : 1 , 2, 3, 4, 5  and i is at 5th index so adding 1+4  == 5 , 2+3 = 5 and so on.
              dp[i] = Math.max(dp[i], narr[l] + dp[i-l]) ; // here 1 cut we getting from original array and one from dp (optimized value stored there)

              l++;
              r-- ;
          }
      }

      return dp[n] ;
  }
}
