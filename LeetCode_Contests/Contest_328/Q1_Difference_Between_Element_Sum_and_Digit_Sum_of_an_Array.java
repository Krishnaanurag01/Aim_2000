package LeetCode_Contests.Contest_328;

public class Q1_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum = 0;

        for (int val : nums) {
            sum += val;

            while (val > 0) {
                digitSum += val % 10;
                val = val / 10;
            }
        }

        return Math.abs(sum - digitSum);
    }
}
