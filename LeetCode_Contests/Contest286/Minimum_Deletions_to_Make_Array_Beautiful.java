package LeetCode_Contests.Contest286;

public class Minimum_Deletions_to_Make_Array_Beautiful {
    
    public int minDeletion(int[] nums) {
        
        int n = nums.length ;
        int del = 0 ; // counted of deleted element. it will also denote that our arr[i]th element is shifted at i-del . 
        
        for(int i = 0 ; i < nums.length - 1 ; i++){
            
            int idx = i - del ; // so finding the shifted index. it will be same as i when no deletion done.
            
            if(idx % 2 == 0 && nums[i+1] == nums[i] ){ // checking if idx is even then next adjecent element is equal or not if it is equal then delete
                del++ ;
            }
        }
        
        if( (n - del) % 2 != 0 ) // if after deletion the size of array becomes odd then delete last.
            del++ ;
       
           
        return del  ;
        
    }

}
