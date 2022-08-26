package Problem_Of_The_day;
import java.util.*;
public class Q190_Reordered_Power_of_2 {
    
    public boolean reorderedPowerOf2(int n) {  
        //instead of swapping and reordering we can simple check for each power of 2.
        // step1 : create map of original number.
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int nSize = String.valueOf(n).length() ; // this is the length of original number.
        
        while( n > 0){
            int digit = n % 10 ;
            n = n/10 ;
            map.put(digit, map.getOrDefault(digit,0)+1) ;
        }
        
        // step 2 : run for each power of 2 until the this power of 2 gives larger value than n. then stop.
        int pow = 0 ;
        
        while(true){
            int num = (int)Math.pow(2,pow) ;
            int size2 = String.valueOf(num).length() ;
            
            // step 2.1 : now create map of this power of 2. 
            
            HashMap<Integer,Integer> powMap = new HashMap<>() ;
            while( num > 0){
                int digit = num % 10 ;
                num = num / 10 ;
                powMap.put(digit, powMap.getOrDefault(digit,0)+1) ;
            }
            
            // and check wheather we are holding all the values that are present in orignal number or not.
            if(map.equals(powMap)) return true; //if yes then the orignal number can be reordered to get this power of 2.
            if(size2 > nSize) return false;  // if we are getting the larger length values then return false.
            pow++;
        }
        
    }
}
