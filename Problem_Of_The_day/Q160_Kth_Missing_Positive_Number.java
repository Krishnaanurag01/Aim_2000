package Problem_Of_The_day;

public class Q160_Kth_Missing_Positive_Number {

    public int findKthPositive(int[] arr, int k) {
        
        int left = 0 ;
        int right = arr.length - 1 ;
        int missing = getMissing(arr[right], right + 1) ; // here computing how many elements are missing till right index.
        
        while(left <= right){
            int mid = left + (right - left)/2 ;
            
            missing = getMissing(arr[mid], mid + 1) ; // finding missing count till mid
            
            if(missing >= k){ // means till mid we have enough missing so go left 
                right = mid  -1 ;
            }
            else{ // else right
                left = mid + 1 ;
            }
        }
        
        
        if(right == -1) return k ;
        
        return arr[right] + k - getMissing(arr[right], right + 1) ;
    }
    
    int getMissing(int actual, int expected){
        return actual - expected ;
    }
    
}
