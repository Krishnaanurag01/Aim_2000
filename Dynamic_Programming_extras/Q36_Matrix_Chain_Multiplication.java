package Dynamic_Programming_extras;

public class Q36_Matrix_Chain_Multiplication {

    // using memoizatioon.
    static int matrixMultiplication(int N, int arr[]) {
        Integer[][] dp = new Integer[N][N];
        return helper(1, N - 1, arr, dp); // starting from the first matrix.
    }

    static int helper(int si, int ei, int[] arr, Integer[][] dp) {

        if (si == ei)
            return 0; // beause we can't multiply a 1*0 dimention matrix.

        if (dp[si][ei] != null)
            return dp[si][ei]; // returning stored result

        int min = (int) 1e9;
        for (int k = si; k < ei; k++) { // partitoning the array .
            min = Math.min(min, arr[si - 1] * arr[k] * arr[ei] + helper(si, k, arr, dp) + helper(k + 1, ei, arr, dp));
        }

        return dp[si][ei] = min;
    }

    // converting the memoization into tabulations :

    static int matrixMultiplication2(int N, int arr[]) {
        int[][] dp = new int[N][N];

        for (int i = N - 1; i >= 1; i--) {
            for (int j = 1; j <= N - 1; j++) {

                if (i == j) { // handling the base case when si == ei
                    dp[i][j] = 0;
                    continue;
                } // beause we can't multiply a 1*0 dimention matrix.

                int min = (int) 1e9;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j]);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][N - 1];
    }
}
