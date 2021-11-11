package Problem_Of_The_day;

public class Q8_Number_of_subarrays_with_maximum_values_in_given_range {

    public static void main(String[] args) {
        
    }

    static long countSubarrays(int a[], int n, int L, int R)  
    {
        
        int start = 0 ;
        int end = 0 ;
        int empire = 0 ;
        long ans = 0 ;

        for ( end = 0; end < a.length; end++) {

            if(a[end] >= L && a[end] <= R){
                // king 
                empire = end - start + 1 ;
            }
            else if( a[end] > R){
                // villain
                empire = 0 ;
                start = end + 1 ;
            }
            
            ans += empire ;
        }
     
        return ans ;
    }
    
}
