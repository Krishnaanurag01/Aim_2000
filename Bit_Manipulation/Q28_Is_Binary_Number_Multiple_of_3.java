package Bit_Manipulation;

public class Q28_Is_Binary_Number_Multiple_of_3 {

    int isDivisible(String s) {
        // code here
        
        int odd = 0 ;
        int even = 0 ; 
        
        // adding the ascii bit in odd and even int.
        for(int i = 0 ; i < s.length() ; i++ ){
            int bit = s.charAt(i) - '0' ;
            
            if(i % 2 == 0)
            {
                even += bit ;
            }
            else{
                odd += bit ;
            }
        }
        
        // System.out.println(odd + " - " + even) ;
        int delta = even - odd ; 
        
        // now checking if the delta that is formed by the substraction of even - odd bits is divisible by 3(that is 011 in binary)
        if(delta % 3 == 0){ // if yes then return true
            return 1 ;
        }
        
        
        return 0 ;
    }
    
}
