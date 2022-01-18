package Arrays_and_string;
import java.util.*;

public class Q45_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums) ;
        
        List<List<Integer>> ans = new ArrayList<>() ;
        
        for(int i = 0 ; i < nums.length-2 ; i++){
            
            twoSum(nums,i+1,nums[i],ans) ;
            
        }
        
        return ans ;
        
        
    }
    
    HashSet<String> set = new HashSet<>() ; // this will be used to identify the 3sum pair, whether same combination is used or not.
    
    
    public void twoSum(int[] arr, int i , int firstVal, List<List<Integer>> ans){
        
        int j = arr.length - 1 ;
        
        while(i < j){
            int total = arr[i] + firstVal + arr[j] ;
            
            if(total == 0){ // when the total becomes 0 then we do the following operations.
                StringBuilder sb = new StringBuilder() ; 
                sb.append(firstVal) ;
                sb.append(arr[i]) ;
                sb.append(arr[j]) ;
                
                String na = sb.toString() ; // this string is used as identity .
                
                if(!set.contains(na)) // if the indentiy string is not present in the set it means we didn't have this combination of element before so adding to the answer list and also adding identity combination string of this  three element to hashset so that when same comobination comes again then we'll not add it in the answer.
                {
                                  
                List<Integer> in = new ArrayList<>() ;
                in.add(firstVal) ;
                in.add(arr[i]) ;
                in.add(arr[j]) ;
                
                ans.add(in) ;
                    set.add(na) ;
                }
                 i++ ;
                j-- ;
            }
            else if(total < 0){
                i++ ;
            }
            else{
                j-- ;
            }
        }
    }
    
}
