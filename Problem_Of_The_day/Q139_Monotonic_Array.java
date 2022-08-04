package Problem_Of_The_day ;
public class Q139_Monotonic_Array {
    
    public boolean isMonotonic(int[] nums) {
        if(nums.length <= 2) return true ;
        
        int flag = 0; // 0 -> not specified yet, -1 -> decres, 1 -> increas
            
        for(int i = 1 ; i < nums.length ; i++){
            int prev = nums[i-1] ;
            int curr = nums[i] ;
            
            if(curr > prev){ // if current is increasing
                if(flag == 0 || flag == 1){ // and previously either flag 0 (means all values were equal ) or 1 means previous vals are also in increasing fashion
                    flag = 1 ;
                }
                else{ // otherwise false.
                    return false;
                }
            }
            else if(curr < prev){
                if(flag == 0 || flag == -1){ // previous flag should be 0 or -1
                    flag = -1 ;
                }
                else{
                    return false;
                }
            }

        }
        
        return true ;
    }
}
