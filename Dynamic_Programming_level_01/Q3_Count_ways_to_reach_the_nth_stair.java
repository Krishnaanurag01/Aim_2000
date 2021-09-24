package Dynamic_Programming_level_01;

public class Q3_Count_ways_to_reach_the_nth_stair {


    public static void main(String[] args) {
        print_stair_ways(5,"");
    }


    // method : 01 

    // this is naive recursive method. time could by 2^n.
    
    public static void print_stair_ways(int n , String path) {
        if(n < 0) return ;

        if(n == 0){
            System.out.println(path);
            return ;
        }

        print_stair_ways(n-1, path+"1");
        print_stair_ways(n-2, path+"2");
    }


    // method : 02 using memoization (dp)
    
    public static int count_stair_path(int n , int[] qb) {
        if(n < 0){
            return 0 ;
        }

        if( n == 0) return 1 ;

        if(qb[n] != 0 ) return qb[n] ; // when data is already available then return.

        int oneStep = count_stair_path(n-1, qb); // took 1 step and send further.
        int twoStep = count_stair_path(n-2, qb) ; // took 2 step and send further.
        int threeStep = count_stair_path(n-3, qb) ; // took 3 step and send further.

        int total = oneStep + twoStep + threeStep ; // calculating the total step.

        qb[n] = total ; // storing to the array.

        return total ;

    }


    // method : 03 
    // tabulation way with same complexicity as method 02 .

    public static int get_total_stair_path(int n ) {
        
        if(n == 0){
            return 1 ;
        }

        int[] dp = new int[n+1] ;

        dp[0] = 1 ;

        for (int i = 1; i < dp.length; i++) {
            if(i == 1){
                dp[i] = dp[i-1];
            }
            else if(i == 2){
                dp[i] = dp[i-1] + dp[i-2] ; 
            }
            else{

                dp[i] = dp[i-1] + dp[i-2] + dp[i-3] ;
            }
        }

        return dp[n] ;
    }
}
