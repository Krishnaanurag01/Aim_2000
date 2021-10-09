package Dynamic_Programming_level_02;

public class Q55_Maximum_Sum_Of_Three_Non_Overlapping_Subarrays {

    public static void main(String[] args) {

    }

    public static int[] get_max_sum(int[] nums, int k) {

        int n = nums.length;

        // for three sub array,  first subarray of k length will be store in left array , same as right array for third subarray and presum for middle one.
        int[] left = new int[n];
        int[] right = new int[n];
        int[] PreSum = new int[n];

        
        // storing presum array
        for (int i = 0; i < PreSum.length; i++) {
            if (i == 0) {
                PreSum[i] = nums[i];
            } else {
                PreSum[i] = PreSum[i - 1] + nums[i];
            }
        }

        int sum = 0;

        // same as we did in previous question : for left array

        for (int i = 0; i < n; i++) {
            if (i < k) {
                sum += nums[i];
                left[i] = sum;
            } else {
                sum += nums[i] - nums[i - k];
                left[i] = Math.max(left[i - 1], sum);
            }
        }

        sum = 0;


        // same as we did in previous question : for right array

        for (int i = n - 1; i >= 0; i--) {
            if (i + k >= n) {
                sum += nums[i];
                right[i] = sum;
            } else {
                sum += nums[i] - nums[i+k];
                right[i] = Math.max(right[i + 1], sum);
            }
        }

        int max_sum = -1;
        int leftMaxSum = -1; // left max value
        int middleIndex = -1; // middle max value index
        int rightMaxSum = -1; // right max value

        for (int i = k ; i <= n - 2 * k; i++) { // now starting from k to n-k*2

            if (left[i-1] + right[i + k ] + PreSum[i + k - 1] - PreSum[i-1] > max_sum) {
                max_sum = left[i-1] + right[i + k ] + PreSum[i + k - 1] - PreSum[i-1];

                leftMaxSum = left[i-1];
                rightMaxSum = right[i + k ];
                middleIndex = i ;
            }
        }

        int[] ans = new int[3];
        // finding index for left sum.

        for (int i = k - 1; i < middleIndex; i++) {
            if (PreSum[i] - (i - k < 0 ? 0 : PreSum[i - k]) == leftMaxSum) {
                ans[0] = i - k + 1;
                break;
            }
        }

        ans[1] = middleIndex;

        for (int i = middleIndex + (2 * k) - 1; i < n; i++) {
            if (PreSum[i] - PreSum[i - k] == rightMaxSum) {
                ans[2] = i - k + 1;
                break;
            }
        }

        return ans ;

    }

}
