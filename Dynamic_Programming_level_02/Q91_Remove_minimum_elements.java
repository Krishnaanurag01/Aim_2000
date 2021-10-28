package Dynamic_Programming_level_02;

import java.util.Arrays;

public class Q91_Remove_minimum_elements {

    public static void main(String[] args) {
       int[] arr = {4,5,100,9,10,11,12,15,200} ;

       System.out.println( get_min_removal(arr, arr.length));
    }

    // this will take : time = o(nlogn)
    //                  space = o(n2)

    public static int get_min_removal(int[] arr , int n) {
        
        if(arr.length == 1){
            return 0 ;
        }
        Integer[][] dp = new Integer[1001][1001] ;

        int i = 0 ;
        int j = arr.length - 1 ;

        Arrays.sort(arr);
        return solve( i , j , arr , dp);
    }

    private static int solve(int i, int j, int[] arr, Integer[][] dp) {

        if( i >= j ){
            return 0 ;
        }

        if(  2*arr[i] > arr[j]){
            return 0 ;
        }

        if( dp[i][j] != null){
            return dp[i][j] ;
        }

        return dp[i][j] = 1 + Math.min(solve(i+1, j, arr, dp), solve(i, j-1, arr, dp));
    }
    



    // using o(1) space : 

    public static int get_minimum_removal(int[] arr , int n ) {
        
        int longest_start = -1 ; /// identity index of start and end
        int longest_end = 0 ;

        for (int start = 0; start < n ; start++) {
            
            int min = Integer.MAX_VALUE ; // this will contain the min and max for each itration
            int max = Integer.MIN_VALUE ;

            for (int end = start ; end < n ; end++) {
      
                // update min max 

                if( arr[end] < min ) min = arr[end] ;
                if( arr[end] > max ) max = arr[end] ;

                if( 2*min <= max ){ // if value becomes lesser then directly break the loop
                    break ;
                }

                if(end - start > longest_end - longest_start || longest_start == -1){ // updating the answer index
                    longest_start = start ;
                    longest_end = end ;
                }
            }
        }


        if( longest_start == -1){ // if no element follow the property then return n
            return n ;
        }



        return n - (longest_end - longest_start + 1 ) ; // this is finding the the removed elements.
    }
}
