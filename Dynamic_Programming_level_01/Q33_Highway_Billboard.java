package Dynamic_Programming_level_01;

import java.util.HashMap;
import java.util.Scanner;



public class Q33_Highway_Billboard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;

        int m = sc.nextInt() ; // length of road.
        int n = sc.nextInt() ; // number of bill boards.

        int[] billboard_position = new int[n] ; // will store the position of every billboards.

        for (int i = 0; i < billboard_position.length; i++) {
            billboard_position[i] = sc.nextInt() ;
        }

        int[] revenue_Arr = new int[n] ;  // will store the revenue(profit) of every bill board.

        for (int i = 0; i < revenue_Arr.length ; i++) {
            revenue_Arr[i] = sc.nextInt() ;            
        }
        
        int distance = sc.nextInt() ;  // You are given a number T such that bill-boards can only be placed after specific distance(T).

        System.out.println( solution(m, billboard_position, revenue_Arr, distance) );

        sc.close(); 
    }



    // time and space is : o(n2) time and o(n) space.
    public static int solution(int m, int[] x, int[] rev, int t) {
      
        // write your code here
        
        int[] dp = new int[x.length] ;
        dp[0] = rev[0] ; // storing the first bill board at 0th index by default.
        int ans = 0 ;
        
        for(int i = 1 ; i < x.length ; i++){ // now going to every bill board.
            int max = 0 ; // this will store the max profit.
            for( int j = 0 ; j < i ; j++){ // now running loop 0 to i-1.
                
                int diff = x[i] - x[j] ; // first finding the distance difference.
                
                if(diff > t){ // if it is greater than given t then run this.
                    max = Math.max(max ,dp[j]) ; // updating the max profit.
                }
            }
            
            dp[i] = max + rev[i]; // now adding max profit with current billboard profit.
            ans = Math.max(dp[i],ans) ; // updating answer.
        }
        return ans;
      }



      // method : 02 .
      // time is : o(m) and space is o(m)


      public static int solution_2(int m, int[] x, int[] rev, int t) {

        HashMap<Integer,Integer> map = new HashMap<>() ;

        for(int i = 0 ; i < x.length ; i++){
            map.put(x[i], rev[i]) ;
        }

        int[] dp = new int[m+1] ;
        
        for(int i = 1 ; i <= m ; i++){

            if(map.containsKey(i) == false){
                dp[i] = dp[i-1] ;
            }
            else{
                int board_not_installed = dp[i-1] ;
                int board_installed = map.get(i) ;

                if(i >= t+1){
                    board_installed += dp[i - t - 1] ;
                }
                dp[i] = Math.max(board_not_installed, board_installed) ;
            }

        }

        return dp[m] ;
      }
    

      // method 03 :
      // without using hashMap.

      public static int method3(int m , int[] x, int[] rev, int t) {
        
        int[] dp = new int[m+1] ;

        // storing the given poster so that we can identify the poster in dp array without using hashmap

        for(int i = 0 ; i < x.length ; i++){
            int idx = x[i] ;
            int val = rev[i] ;

            dp[idx] = val ;
        }

        for(int i = 1 ; i <= m ; i++){

            if(dp[i] > 0 && i-t-1 >= 0){
                dp[i] =  Math.max( dp[i] + (dp[i-t-1]) , dp[i-1] ) ;
            }
            else{
                dp[i] =  Math.max( dp[i] , dp[i-1] ) ;
            }

        }

        return dp[m];
    }
}
