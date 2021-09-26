package Dynamic_Programming_level_02;

import java.util.ArrayDeque;


public class Q8_Print_Subsets_with_Target_Sum {

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


    public static void print_subset_sum(int[] arr , int sum) {


        // done this in level 01 dp.
        boolean[][] dp = new boolean[arr.length+1][sum+1] ;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                
                if(j == 0){
                    dp[i][j] = true ;
                }
                else if(i == 0){
                    dp[i][j] = false ;
                }
                else{
                    if(dp[i-1][j]){
                        dp[i][j] = true ;
                    }
                    else if( j >= arr[i-1]){
                            dp[i][j] = dp[i-1][j-arr[i-1]] ;
                        }

                }

            }
            
        }


        // printing the path.
        System.out.println(dp[arr.length][sum]);


        // made a queue.
        ArrayDeque<pair> queue = new ArrayDeque<>() ;

        // adding new pair from bottom last.
        queue.add( new pair(arr.length, sum , "")) ; // arr.length is i and sum is j and "" is path of bottom right .

        while (queue.size() > 0) {

            // remove first.
            pair rp = queue.removeFirst() ;

            // if this removed pair index is in the first row or column then it means we reached the destination so print it.
            if(rp.j == 0 || rp.i == 0){
                System.out.println(rp.path);
            }
            else{

                // this is the condition when we look above in dp row and check if previous team score current score (j(current score) - arr[i-1](current array score)) .
                if(rp.j >= arr[rp.i - 1]){  // so when j is larger than the current arr[i-1] score then run.

                    boolean include = dp[rp.i - 1][rp.j - arr[rp.i - 1]] ; // means current player will play and check if previous team can score j(score needed) - current player score.

                    if(include){ // if true then add it to the queue.
                        queue.add( new pair(rp.i-1 , rp.j - arr[rp.i - 1 ], (rp.i-1 ) + " "+rp.path)) ; // rp.i -1 denotes the current index in array.
                    }

                }

                // exclude part.

                // this means if current player is not playing so check previous team can make current score.
                boolean exclude = dp[rp.i-1][rp.j] ;  // if yes then also add this pair. this will be one of the path too.

                if(exclude){
                    queue.add( new pair(rp.i-1 , rp.j ,rp.path)) ;
                }


            }
            
        }

        
    }
}