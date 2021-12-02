package Stack_and_Queue_level01;

import java.util.*;

public class Q4_Next_Greater_Element_I_leetcode {

    // using same concept as Q3 but we only storing the answer in the hashmap with the element as key so that we can get answer for nums1 arr elements.

    public int[] nextGreaterElement(int[] nums1, int[] arr) {

        Stack<Integer> stack = new Stack<>() ;

        int n = arr.length ;
        HashMap<Integer,Integer> map = new HashMap<>() ;

        stack.push(arr[n-1]) ;
        map.put(arr[n-1], -1) ;

        for (int i = arr.length - 2; i >= 0 ; i--) {
            
            while (stack.size() > 0 && stack.peek() < arr[i]) {
                stack.pop() ;
            }

            if(stack.empty()){
                map.put(arr[i], -1) ;
            }
            else{
                map.put(arr[i], stack.peek() ) ;
            }

            stack.push(arr[i]) ;
        }


        int[] ans = new int[nums1.length] ;

        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(nums1[i]) ; // fetching from map.
        }

        return ans ;
        
    }
    
}
