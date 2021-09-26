package Dynamic_Programming_level_02 ;

import java.util.ArrayDeque;

/**
 * Q12_Print_All_Longest_Increasing_Subsequences
 */
public class Q12_Print_All_Longest_Increasing_Subsequences {

    public static void main(String[] args) {
        
    }



    static class pair{

        int length ;
        int index ;
        int value ;
        String path ;

        pair(int length , int index , int value, String s){
            
            this.length = length ;
            this.index = index ;
            this.value = value ;
            this.path = s ;
        }
    }


    public static void print_LIS(int[] arr) {


        int n = arr.length ;



        // this part is same as Q11.
        int[] dp = new int[n] ;

        int ans = 0 ;

        for (int i = 0; i < dp.length; i++) {
            
            int max = 0 ;

            for (int j = 0; j < i ; j++) {
                if(arr[j] < arr[i]){
                    max = Math.max(max, dp[j]) ;
                }
            }

            dp[i] = max + 1 ;
           if( dp[i] > ans){
               ans = dp[i] ;
           }
        }

        System.out.println( ans );

        ArrayDeque<pair> queue = new ArrayDeque<>() ;

        for (int i = 0; i < dp.length; i++) {
            
            if(ans == dp[i]){

                queue.add(new pair(ans, i ,arr[i], arr[i]+"")) ;
            }
        }

        while (queue.size() > 0 ) {

            pair rp = queue.removeFirst() ;

            if(rp.length == 1){
                System.out.println(rp.path);
            }
            else{

                for (int i = rp.index ; i >= 0  ; i--) {
                    
                    if(dp[i] == rp.length-1 && arr[i] < rp.value){
                        queue.add( new pair(dp[i],i , arr[i],arr[i] + " -> "+ rp.path)) ;
                    }
                }
            }
            
        }
    }
}