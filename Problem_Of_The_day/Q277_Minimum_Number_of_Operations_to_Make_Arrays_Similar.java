package Problem_Of_The_day;
import java.util.*;

public class Q277_Minimum_Number_of_Operations_to_Make_Arrays_Similar {

    public long makeSimilar(int[] nums, int[] target) {
        
        ArrayList<Integer> even = new ArrayList<>() ;
        ArrayList<Integer> even_target = new ArrayList<>() ;
        
        ArrayList<Integer> odd = new ArrayList<>() ;
        ArrayList<Integer> odd_target = new ArrayList<>() ;
        
        
        // even +- 2 = even and odd +- 2  = odd -> even and odd both will also be of same type even after multiple opr.
        
        
        // step 01 : first extract the even and odd nums and targets. 
        for(int i = 0 ; i < nums.length ; i++){
            int val = nums[i] ;
            int tar = target[i] ;
            
            if(val % 2 == 0){
                even.add(val) ;
            }
            else{
                odd.add(val) ;
            }
            
            
            if(tar % 2 == 0){
                even_target.add(tar) ;
            }
            else{
                odd_target.add(tar) ;
            }
        }
        
        // Now sort these extracted values.
        Collections.sort(even) ;
        Collections.sort(odd) ;
        Collections.sort(even_target) ;
        Collections.sort(odd_target) ;
        
        
        // now we are just chaging smaller value to target smaller, we are just finding diff between element at same index of value and target and that value is divided by 2 becuase in one operation we can add or subtract 2.
        long ans = 0 ;
        
        for(int i = 0 ; i < even.size() ; i++){
            int e = even.get(i) ;
            int t = even_target.get(i) ;
            
            // diff at same index of value and target.
            ans = ans + ((Math.abs(t - e))/2 );
        }
        
        
        // same with the odd value and target
        for(int i = 0 ; i < odd.size() ; i++){
            int e = odd.get(i) ;
            int t = odd_target.get(i) ;
            
            ans = ans + ((Math.abs(t - e))/2 );
        }
        

        // and now returning by dividing answer in 2 because in one operation we can add and subtract two diff indices
        return ans/2 ;
    }
}
