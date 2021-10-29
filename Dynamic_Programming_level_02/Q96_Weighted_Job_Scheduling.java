package Dynamic_Programming_level_02;

import java.util.Arrays;
import java.util.Comparator;

// import java.util.Arrays;

public class Q96_Weighted_Job_Scheduling {

    public static void main(String[] args) {

        int[] startTime = { 1, 2, 3, 3 };
        int[] endTime = { 3, 4, 5, 6 };
        int[] profit = { 50, 10, 40, 70 };

        Max_profit(startTime, endTime, profit);
        Max_profit2(startTime, endTime, profit);

    }


    // time comp : O(n2)

    public static void Max_profit(int[] startTime, int[] endTime, int[] profit) {

        int[][] jobs = new int[startTime.length][];

        // we are binding start time , end time and profit together in an array and then
        // storing it in jobs array.
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        System.out.println(Arrays.deepToString(jobs)); /// array stucture after binding the attributes together.

        // for (int[] is : jobs) {
        // for (int e : is) {
        // System.out.print(e);
        // }
        // System.out.println();
        // }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1])); // sorting on the basis of end time which is at arr[i][1]
                                                               // index. use .reverse() if want to store in dscending
                                                               // order.

        System.out.println(Arrays.deepToString(jobs)); // after sorting array stucture.

        int[] dp = new int[jobs.length];
        dp[0] = jobs[0][2]; // storing first job profit by default.
        // System.out.println(dp[0]);

        for (int i = 1; i < jobs.length; i++) { // now running loop from 1 to n-1.
            int include = jobs[i][2]; // including current profit.

            int lastIndex = -1; // this will contain the index of last element whose endtime is lesser than
                                // current job start time.
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j][1] <= jobs[i][0]) {
                    lastIndex = j;
                    break;
                }
            }

            if (lastIndex != -1) { // if last index is changed then add value with include.
                include += dp[lastIndex];
            }

            dp[i] = Math.max(include, dp[i - 1]); // check max between include and exclude(dp[i-1]).
        }

        System.out.println(dp[jobs.length - 1]);
    }






    // using binary search in the inside of first loop.

    // time comp : O(n Logn)

    public static void Max_profit2(int[] startTime, int[] endTime, int[] profit) {

        int[][] jobs = new int[startTime.length][];

        // we are binding start time , end time and profit together in an array and then
        // storing it in jobs array.
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        System.out.println(Arrays.deepToString(jobs)); /// array stucture after binding the attributes together.


        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1])); // sorting on the basis of end time which is at arr[i][1]
                                                               // index. use .reverse() if want to store in dscending
                                                               // order.

        System.out.println(Arrays.deepToString(jobs)); // after sorting array stucture.

        int[] dp = new int[jobs.length];
        dp[0] = jobs[0][2]; // storing first job profit by default.
        // System.out.println(dp[0]);

        for (int i = 1; i < jobs.length; i++) { // now running loop from 1 to n-1.
            int include = jobs[i][2]; // including current profit.

            int lastIndex = -1; // this will contain the index of last element whose endtime is lesser than
                                // current job start time.



                                // applying binary search here.
            int low = 0 ;
            int high = i-1 ;

            while (low <= high) {
                int mid = ( low + high )/2 ;

                if(jobs[mid][1] <= jobs[i][0]){
                    lastIndex = mid ;
                    low = mid + 1 ;
                }
                else{
                    high = mid - 1 ;
                }
            }



            if (lastIndex != -1) { // if last index is changed then add value with include.
                include += dp[lastIndex];
            }

            dp[i] = Math.max(include, dp[i - 1]); // check max between include and exclude(dp[i-1]).
        }

        System.out.println(dp[jobs.length - 1]);
    }

    
}
