package Problem_Of_The_day;
import java.util.*;

public class Q155_Add_to_Array_Form_of_Integer {

    public List<Integer> addToArrayForm(int[] num, int k) {
        
        List<Integer> list = new ArrayList<>() ;
        
        int carry = 0 ;
        for(int i = num.length - 1; i >= 0 ; i--){
            num[i] += carry ;
          
            if( k > 0){
                int ld = k % 10 ;
                k = k/10 ;
                num[i] += ld ;
            }
            
            carry = num[i]/10 ;
            num[i] = num[i] % 10;
        }
       
        
        while(k > 0){
            int ld = k % 10 ;
            k = k/10 ;
            int val = ld + carry ;
            list.add(0,val % 10) ;
            carry = val / 10 ;
        }
        
         if(carry != 0){
            list.add(0,carry) ;
        }
        
        for(int val : num){list.add(val);}
        return list;
    }
}
