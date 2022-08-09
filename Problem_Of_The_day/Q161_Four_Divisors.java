package Problem_Of_The_day;

public class Q161_Four_Divisors {

    public int sumFourDivisors(int[] nums) {   
        
        int sum = 0 ;
        for(int val : nums){
            int temp = 0; // here we will sum of all divisor of val 
            int count = 0 ; // and counting the divisor of val
            for(int i = 1 ; i * i <= val ; i++){
                if(val % i != 0) continue ;
                int secondMultiplier = val / i ; // i * x -> x is secondMultiplier
                if(secondMultiplier == i){ // if both i and x is same then count only once
                    count++ ;
                    temp += i ;
                }
                else{ // if both the multipier is different then consider both
                    count += 2 ;
                    temp += i + secondMultiplier ;
                }
                if(count > 4) break ; // if count gets greater than 4 then break 
            }
            
            if(count ==  4){ // if count of divisor is 4 then add it's divisor sum into the ans sum
                sum += temp ;
            }
        }
        
        return sum ;
    }
}
