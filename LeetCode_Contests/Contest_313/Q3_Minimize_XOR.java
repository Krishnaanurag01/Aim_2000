package LeetCode_Contests.Contest_313;

public class Q3_Minimize_XOR {

    public int minimizeXor(int num1, int num2) {
        
        int mask = 0 ;
        int setbits = 0 ;
        
        // first find the count of set bits of num2 using kernighans algo
        while(num2 > 0){
            int x = num2 & -num2 ;
            setbits++ ;
            num2 -= x ;
        }
        
        
        // now in order to minimize the answer we should first eleminate the starting set bits of num1 so that the value we left will be small.
        // run untill i >= 0 and we have atleast 1 setbit
        for(int i = 31 ; i >= 0 && setbits > 0 ; i--){
            int temp = 1 << i ;
            if((temp & num1) != 0 ){ // if this pos has setbit 
                mask = mask | temp ; // then our mask will have have setbit
                setbits-- ;
            }
        }
        
        System.out.println(mask) ;
        
        // now if we have any setbits left to use then we will assign it to from smallest value where no setbit is present.
        for(int i = 0 ; i <= 31 && setbits > 0 ; i++){
            int temp = 1 << i ;
            if( (temp & num1) == 0 ){ // now set bit present so 
                mask = mask | temp ; // give here
                setbits-- ;
            }
        }
        
        // System.out.println(mask) ;
        
        return  mask ;
    }
}
