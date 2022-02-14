package Arrays_and_string_level_02;

public class Q37_Number_of_Subarrays_with_Bounded_Maximum {

    static int countSubarrays(int a[], int n, int L, int R)  
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
     
        return (int)ans ;
    }
    
}
