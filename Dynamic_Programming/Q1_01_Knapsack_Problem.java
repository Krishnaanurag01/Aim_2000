package Dynamic_Programming;


public class Q1_01_Knapsack_Problem {
    public static void main(String[] args) {
        for(int i = 0 ; i< 1002 ; i++ ){
            for(int j = 0 ; j< 1002 ; j++){
                dp[i][j] = -1 ;
            }
        }

       int values[] = {1,2,3};
       int weight[] = {4,5,1};

      System.out.println( knapSack(values, weight, 4, 3) ) ;
    }
    

    // recursive solution.

    // It should be noted that the above function computes the same sub-problems again and again .
    // The time complexity of this naive recursive solution is exponential (2^n).  


    // Time Complexity: O(2n). 
    public static int maxProfitSum(int[] values , int[] weight , int w , int n) {
        
        // base conditon 
        if(n == 0 || w == 0 ) return 0 ; // when n is zero or w becomes zero then return.

        if(weight[n-1] <= w){  // check if the weight at n is less than equal to given w(weight)
            // if this executes then we check max between , current vaalue + next value and only previous value.
            return Math.max(maxProfitSum(values, weight, w, n-1) , values[n-1] + maxProfitSum(values, weight, w - weight[n-1] , n-1)) ;
        }
        else{
            // this runs when weight[n-1] is not lesser than w.
            return maxProfitSum(values, weight, w, n-1) ;
        }

    }



    // method - 02 : recursive + memoization (gives the same time and space comp as method - 03(top-down approch))

    // Expected Time Complexity: O(N*W).
// Expected Auxiliary Space: O(N*W)

    static int[][] dp = new int[1002][1002] ; // took 1002 as it is given in questions constraints.

   

    public static int knapSack(int[] val ,int[] wt , int w , int n) { 

        // recursive function is same as above.

        if( w == 0 || n == 0) return 0 ;

        if(dp[n][w] != -1){ // when we already have data then return it.
            return dp[n][w] ;
        }
        
        if(wt[n-1] <= w){
            // here saving data first and then returning.
            return dp[n][w] = Math.max(knapSack(val, wt, w, n-1), val[n-1] + knapSack(val, wt, w - wt[n-1], n-1));
        }
        else{
// saving and returning it.
            return dp[n][w] = knapSack(val, wt, w, n-1) ;
        }
    }



    // method : 03


    public static int knapSack_td(int[] val , int[] wt , int W , int n) {              // td : top down
        int[][] dp = new int[n+1][W+1]  ; // making dp array of n+1 and w+1 size becuase we also want to store the n and w value.

        for (int i = 0; i <= n ; i++) {  // this represents n.
            for (int j = 0; j <= W ; j++) { // this represents w.
                
                if(i == 0 || j == 0 ) {  // when n or w is 0 then store 0.
                    dp[i][j] = 0 ;
                }
                else if(wt[i-1] <= j){  // here i-1 is same as n-1 ( used in above method). 
                    dp[i][j] = Math.max(dp[i-1][j],  val[i-1] + dp[i-1][ j - wt[i-1] ]  ); // choosing between exist and non exist.
                    // dp[i-1][j] represents when current data should not included vs previous data + current data.
                }
                else{
                    // else go to the n-1(i-1) row and jth column.
                    dp[i][j] = dp[i-1][j] ;
                }
            }
        }
     
        return dp[n][W] ;
    }
}
