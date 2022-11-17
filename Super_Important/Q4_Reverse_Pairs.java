package Super_Important;
import java.util.*;

public class Q4_Reverse_Pairs {
    
    public int reversePairs(int[] nums) {
        
        // it uses merge sort.
        
        return divide(nums, 0, nums.length - 1) ;
    }
    
    // first divide part of merge sort
    int divide(int[] nums, int low, int high){
        
        if(low >= high) return 0 ; 
        int mid = (low + high)/2 ;
        int count = divide(nums, low, mid); // getting the reverse pair count in left part
        count += divide(nums, mid+1, high); // now in right part
        count += merge(nums, low, mid, high); // and now combine both and check pair count now.
        return count;
    }
    
    int merge(int[] nums, int low, int mid, int high){
        
        int count = 0 ;
        
        int i = low ; // left array start index.
        for(int j = mid + 1 ; j <= high ; j++){  // traverse on right array.  
            while(i <= mid && (long)nums[j]*2 >= nums[i]){ // if current element is lesser or equal then movee to next element of left
                i++ ;
            }
            
            // now current left element is one the answer and also the left is already sorted so all the element including current element is > 2*nums[j] so adding all element count in answer.
            count += (mid - i + 1) ;
        }
        
        // now merge the both arrays.
        ArrayList<Integer> temp = new ArrayList<>() ;
        int left = low ;
        int right = mid + 1 ;
        
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left++]) ;
            }
            else{
                temp.add(nums[right++]) ;
            }
        }
        
        
        while(left <= mid){
            temp.add(nums[left++]) ;
        }
        
        while(right <= high){
            temp.add(nums[right++]) ;
        }
        
        
        for(int x = 0 ; x < temp.size() ; x++){
            nums[x + low] = temp.get(x) ;
        }
        
        return count ;
    }
}
