package Problem_Of_The_day;

public class Q278_Base_Equivalence {

    
    String baseEquiv(int n, int m)
    {
        // using binary search.
        int low = 2 ;
        int high = 32 ;
        
        while(low <= high){
            int mid = (low + high)/2 ;
            
            /// now convert n with base mid
            int temp = getDigit(n,mid) ; // gives count of digit after conversion
            if(temp == m) return "Yes" ;  //  if it is m then yes
            
            if(temp < m){ // if digits are less then try with lesser base
                high = mid - 1 ;
            }
            else{ // otherwise try with higher base.
                low = mid + 1 ;
            }
        }
        
        return "No" ;
    }
    
    // function that convert a number with base and gives count of digit in new number.
    int getDigit(int n, int base){
        
        int count = 0 ;
        
        while(n > 0){
            
            // int digit = n % base ;
            count++ ;
            n = n / base ;
        }
        
        return count ;
    }
}
