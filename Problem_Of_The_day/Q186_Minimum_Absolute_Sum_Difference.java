package Problem_Of_The_day ;
import java.util.*;


public class Q186_Minimum_Absolute_Sum_Difference {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int maxDecrease = 0;
           int len = nums1.length;
           long sum = 0;
           int mod = (int)Math.pow(10,9) + 7;
           TreeSet<Integer> treeSet = new TreeSet<>();
           for (int num : nums1)
               treeSet.add(num);
           
           for (int i = 0; i < len; i++) {
               sum = sum + Math.abs(nums1[i] - nums2[i]);
               if (nums1[i] != nums2[i]) {
                   // use binary search to find the replacement value to minimize the abs diff for current nums2[i]
                   Integer ceil = treeSet.ceiling(nums2[i]);
                   Integer floor = treeSet.floor(nums2[i]);
                   int diff = Math.abs(nums1[i] - nums2[i]);
                   int max = 0;
                   if (ceil != null) {
                       int val1 = Math.abs(ceil - nums2[i]);
                       max = Math.max(max, diff - val1);
                   }
                   if (floor != null) {
                       int val2 = Math.abs(floor - nums2[i]);
                       max = Math.max(max, diff - val2);
                   }
                   //find the biggest delta across the entire array
                   //the delta is diff = orginal diff - diff after replacement
                   maxDecrease = Math.max(max, maxDecrease);
               }
           }
           return (int)((sum - maxDecrease) % mod);
       }
}
