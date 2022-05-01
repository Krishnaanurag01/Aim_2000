package Dynamic_Programming_extras;

public class Q66_Count_Numbers_with_Unique_Digits {

    public int countNumbersWithUniqueDigits(int n) {
        
        if(n == 0) return 1; // when 10^0 only 0 digit is answer so count is 1
        
        // when n is >= 1
        int ans = 10 ; // when n is 1 -> all single digit + 0
        int start = 9 ;
        int current = 9;

        while(n-- > 1){
            current = (start*current) ;
            start-- ;
            ans += current ;
        }
        
        return ans ;
    }
}
