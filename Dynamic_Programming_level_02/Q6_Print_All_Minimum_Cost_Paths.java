package Dynamic_Programming_level_02;

import java.util.ArrayDeque;

public class Q6_Print_All_Minimum_Cost_Paths {

    public static void main(String[] args) {
        
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

    public static void print_min_path_cost(int[][] path) {
        
        int n = path.length ;
        int m = path[0].length ;

        int[][] dp = new int[n][m] ;

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = m-1 ; j >= 0 ; j--){

                if(i == n-1 && j == m-1){
                    dp[i][j] = path[i][j] ;
                }
                else if( i == n-1 ){
                    dp[i][j] = dp[i][j+1] + path[i][j] ; 
                }
                else if( j == m-1){
                    dp[i][j] = dp[i+1][j] + path[i][j] ; 
                }
                else{

                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + path[i][j] ; 
                }

            }
        }

        System.out.println(dp[0][0]);

        ArrayDeque<pair> queue = new ArrayDeque<>() ;

        queue.add(new pair(0, 0, "")) ;


        while (queue.size() > 0) {
            pair rp = queue.removeFirst() ;

            if(rp.i == n-1 && rp.j == m-1) {
                System.out.println(rp.path);
            }
            else if(rp.i == n-1)
            {
                queue.add( new pair(rp.i, rp.j+1 , rp.path+"H"));
            }
            else if(rp.j == m-1){
                queue.add( new pair(rp.i+1, rp.j , rp.path+"V"));
            }
            else{
                if(dp[rp.i][rp.j+1] < dp[rp.i+1][rp.j]){

                    queue.add( new pair(rp.i, rp.j+1 , rp.path+"H"));
                }
                else if(dp[rp.i][rp.j+1] > dp[rp.i+1][rp.j]){
                    queue.add( new pair(rp.i+1, rp.j , rp.path+"V"));
                }
                else{
                    queue.add( new pair(rp.i+1, rp.j , rp.path+"V"));
                    queue.add( new pair(rp.i, rp.j+1 , rp.path+"H"));
                }

            }
        }


    }
    
}
