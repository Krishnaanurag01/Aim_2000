package Super_Important;
import java.util.*;

public class Q4_Reverse_Pairs {
    
    public int reversePairs(int[] nums) {
        
        return divide(nums, 0, nums.length - 1) ;
    }
    
    int divide(int[] nums, int low, int high){
        if(low >= high) return 0 ;
        int mid = (low + high)/2 ;
        int count = divide(nums, low, mid);
        count += divide(nums, mid+1, high);
        count += merge(nums, low, mid, high);
        return count;
    }
    
    int merge(int[] nums, int low, int mid, int high){
        int count = 0 ;
        int i = low ;
        for(int j = mid + 1 ; j <= high ; j++){    
            while(i <= mid && (long)nums[j]*2 >= nums[i]){
                i++ ;
            }
            
            count += (mid - i + 1) ;
        }
        
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
