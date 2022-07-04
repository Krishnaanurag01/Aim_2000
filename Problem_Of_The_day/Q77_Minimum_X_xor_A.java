package Problem_Of_The_day;

public class Q77_Minimum_X_xor_A {

    public static int minVal(int a, int b) {
       
        int csb = 0 ; // count of set bits in b.
        
        while( b != 0){
            int rsb = b & -b ;
            csb++ ;
            b -= rsb ;
        }
        
        int csb2 = 0 ; // count of set bits in a.
        int m = a;
        
        while( m != 0){
            int rsb = m & -m ;
            csb2++ ;
            m -= rsb ;
        }
        
        int extra = 0 ;
        if(csb2 < csb){// if the set bits in b is more and we have to find element with more set bits than a then 
            extra = csb - csb2; // finding how much extra set bits needed.
        }
        
        int num = 0 ;
        
        if(extra > 0){ // if we need element with extra bits than a then this executes.
            num = a ;
            for(int i = 0 ; i < 32 && extra > 0 ; i++){ // we will assign extra set bits from right most side where we will find 0
                if(( num & (1 << i) ) == 0 ){
                    extra--;
                    num = num | (1 << i) ;
                }
            }
        }
        else{ // if need element with less or equal set bits than a then this runs.
           num = 0 ;
           for(int i = 31 ; i >= 0 && csb > 0 ; i--){ // in this we will assign set bits from left where a(given) has set bits as well so that we will be able to eliminate the larger numbers.
               if( (a & (1 << i)) != 0 ){
                   num = num | (1 << i) ;
                   csb-- ;
               } 
           }
        }
        
        return num ;
     }
    
}