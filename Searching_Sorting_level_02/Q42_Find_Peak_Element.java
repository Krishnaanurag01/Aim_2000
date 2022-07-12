package Searching_Sorting_level_02;

public class Q42_Find_Peak_Element {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid - 1 >= 0) { // if left side elements present

                if (nums[mid - 1] < nums[mid]) { // and left side element is smaller than current
                    if (mid + 1 < nums.length) {  // then if right side element is also and it is also smaller or not
                        if (nums[mid + 1] < nums[mid]) // if yes then current element is peak
                            return mid;
                        else // otherwise we will move right side because theres better chance of finding peak element as right element is already greater to its left
                            low = mid + 1;
                    } else
                        return mid; // if right side is not present then return e=idx as answer
                } else
                    high = mid - 1; // else we will move to left side
            } else if (mid + 1 < nums.length) {

                if (nums[mid + 1] < nums[mid]) {
                    if (mid - 1 >= 0) {
                        if (nums[mid - 1] < nums[mid])  // when both side is small then return current 
                            return mid;
                        else
                            high = mid - 1; 
                    } else
                        return mid;// if only one side is present and that is small then return current
                } else
                    low = mid + 1;
            } else
                return mid;
        }

        return -1;
    }
}
