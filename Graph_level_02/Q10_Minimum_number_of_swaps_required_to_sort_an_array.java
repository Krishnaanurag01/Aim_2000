package Graph_level_02;

import java.util.Arrays;
import java.util.HashMap;

public class Q10_Minimum_number_of_swaps_required_to_sort_an_array {

    public int minSwaps(int nums[])
    {
        // Code here

        int[] temp = Arrays.copyOfRange(nums, 0 , nums.length ) ;

        HashMap<Integer,Integer> map = new HashMap<>() ;

        for (int i = 0; i < nums.length; i++) {
            
            map.put(nums[i], i ) ;
        }

        Arrays.sort(temp);

        int ans = 0 ; 

        for (int i = 0; i < temp.length; i++) {
            
            if(temp[i] != nums[i]){
                ans++;

                int orignal_element = nums[i] ;

                swap(nums,i,map.get(temp[i])) ;

                map.put(orignal_element,temp[i]);
                map.put(temp[i], i ) ;

            }
        }

        return ans ;
    }

    private void swap(int[] nums, int i, Integer j ) {

        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
    
}
