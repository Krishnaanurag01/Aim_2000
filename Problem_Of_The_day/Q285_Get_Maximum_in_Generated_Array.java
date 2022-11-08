package Problem_Of_The_day;

public class Q285_Get_Maximum_in_Generated_Array {

    public int getMaximumGenerated(int n) {
        
        if(n == 0) return 0 ;
        int[] arr = new int[n+1] ;
        arr[0] = 0 ;
        arr[1] = 1 ;
        
        int ans = 1 ;
        
        for(int i = 1 ; i <= n ; i++){
            if( i*2 <= n ){
                arr[i*2] = arr[i] ;
                ans = Math.max(ans, arr[i*2]) ;
            }
            else return ans ;
            
            if( (i * 2) + 1  <= n ){
                arr[i*2 + 1] = arr[i] + arr[i+1] ;
                ans = Math.max(ans, arr[i*2 + 1]) ;
            }
            else return ans ;
        }
        
        return ans ;
    }
}
