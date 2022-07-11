package Problem_Of_The_day;

import java.util.*;

public class Q85_Reaching_the_heights {

    // simply sort the array and choose left side element(smallest) for down stairs and take right side element(largest) for upstairs.

    public static ArrayList<Integer> reaching_height(int n, int arr[]) {
        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();

        if (arr.length <= 1) {
            ans.add(arr[0]);
            return ans;
        }
        int up = 0;
        int down = 0;

        for (int i = n - 1, j = 0; i >= j; i--, j++) {
            if (i == j) {
                ans.add(arr[i]);
                up += arr[i];
                down += arr[i];
                continue;
            }
            up += arr[i];
            ans.add(arr[i]);
            ans.add(arr[j]);
            down += arr[j];
        }

        if (up <= down) {
            ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        }

        return ans;
    }
}
