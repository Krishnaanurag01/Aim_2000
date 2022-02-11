package Arrays_and_string_level_02;

public class Q12_Partition_Array_into_Disjoint_Intervals {

    // same as Q11.
    // takes O(n) extra space and O(n) time.
    public int partitionDisjoint(int[] nums) {
        
        int[] min = new int[nums.length+1] ;
        min[nums.length] = Integer.MAX_VALUE ;
        
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            min[i] = Math.min(nums[i],min[i+1]) ;
        }
        
        int left = Integer.MIN_VALUE; 
        int ans = 0 ;
        
        for(int i = 0 ; i < nums.length ;i++){
            left = Math.max(left,nums[i]) ;
            
            if(left <= min[i+1]){ // this denotes that the left element can not exhaust the i+1 min (means left is smaller) then we have to do the partiton so returing i+1 which denotes 1 based indexing length.
                ans = i+1 ;
                break ;
            }
        }
        
        return ans ;
    }



    // method 02 : // time is : O(n) and O(1) space
    public int partitionDisjoint2(int[] arr) {
       
        int leftMax = arr[0] ;
        int greater = 0 ; 
        int ans = 0 ;
        
        for(int i = 0 ; i < arr.length ; i++){
            
            if(arr[i] > greater){ // when any element is larger than greater then update it. 
                greater = arr[i] ;
            }
            
            if(arr[i] < leftMax){ // if any value less than leftMax then it means that this value will surely falls in left part becuase it is less than left max and lesser value comes before larger ones in sorted order.
                ans = i ;
                leftMax = greater ;
            }
        }
        
        // returning 1 based indexing
        return ans+1 ;
    }
}
