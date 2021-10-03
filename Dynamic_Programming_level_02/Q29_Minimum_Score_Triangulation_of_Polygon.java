package Dynamic_Programming_level_02;

public class Q29_Minimum_Score_Triangulation_of_Polygon {

    public static void main(String[] args) {
        
    }


    //Return the smallest possible total score that you can achieve with some triangulation of the polygon.

    public static int get_min_score_triangulation(int[] arr) {
        
        int n = arr.length ;
        int[][] dp = new int[n][n] ;

        for (int g = 0; g < dp.length; g++) {   // gap strategy.
            for (int i = 0 , j = g ; j < dp.length; i++ , j++) {

                if(g==0){ // when gap is 0 or 1 then it can't form triangle so 0.
                    dp[i][j] = 0 ;
                }
                else if(g==1){
                    dp[i][j] = 0 ;
                }
                else if(g==2){ // gap 2 means 3 vertex.
                    dp[i][j] = arr[i] * arr[i+1] * arr[i+2] ; // so mulitplying all three vertex.
                }
                else{

                    int min = Integer.MAX_VALUE ; // now fiding min.

                    for (int k = i+1 ; k <= j-1 ; k++) { // ignoring i and j and starting from i+1 to j-1. as i and j is the base of triangle so middle part (k) is the third vertex.
                        
                        int val = arr[i] * arr[k] * arr[j] ; // counting value.
                        int left  = dp[i][k]; // left part is i to k  eg. abcdef : and k is d so left is abcd and right is def.
                        int right  = dp[k][j] ; // right is k to j .

                        // formula is : val + left + right.
                        int total = val + left + right ;

                        if(total < min){
                            min = total ;
                        }
                    }

                    dp[i][j] = min ;
                }
                
            }
        }

        return dp[0][n-1] ;
    }
    
}
