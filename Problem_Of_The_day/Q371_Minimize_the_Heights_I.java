package Problem_Of_The_day;
import java.util.*;

public class Q371_Minimize_the_Heights_I {

    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr) ;
        
        int max = arr[n-1] ;
        int min = arr[0] ;
        int ans = max - min ;
        
        for(int i = 1; i < n ; i++){
            max = Math.max(arr[i-1] + k , arr[n-1] - k) ; // hum chotey wale ko maximize kar rhe
            min = Math.min(arr[i] - k , arr[0] + k) ; // aur bade wale ko minimize kar rhe
            ans = Math.min(max-min, ans) ;
        }
        
        return ans ;
    }
}
