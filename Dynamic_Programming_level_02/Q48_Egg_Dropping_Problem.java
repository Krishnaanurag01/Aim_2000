package Dynamic_Programming_level_02;

public class Q48_Egg_Dropping_Problem {

    public static void main(String[] args) {
        
    }

    public static int get_min_attempt(int n , int k) { // n : eggs , k : number of floor.

        int[][] dp = new int[n+1][k+1] ;

        /* base case : when egg = 1 then store floor(means we try in each floor.)
                       when floor = 0 then store 0
                       when egg = 0 then store 0
                       when floor is 1 then store 1
        
        */

        for (int i = 1; i < dp.length; i++) { // row : denotes egg. 
            for (int j = 1; j < dp[0].length; j++) { // col : denotes floor.

                if(i==1){ // when egg is 1.
                    dp[i][j] = j ;
                }
                else if(j==1){ // when floor is 1.
                    dp[i][j] = 1 ;
                }
                else{

                    int min = Integer.MAX_VALUE ;

                    for (int mj = j-1 , pj = 0 ; mj >= 0; mj-- , pj++) { // finding max of previous floors and updating with min.
                        int val1 = dp[i][mj] ; // when egg doesn't break
                        int val2 = dp[i-1][pj] ; // when egg does break

                        int max = Math.max(val1, val2) ; // checking max 
                        min = Math.min(min, max) ; // now getting best of worst ( means getting min of max)
                    }

                    dp[i][j] = min + 1 ; // now adding 1 with min because we already tested one egg if it is breaking or not.
                }
                
            }
        }
        
        return dp[n][k] ;
    }
    
}
