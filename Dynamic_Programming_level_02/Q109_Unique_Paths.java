package Dynamic_Programming_level_02;

import java.util.*;

public class Q109_Unique_Paths {

    // using memoization

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1]; 

        for (int[] arr : dp) 
            Arrays.fill(arr, -1); // storing -1 for identification

        return getMazePaths(1, 1, m, n, dp);
    }

    public static int getMazePaths(int sr, int sc, int dr, int dc, int[][] dp) {

        if (sr == dr && sc == dc) { // when reach destination return 1

            return 1;
        }

        if (sr > dr || sc > dc) { // when out of bound return 0

            return 0;
        }

        // if already solved then return answer.
        if (dp[sr][sc] != -1) {
            return dp[sr][sc];
        }

        // calculate for right 
        int hori = getMazePaths(sr, sc + 1, dr, dc, dp);

        // calculate for vertical
        int verti = getMazePaths(sr + 1, sc, dr, dc, dp);

        // return the combination
        return dp[sr][sc] = hori + verti;
    }
}
