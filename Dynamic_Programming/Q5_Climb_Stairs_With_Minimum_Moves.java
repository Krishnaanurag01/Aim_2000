package Dynamic_Programming;

import java.util.* ;

public class Q5_Climb_Stairs_With_Minimum_Moves {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int[] moves = new int[n] ;

        for (int i = 0; i < moves.length; i++) {
            moves[i] = sc.nextInt() ;
        }

        System.out.println(climb_stairs_with_min_moves(moves , moves.length));
        sc.close();

    }

    public static int climb_stairs_with_min_moves(int[] moves, int n) {
        
        Integer[] dp = new Integer[n + 1] ;

        dp[n] = 0 ; // as there is 1 path to reach end from end ( that is stay wherever you are) and 0 moves so 0 stored.

        // as last elememt need minimum moves to reach end so starting from end.

        for (int i = n - 1 ; i >= 0 ; i--) {

            if(moves[i] > 0){  // when our arr value is greater than 0 then run.

            int min = Integer.MAX_VALUE ;  // giving identity element of min value.

            for (int j = 1 ; j <= moves[i] && i+j < dp.length; j++) {  // now running from 1 to moves[i] ( start from 1 not 0 becuase when we add 0 with 1 then we end up at the same place.)

                if( dp[i+j] != null){  // if not null then find min value.

                    min = Math.min(min, dp[i+j]) ;
                }
            }

            if(min != Integer.MAX_VALUE) {  // when our min value is changed then put this .
                dp[i] = min + 1 ;
            }
            // else we already have null value by default.

        }
            
        }

       System.out.println(dp[0]);
       return 0 ;
    }
    
}
