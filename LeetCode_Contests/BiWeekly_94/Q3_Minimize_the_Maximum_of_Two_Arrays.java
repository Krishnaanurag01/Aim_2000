package LeetCode_Contests.BiWeekly_94;

public class Q3_Minimize_the_Maximum_of_Two_Arrays {
    
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        long low = 1 ;
        long high = Integer.MAX_VALUE;
        long ans = 0 ;
       
        while(low <= high){
            long mid = low + (high - low)/2 ;

            long cu1 = mid - (mid/divisor1) ; // current unique numbers of int which can be stored in array1. we subtracting integers which are divisible by div1
            long cu2 = mid - (mid/divisor2) ; // current unique numbers of int which can be stored in array2. we subtracting integers which are divisible by div2
            long _c1c2 = mid - (mid/divisor1) - (mid/divisor2) ; // aise numbers jo dono me use nhi ho saktey. to find this subtract numbers jo array1 me use nhi ho saktey aur jo array2 me use nhi ho saktey
            
            
            _c1c2 += (mid/lcm(divisor1,divisor2)) ; // ho sakta ki humne kisi number ko do baar hatra dia (jaise 15, 3 aur 5 dono k divisiblity me aata h) to usko add karenge 1 baar.
            
            
            // agar enough number hai array1 and array2 k liy and total numbers for both array are enough then update answer and look for mininal max ans.
            if(uniqueCnt1 <= cu1 && uniqueCnt2 <= cu2 && cu1 + cu2 - _c1c2 >= uniqueCnt1 + uniqueCnt2){
                ans = mid ;
                high = mid - 1;
            }
            else{
                low = mid + 1 ;
            }
        }
        
        return (int)ans;
    }
    
    long lcm(long val1, long val2){
        long gcd = GCD(val1, val2) ;
        return (1L*val1*val2)/gcd ;
    }
    
    long GCD(long a, long b){
        if(b == 0) return a ;
        return GCD(b, a % b) ;
    }
}
