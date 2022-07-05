package Problem_Of_The_day;

import java.util.*;

public class Q78_Longest_Consecutive_Sequence {

    // approch 01 : using map.

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int ans = 1;
        int count = 1;
        HashMap<Integer, Integer> map = new HashMap<>(); // we will store count till nums[i] element
        map.put(nums[0], 1);

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val - 1)) { // if prev element present then obtain it's count and update the count for
                                            // current element
                count = map.get(val - 1);
                count++;
                map.put(val, count);
            } else { // else store with count 1
                map.put(val, 1);
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }

    // appproch 2 : using set.

    public int longestConsecutive2(int[] nums) {

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>(); // storing first in set for removing duplicacy
        for (int val : nums)
            set.add(val);

        nums = new int[set.size()]; // and making a new non redundant array
        int k = 0;
        for (int val : set)
            nums[k++] = val;

        Arrays.sort(nums);  // sorting it and check count in sequence.
        int ans = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }


    // approch 3 : without sorting.

    public int longestConsecutive3(int[] nums) {
        Set<Integer> set = new HashSet<>();
       int ans = 0;
       int n = nums.length;
       for (int i = 0; i < n; i++) {
           set.add(nums[i]);
       }
       for (int i = 0; i < n; i++) {
           // checking if previous is not present means if the element is starting point or not. if arr[i]-1 is present then it means that the current array element is not the starting number of sequence.
           if(!set.contains(nums[i]-1)){
               // now checking if next number is present or not.
               int var = nums[i]+1;
               while (set.contains(var)) {
                   set.remove(var) ;
                   var++;
               }
//                var - arr[i] will give the total length of Sequence.
               ans = Math.max(ans, var - nums[i]);
           }
       }   
       
       return ans;
   }
}
