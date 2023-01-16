package LeetCode_Contests.Contest_328;

public class Q2_Increment_Submatrices_by_One {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];

        for (int[] query : queries) {
            int si = query[0];
            int sj = query[1];
            int ei = query[2];
            int ej = query[3];

            for (int i = si; i <= ei; i++) {
                ans[i][sj] += 1;

                if (ej < n - 1) {
                    ans[i][ej + 1] -= 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] += ans[i][j - 1];
            }
        }

        return ans;
    }
}
