package Problem_Of_The_day;

public class Q144_Valid_Perfect_Square {

    public boolean isPerfectSquare(int num) {
        
        long low = 1 ;
        long high = num ;
        
        while(low <= high){
            long mid = low + (high - low)/2 ;
            
            if(mid * mid == num) return true ;
            else if(mid * mid < num){
                low = mid + 1 ;
            }
            else{
                high = mid -1 ;
            }
        }
        
        
        return false;
    }
}
