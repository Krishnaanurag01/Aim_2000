package Problem_Of_The_day;
import java.util.*;

public class Q94_Happy_Number {
    
    public boolean isHappy(int n) {
     
        if(n <= 0 ) return false ;
        
        HashSet<Integer> set = new HashSet<>() ;
        
        while(n != 1){
            int sum = 0 ;
            while(n != 0){
                int ld = n % 10 ;
                n  = n / 10 ;
                sum += (ld*ld) ;
            }
            System.out.println(sum) ;
            
            if(set.contains(sum)) return false;
            set.add(sum) ;
            n = sum ;
        }
        
        return n == 1 ? true : false ;
    }
}
