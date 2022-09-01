package Problem_Of_The_day ;

public class Q205_Sum_of_Digits_in_Base_K {

    public int sumBase(int n, int k) {
     
        
        // in order to convert any number to any base k, we just have to divide that number by the new base. and takee the remainder.
        int base_six = 0 ;
        
        while( n > 0 ){ // we have to divde till number is larger than 0
            int digit = n % k ;
            base_six += digit ;
            n = n/k ;
        }
        
        return base_six ;
    }

}
