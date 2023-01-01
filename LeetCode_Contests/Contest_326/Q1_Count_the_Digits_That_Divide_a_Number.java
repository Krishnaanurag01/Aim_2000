package LeetCode_Contests.Contest_326;

public class Q1_Count_the_Digits_That_Divide_a_Number {

    public int countDigits(int num) {
        
        int ans = 0 ;
        int dividend = num ;
        
        while(num > 0 ){
            int digit = num % 10 ;
            if(dividend % digit == 0){
                ans++;
            }
            num = num/10;
        }
        
        return ans ;
    }
}
