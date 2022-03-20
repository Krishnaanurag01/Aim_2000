package Bit_Manipulation;

public class Q34_Nth_Palindromic_Binary {

    public static int NthPalindromicBinary(int n) {

        int count = 1 ;
        int len = 1 ; 

        // getting the length and count of numbers so far of nth binary.
        while(count < n){
            len++ ;
            int elementForThisLen = ( 1 << ( len - 1 )/2) ;
            count += elementForThisLen ;
        }

        // getting the last count of len-1;
        count -= (1 << (len - 1) /2) ; // removing the last added count will get us the count of len -1.

        int offset = n - count - 1 ; // this is distance or denotes how far current element in his group of length.

        int ans = ( 1 << len - 1) ; // doing len -1 shift => 1 (for 1 that shifted) and len - 1 zero == len.

        ans |= ( offset  << (len/2) ) ; // finding the offset and adding it in first half of the answer.

        int revVal = ( ans >> ( len/2) ) ; // moving the half answer in the right end so that we can find its reverse.

        int rev = getReverse(revVal) ;

        ans |= rev ; 
        
        return ans;
    }

    static int getReverse(int n){

        int rev = 0 ;

        while(n != 0){
            int mask = (n & 1) ; // getting the first bit from right end

            rev |= mask ; // adding to rev

            n = n >> 1 ; // shifting right so that next bit of n comes in first index.
            rev = rev << 1 ; // shifting left so that we can store next bit in first place.
        }

        rev  = rev >> 1 ; // removing one extra shift that we added in rev

        return rev ;
    }
    
}
