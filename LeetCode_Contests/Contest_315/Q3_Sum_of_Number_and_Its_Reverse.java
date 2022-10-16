package LeetCode_Contests.Contest_315;

public class Q3_Sum_of_Number_and_Its_Reverse {

    public boolean sumOfNumberAndReverse(int num) {

        for(int i = 0 ; i <= num ; i++){
            int reverse = 0 ;
            int val = i ;
            while(val > 0){
                int digit = val % 10 ;
                reverse = reverse * 10 + digit ;
                val = val / 10 ;
            }
            
            if(reverse + i == num) return true ;
        }
        
        return false;   
    }
}
