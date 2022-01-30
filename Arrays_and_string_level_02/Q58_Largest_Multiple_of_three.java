package Arrays_and_string_level_02;
import java.util.*;

public class Q58_Largest_Multiple_of_three {

    public String largestMultipleOfThree(int[] digits) {
        
        int sum = 0 ;
        int n = digits.length ;
        
        for(int i = 0 ; i < n ; i++){
            sum += digits[i] ;
        }
        
        Arrays.sort(digits) ;
        
        if(sum % 3 == 0){
            
            // if(sum == 0) return "0" ; // when array consist of only 0 then return one zero only.
            if(digits[n-1] == 0) return "0" ;
            
            // StringBuilder sb = new StringBuilder() ;
            String s = "" ;
            for(int p = n - 1 ; p >= 0 ; p--){
                // sb.append(digits[p]) ;
                s += ""+digits[p] ;
            }
            
            // return sb.toString(); 
            return s ;
        }
        else if(sum % 3 == 1){ // then we have to delete element that gives 1 remainder.
            // check if array contains element that gives 1 remainder
            
            boolean check_Potential = false ;
            
            for(int p = 0 ; p < digits.length ; p++){
                if(digits[p] % 3 == 1){
                    check_Potential = true ;
                    digits[p] = -1 ;
                    break ;
                }
            }
            
            // System.out.println("1's cp" + check_Potential) ;
            
            if(!check_Potential){
                    System.out.println("1's cp" + check_Potential) ;

                // check if we have two elements that has remainder 2. if we found then it means, removing those two element will make our sum multiple of 3 becuase both the 2 remainder equal => 4 and 4 % 3 gives 1 remainder so we have to remove both the elements
                
                int[] index = new int[2] ;
                index[0] = -1 ;
                index[1] = -1 ;
                
                for(int p = 0 ; p < digits.length ; p++){
                    if(digits[p] % 3 == 2){
                        
                        if(index[0] == -1){
                            index[0] = p ;
                        }
                        else{
                            index[1] = p ;
                            break ;
                        }   
                    }
                }
                
                if(index[1] != -1) { // if index[1] is not -1 then it means we got both the element that gives remainder 2.
                    
                    digits[index[0]] = -1 ;                    
                    digits[index[1]] = -1 ;

                }
                else{
                    return "" ;
                }
            }   
        }
        else if(sum % 3 == 2 )
        {
               // check if array contains element that gives 2 remainder
            
            boolean check_Potential = false ;
            
            for(int p = 0 ; p < digits.length ; p++){
                if(digits[p] % 3 == 2){
                    check_Potential = true ;
                    digits[p] = -1;
                    break ;
                }
            }
            
            if(!check_Potential){
                
                // check if we have two elements that has remainder 1. if we found then it means, removing those two element will make our sum multiple of 3 becuase both the 1 remainder equal => 2 and 2 % 3 gives 2 remainder so we have to remove both the elements
                
                int[] index = new int[2] ;
                index[0] = -1 ;
                index[1] = -1 ;
                
                for(int p = 0 ; p < digits.length ; p++){
                    if(digits[p] % 3 == 1){
                        
                        if(index[0] == -1){
                            index[0] = p ;
                            // digits[p] = -1 ;
                        }
                        else{
                            index[1] = p ;
                            // digits[p] = -1 ;
                            break ;
                        }   
                    }
                }
                
                if(index[1] != -1) { // if index[1] is not -1 then it means we got both the element that gives remainder 1.
                    
                     digits[index[0]] = -1 ;                    
                    digits[index[1]] = -1 ;

                    
//                StringBuilder sb = new StringBuilder() ;
            
//                for(int p = n - 1 ; p >= 0 ; p--){
               
//                    if(digits[p] != -1)  sb.append(digits[p]) ;
                
//                }
//                  return sb.toString();     
                    
                }else{
                    return "" ;
                }
            }
            
        }
        
        // now calculating the final answer. if we didn't found any yet.
        
        StringBuilder sb = new StringBuilder() ;
        
        int onlyZero = -1  ;
        
            for(int p = n - 1 ; p >= 0 ; p--){
                 if(digits[p] != -1) {
                     sb.append(digits[p]);
                     
                     if(onlyZero == -1 && digits[p] == 0) onlyZero = 1 ;
                     if(digits[p] != 0) onlyZero = 0 ;
                 }
            }
     
        if(onlyZero == 1 ) return "0" ;
        
            
            return sb.toString(); 
        
    }
    
}
