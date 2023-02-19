package Problem_Of_The_day;

public class Q362_Apple_Sequences {
    
    public static int appleSequence(int n, int m, String arr){
       
        // aquire and release strategy is used here.
        
        int left = -1 ; /// release from left
        int right = -1 ; // aquire from right
        int ans = 0 ;
        int zero = 0 ; // count of "O"
        
        while(right < n - 1){
            right++ ;
            if(arr.charAt(right) == 'O') zero++ ;
            if(zero > m ){ // when count of zero becomes greater then start releasing from left
                while(zero > m && left < n - 1){
                    left++ ;
                    if(arr.charAt(left) == 'O') zero--;
                }
            }
            ans = Math.max(ans, right - left) ;
        }
        
        return ans ;
     }
}
