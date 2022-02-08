package Arrays_and_string_level_02;

public class Q4_Majority_Element {

    public int majorityElement(int[] nums) {
        
        int mpe = getMostPotentialValue(nums) ; // fiding the most potenial value from the array.
        int freq = 0 ;
        
        // now check if the mpe has freq > n/2, if yes then return element else return -1;

        for(int i = 0 ; i < nums.length ; i++){
            if(mpe == nums[i]){
                freq++ ;
            }
                
            if(freq  > nums.length/2){
                return mpe ;
            }
        }
        
        return -1 ;
    }
    
    public int getMostPotentialValue(int[] arr){
        
        // mpe : most potential element

        int val = arr[0] ; // took arr[0] by defualt as mpe
        int freq = 1 ;
        
        for(int i = 1 ; i < arr.length ; i++){
            
            if(val == arr[i]){ // if value matches then increase the freq.
                freq++ ;
            }
            else { // else decrease the frequency
                freq-- ;
            }
            
            if(freq == 0){ // if the freq becomes 0 then take current element as mpe.
                val = arr[i] ;
                freq = 1 ;
            }
        }
        
        return val ;
    }

    
}
