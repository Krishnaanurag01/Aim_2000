package Problem_Of_The_day;

public class Q141_Peak_Index_in_a_Mountain_Array {

    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length < 3) return -1 ;
        
        int low = 0 ;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = (low+high)/2 ;
            
            if( mid == 0 ){ // if came to left most index then go right
                low = mid + 1 ;
            }
            else if(mid == arr.length - 1){ // if camee to right most index then go to left
                high = mid - 1 ;
            }
            else{
                if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid+1]) return mid; // now check if current element is greater than both it's nbr then return mid (idx) as answer
                else if(arr[mid] > arr[mid-1]){ // if it is only greater then left then move right
                    low = mid + 1 ;
                }
                else{
                    high = mid - 1 ; // else move left
                }
                
            }
        }
        
        return low ;
    }
}
