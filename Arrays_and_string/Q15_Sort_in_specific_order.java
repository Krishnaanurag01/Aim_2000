package Arrays_and_string;
import java.util.*;

public class Q15_Sort_in_specific_order {
    
    public void sortIt(long nums[], long n)
    {
       ArrayList<Long> even = new ArrayList<>() ;
       ArrayList<Long> odd = new ArrayList<>() ;
       
       for(long i : nums){
           if(i % 2 == 0){
               even.add(i) ;
           }
           else{
               odd.add(i) ;
           }
       }
       
       Collections.sort(odd, Collections.reverseOrder()) ;
       
       Collections.sort(even) ;
       
       int i = 0 ;
       
       while(odd.size() != 0 ){
           nums[i] = odd.remove(0) ;
           i++ ;
       }
       
       
       while(even.size() != 0 ){
           nums[i] = even.remove(0) ;
           i++ ;
       }
    }

}
