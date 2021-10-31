package Dynamic_Programming_level_02;

import java.util.Arrays;
import java.util.Scanner;



public class Q106_Maximum_Length_of_Pair_Chain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;

        int[][] pairs = new int[n][2] ;

        for (int i = 0; i < pairs.length; i++) {
            pairs[i][0] = sc.nextInt() ;
            pairs[i][1] = sc.nextInt() ;
        }

       System.out.println( get_max_length_pair(pairs) );
        sc.close();
        
    }


    // same question Q86. Explained there!!
    public static int get_max_length_pair(int[][] pairs) {
        
        Arrays.sort(pairs , (a,b) -> (a[0] - b[0]));

        int[] dp = new int[pairs.length];



        dp[0] = 1 ;
        for (int i = 1 ; i < pairs.length; i++) {
            int max = Integer.MIN_VALUE ;
            for (int j = 0; j < i ; j++) {
                if(pairs[j][1] < pairs[i][0]){
                    max = Math.max(max, dp[j]) ;
                }
            }

            if( max != Integer.MIN_VALUE ){
                dp[i] = max + 1 ;
            }
            else{
                dp[i] = dp[i-1] ;
            }
        }


        return dp[pairs.length-1] ;
    }
    
}
