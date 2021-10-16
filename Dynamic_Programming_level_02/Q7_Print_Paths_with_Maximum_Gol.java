package Dynamic_Programming_level_02;

import java.util.ArrayDeque;

public class Q7_Print_Paths_with_Maximum_Gol { // max gold prob


    public static void main(String[] args) {
        
    }


    static class pair{
        int i , j ;
        String path ;

        pair(int i , int j , String path){
            this.i = i ;
            this.j = j ;
            this.path = path ;
        }
    }


    public static void print_max_gold_path(int[][] path) {
        int n = path.length ;
        int m = path[0].length ;



        // we already done this in level 1 ;
        int[][] dp = new int[n][m];

        for (int j = m-1 ; j >= 0 ; j--) {
            for(int i = 0 ; i < n ; i++){


                if(j == m-1){
                    dp[i][j] = path[i][j];
                }
                else if(i == 0){
                    dp[i][j] = Math.max(dp[i+1][j+1], dp[i][j+1]) + path[i][j] ;
                }
                else if(i == n-1){
                    dp[i][j] = Math.max(dp[i-1][j+1], dp[i][j+1]) + path[i][j] ;
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j+1], Math.max(dp[i-1][j+1], dp[i][j+1] )) + path[i][j] ;
                }

            }
        }

        int max = dp[0][0] ;

        for(int i = 1 ; i < n ; i++){
            max = Math.max(max, dp[i][0]);
        }

        /// printing logic starts here.

        ArrayDeque<pair> queue = new ArrayDeque<>() ;

        for (int i = 0; i < dp.length; i++) {
            if(dp[i][0] == max ){ // if value is equal to max then make a pair and add it to the queue.
                queue.add(new pair(i, 0, i+""));
            }
        }


        while (queue.size() > 0 ) {

            pair rp = queue.removeFirst() ; // remove first and perform with same condition as above.

            // d1 : row-1 - col+1 , d2 : row  - col + 1 , d3 : row + 1 - col + 1

            if(rp.j == m-1){  // if it is on the last col then print the path.
                System.out.println(rp.path);
            }
            else if(rp.i == n-1){ // check if it is in last row.
                // find max output.
                int greater = Math.max(dp[rp.i][rp.j+1], dp[rp.i-1][rp.j+1]) ;


                // if both side has same number then add both else add the greater one.
                if(dp[rp.i-1][rp.j+1] == greater){
                    queue.add( new pair(rp.i-1, rp.j+1 , rp.path+"d1 ")) ;
                }
                if(dp[rp.i][rp.j+1] == greater){
                    queue.add( new pair(rp.i, rp.j+1 , rp.path+"d2 ")) ;
                }


            }
            else if(rp.i == 0){

                int greater = Math.max(dp[rp.i][rp.j+1], dp[rp.i+1][rp.j+1]) ;

                 // if both side has same number then add both else add the greater one.
                if(dp[rp.i][rp.j+1] == greater){
                    queue.add( new pair(rp.i, rp.j+1 , rp.path+"d2 ")) ;
                }
                if(dp[rp.i+1][rp.j+1] == greater){
                    queue.add( new pair(rp.i+1, rp.j+1 , rp.path+"d3 ")) ;
                }

            }
            else{

                //  finding the greatest in all three side.
                int greater = Math.max(dp[rp.i][rp.j+1], Math.max( dp[rp.i-1][rp.j+1], dp[rp.i+1][rp.j+1] )) ;

                 // if all side has same number then add all else add the greater one.

                if(dp[rp.i-1][rp.j+1] == greater){
                    queue.add( new pair(rp.i-1, rp.j+1 , rp.path+"d1 ")) ;
                }
                if(dp[rp.i][rp.j+1] == greater){
                    queue.add( new pair(rp.i, rp.j+1 , rp.path+"d2 ")) ;
                }
                if(dp[rp.i+1][rp.j+1] == greater){
                    queue.add( new pair(rp.i+1, rp.j+1 , rp.path+"d3 ")) ;
                }

            }
            
        }
        
    }
    
}
