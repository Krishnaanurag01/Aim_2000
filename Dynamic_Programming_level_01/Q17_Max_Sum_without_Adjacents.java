package Dynamic_Programming_level_01;

public class Q17_Max_Sum_without_Adjacents {

    public static void main(String[] args) {
        
    }

    // same as house robber problem.
    // method : 01 took o(n) space and time.

    public static int max_sum(int[] arr) {
        
        if(arr == null || arr.length == 0){
            return 0 ;
        }
        
        if(arr.length == 1){
            return arr[0];
        }

        if(arr.length == 2){
            return Math.max(arr[0], arr[1]);
        }


       /// otherwise.

        // we'll make a dp array.

        int dp[] = new int[arr.length];
        dp[0] = arr[0] ; // means at this point thief can only stole money from house 0.
        dp[1] = Math.max(arr[0], arr[1]); // means thief can stole money where money is more.

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]) ; // this means as we can;t stole from adjecent houses so we'll check if we add current homes loot with the last of last house is greater or simply the last house money is greater ( as we can't stole from adjecent houses thats why not adding current house money )
        }

        return dp[dp.length-1] ;

    }


    // method : 02 ;
    // takes only o(n) time and o(1) space.

    public static int get_max_sum_non_adjacent(int[] arr) {
        
        int include = arr[0] ; // this is included.
        int exclude = 0 ; // this is excluded so sum is 0 currently.

        for (int i = 1; i < arr.length; i++) { // now starting from 1.
            
            int ninclude = exclude + arr[i] ; // new include will be last exclude + current sum.
            int nexclude = Math.max(include, exclude); // and new exclude will be max of last include and exclude.
            
            include = ninclude ; // storing new include.
            exclude = nexclude ; // storing new exclude.
        }

       return Math.max(include, exclude)  ; // returning the max answer.
    }
    
}
