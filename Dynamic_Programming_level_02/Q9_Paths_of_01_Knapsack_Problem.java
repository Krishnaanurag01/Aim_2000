package Dynamic_Programming_level_02;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q9_Paths_of_01_Knapsack_Problem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;

        int[] val = new int[n] ;
        for (int i = 0; i < val.length; i++) {
            val[i] = sc.nextInt() ;
        }

        int[] wt = new int[n] ;

        for (int i = 0; i < wt.length; i++) {
            wt[i] = sc.nextInt() ;
        }


        int cap = sc.nextInt() ;

        print_knapsack_path(val, wt, cap);

        sc.close(); 
        
    }


    static class pair{
        int i , j ;
        String path ;

        pair(int i , int j , String s){
            this.i = i ; 
            this.j = j ;
            this.path = s ;
        }
    }



    public static void print_knapsack_path(int[] val , int[] wt, int cap) {
        


        // already done this in level 01 dp.
        int[][] dp = new int[wt.length+1][cap+1] ;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                

                if(i == 0 || j== 0){
                    dp[i][j] = 0 ;
                }
                else{
                    dp[i][j] = dp[i-1][j] ;

                    if( j >= wt[i-1]){
                        int pre_val = dp[i-1][j-wt[i-1]] + val[i-1];
                        dp[i][j] = Math.max(dp[i][j], pre_val) ;
                    }
                }
            }
            
        }


        // printing path logic starts here.

        System.out.println(dp[wt.length][cap]);

        ArrayDeque<pair> queue = new ArrayDeque<>() ;

        /// addding the bottom right most pair.
        queue.add( new pair(wt.length , cap , "")) ;  // wt.length is i , cap is j and "" is path of bottom right most node.

        while ( queue.size() > 0 ) {
            
            pair rp = queue.removeFirst() ;  // remove first.

            if(rp.i == 0 || rp.j == 0){  /// if our pairs i or j is on 0th index then print.
                System.out.println(rp.path);
            }
            else{

                // find the answer of exclude part.

                int exclude = dp[rp.i-1][rp.j] ;



                // if dp[rp] is made up using previous team score + current score, then check and add.
                if(rp.j >= wt[rp.i - 1]){  // if rp.j (which is current capacity) is greater than current element weight( wr[rp.i-1]) then find include part.

                    // include part.
                    int include = dp[rp.i-1][rp.j - wt[rp.i-1]] + val[rp.i-1] ;
                    

                    // if current removed part is include one then add it to the queue with rp.i-1 index in path.
                    if(dp[rp.i][rp.j] == include){
                        queue.add( new pair(rp.i-1, rp.j - wt[rp.i-1] , (rp.i - 1) +" "+rp.path)) ;
                    }
                }


                // if dp[rp] is made up using previous value of same col.then check and add.
                if(dp[rp.i][rp.j] == exclude){ // if current pair is exclude path then add pair without any rp.i-1 (as this index is not ussed to make the data)
                    queue.add( new pair(rp.i-1, rp.j  , rp.path)) ;
                }


            }
        }



    }
    
}
