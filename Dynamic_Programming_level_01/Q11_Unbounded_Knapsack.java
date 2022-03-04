package Dynamic_Programming_level_01;

public class Q11_Unbounded_Knapsack {

    public static void main(String[] args) {

        int[] val = {1, 1} ;
        int wt[] = {2, 1} ;

        System.out.println( get_unbounded_knapsack_max(val, wt, 3));
    }

    // Expected Time Complexity: O(N*W)
    // Expected Auxiliary Space: O(W)

    public static int get_unbounded_knapsack_max(int[] val, int[] wt, int capacity) {

        int[] dp = new int[capacity + 1]; // making dp of the capactity which will store the max value of every weight
                                          // capacity.

        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) { // here i represents every weight of dp.

            for (int j = 0; j < wt.length; j++) { // and j represent the wt and val array.

                if (i >= wt[j] ) { // here we check if the weight of dp( i ) is greater of equal to our
                                                    // wt[j] and i - wt[j] >= 0 ( this is used in second line thats why
                                                    // given here.)
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]); // we are storing the max value by checking if
                                                                     // current val is max or if we use current weight
                                                                     // value then check dp weight - current weight
                                                                     // value.
                }

            }
        }

        return dp[capacity];

    }
}
