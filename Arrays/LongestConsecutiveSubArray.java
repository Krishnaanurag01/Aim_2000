package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubArray {
    public static void main(String[] args) {
        int[] arr = {2,6,19,4,5,3};
        System.out.println(getLargestConsecutiveSubarray(arr, arr.length));
    }
    public static int getLargestConsecutiveSubarray(int[] arr , int n) {
        
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            // checking if previous is not present means if the element is starting point or not. if arr[i]-1 is present then it means that the current array element is not the starting number of sequence.
            if(!set.contains(arr[i]-1)){
                // now checking if next number is present or not.
                int var = arr[i]+1;
                while (set.contains(var)) {
                    var++;
                }
//                var - arr[i] will give the total length of Sequence.
                ans = Math.max(ans, var - arr[i]);
            }
        }   
        
        return ans;
    }
}
