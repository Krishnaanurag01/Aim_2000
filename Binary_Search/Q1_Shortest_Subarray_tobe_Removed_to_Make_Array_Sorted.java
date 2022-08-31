package Binary_Search;
import java.util.*;

public class Q1_Shortest_Subarray_tobe_Removed_to_Make_Array_Sorted {

    // method 01 : using binary search in it.
    public int findLengthOfShortestSubarray(int[] arr) {
        
        if(arr.length == 1) return  0;
        
        ArrayList<Integer> left = new ArrayList<>() ; // storing sorted element from left side of arr.
        left.add(arr[0]) ; // first element is always sorted so store by default.
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] >= left.get(left.size() - 1)){
                left.add(arr[i]) ;
            }
            else break ;
        }
        
        ArrayList<Integer> right = new ArrayList<>() ; // storing sorted element from right side of arr.
        right.add(arr[arr.length - 1]) ; // last element is always sorted so store by default.
        for(int i = arr.length - 2 ; i >= 0 ; i--){
            if(arr[i] <= right.get(0)){
                right.add(0,arr[i]) ; // adding in first as it willmake sequence in increasing order.
            }
            else break ;
        }
        
        
        if(left.size() == arr.length || right.size() == arr.length) return 0 ;// means already sorted
        
        int result = Math.min(arr.length - left.size(), arr.length - right.size() ) ;
        
        for(int i = 0 ; i < left.size() ; i++){
            int other = helper(right,left.get(i)) ; // here we will find the first value in right that is greater than or equal to current ith value of left :- we are doing this becuase we are assuming that we can merge right after the current ith value. and rest of the value that is a subarray that be removed.
            // this returns index of rights.
            // System.out.println(i + " - " + other) ;
            
            if(other == -1) other = right.size() ; // means we could not found any value in right side, so making other as right size -> essey jab hum size nikalenge right subarray ka to 0 aayega
            
            int sizeOfMergedArray = ( (i+1) + right.size() - other); 
            // System.out.println(sizeOfMergedArray) ;
            result = Math.min(result, arr.length - sizeOfMergedArray) ;
        }
        
        return result ;
    }
    
    
    int helper(ArrayList<Integer> list, int target){ // find value greater than or equal to target.
        
        int low = 0 ;
        int high = list.size() - 1 ;
        
        while(low <= high){
            int mid = low+ (high-low)/2 ;
            
            if(list.get(mid) < target){
                low = mid + 1;
            }
            else{
                high = mid - 1 ;
            }
        }
        
        
        return low >= 0 && low < list.size() ? low : -1 ;
    }
    




    /// method 02:  using two pointers.

    public int findLengthOfShortestSubarray2(int[] arr) {
        if(arr.length  == 1) return  0 ;
        int n = arr.length ;
        int start = 1 ; // as first element is always sorted so starting from 2nd
        int end = n - 2; // as last element is always sorted for an array that starts from last so strats from n-2
        
        while(start < arr.length && arr[start] >= arr[start-1] ) start++ ;
        if(start == n) return 0 ;// when array is already sorted.
        start-- ; // as we increment one extra.
        
        while(end >= 0 && arr[end] <= arr[end+1]) end-- ;
        if(end == -1) return 0 ;// when array is already sorted.
        end++ ; // as we incremented one extra.
        
        int ans = Math.min( n - (start + 1) , end ) ; // intial answer. it helps in case one of the array is empty.
        
        int begin = 0 ;// now placing first pointer at begin. and second at end.
        while( begin <= start && end <= n-1){
            if(arr[begin] > arr[end]){// search smaller or equal end.
                end++;
            }
            else{
                ans = Math.min(ans, end - begin - 1 ) ; // choosing min between previous ans and current subarray that need to be removed.
                begin++;
            }
        }
        
        return ans ;
    }
}