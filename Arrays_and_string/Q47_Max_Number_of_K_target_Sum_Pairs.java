package Arrays_and_string;
import java.util.*;

public class Q47_Max_Number_of_K_target_Sum_Pairs {
    
    public int maxOperations(int[] nums, int k) {
     
        Arrays.sort(nums) ;
        return twoSum(nums,k) ;
    }
    
     public int twoSum(int[] arr , int k ){
        
         int i = 0 ;
        int j = arr.length - 1 ;
         int count = 0 ;
        
        while(i < j){
             
            int total = arr[i] + arr[j] ;
            
            if(total == k){
               
                                  
               count++ ;
                 
                 i++ ;
                j-- ;
            }
            else if(total < k){
                i++ ;
            }
            else{
                j-- ;
            }
        }
         
         return count ;
    }
}
