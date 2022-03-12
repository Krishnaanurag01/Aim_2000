package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q36_Fraction_to_Recurring_Decimal {

    public String  fractionToDecimal(int numerator, int denominator)
    {

          if(numerator == 0){ // if numerator is 0 then return 0.
            return "0" ;
        }
        
        boolean isNeg = false;

        // handlelling the negative value.
        
        if(numerator < 0 && denominator < 0){
            numerator = -numerator ;
            denominator = - denominator ;
        }
        else if( numerator < 0 ){
            numerator = -numerator ;
            isNeg = true ;
        }
        else if(denominator < 0){
            denominator = -denominator ;
            isNeg = true ;
        }
        

        
        StringBuilder sb = new StringBuilder() ; // answer string.
        
        int q = numerator / denominator ; // quotient
        int r = numerator % denominator ; // remainder.
        
        sb.append(q) ;
        
        if(r == 0 ){ // if number got completly divided then this will run and equals to 0 so just return the answer.
            return (isNeg == true ? "-" :"") +sb.toString() ;
        }
        else { // else if if has some remainder then do below operation.
            // now we have to use decimal for divide completely.
            sb.append(".") ; // so adding decimal in answer.
            
            // storing remainder with the answer length as value. this will help us in identifying the repreated number.
            HashMap<Integer,Integer> map = new HashMap<>() ;
            
            while(r != 0 ){
                
                // if the current remainder has came before this means it is a recurrence number. so add the repreating number in brackets and return.
                if( map.containsKey(r)){
                    int pos = map.get(r) ; // getting the last position of repreating number.
                    sb.insert(pos,"(") ; // adding opening bracket after the last correct number.
                    sb.append(")") ; // and closing at end and returning.
                     return (isNeg == true ? "-" :"") +sb.toString() ;
                }
                else{
                    map.put(r,sb.length()) ; // alse adding remainder with sb size as value for future identifications.
                    r = r * 10 ; // adding 0 in remainder
                    
                    q = r / denominator ; // quotient
                    r = r % denominator ; // remainder
                    sb.append(q) ; // adding quotient to answer.
                }
                
            }
            
        }
        
        return (isNeg == true ? "-" :"") +sb.toString() ;
    }
}
