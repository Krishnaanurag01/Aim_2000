package Problem_Of_The_day;
import java.util.*;

public class Q20_Sum_of_two_elements_with_sum_nearest_to_zero {

    public static int closestToZero (int arr[], int n)
    {
        // your code here
        Arrays.sort(arr) ;
        
        int ans = Integer.MAX_VALUE ;
        
        int i = 0 , j = n -1; 
        
        
        while(i < j) {
            int x  = arr[i] + arr[j] ;
            
            if(Math.abs(x) < Math.abs(ans) ){
                ans = x ;
            }
            
            if(Math.abs(x) == Math.abs(ans) ){
                ans = Math.max(ans,x) ;
            }
            
            if(x < 0 ){
                i++ ;
            }
            else{
                j-- ;
            }
        }
        
        return ans ;
    }
    
}
