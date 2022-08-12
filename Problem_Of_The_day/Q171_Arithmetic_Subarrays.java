package Problem_Of_The_day;
import java.util.*;

public class Q171_Arithmetic_Subarrays {
    
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> ans = new ArrayList<>() ;
        for(int i = 0 ; i < l.length ; i++){
            int si = l[i] ;
            int ei = r[i] ;
            if(ei - si + 1 < 2) { // if length is less than 2 then add false and skip.
                ans.add(false) ;
                continue;
            }
            
            
            // making a indivisual array of length provide by l and m array ith query.
            int[] arr = new int[ei-si + 1] ;
            int p = 0 ;
            for(int k = si ; k <= ei ; k++){
                arr[p++] = nums[k] ;
            }
            
            Arrays.sort(arr) ; 
            boolean flag = true ; // now sorting;
            
            Integer diff = null ;
            for(int s = 0 ; s < arr.length - 1; s++){
                if(diff == null){ // checking if we have no previous diff calculated then make this diff as the difff that we will consider
                    diff = arr[s+1] - arr[s] ;
                }
                else{ // now checking for every consecutive element
                    if(arr[s+1] - arr[s] != diff){
                        flag = false;
                        break;
                    }
                }
            }
            
            if(flag == true){ //if correct then add it to answer
                ans.add(true) ;
            }
            else{
                ans.add(false) ; // else this
            }
        }
        
        return ans ;
    }
}
