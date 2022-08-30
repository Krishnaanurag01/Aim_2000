package Problem_Of_The_day;

public class Q199_Reverse_Integer {

    public int reverse(int x) {
        
        int signMultiplier = x < 0 ? -1 : 1 ;
        x = Math.abs(x) ;
        int ans = 0 ;
        while(x != 0){
            int digit = x % 10 ;
            
            // we have to check integer bound after reverseing.
            if (ans * signMultiplier > Integer.MAX_VALUE / 10 || ans * signMultiplier < Integer.MIN_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + digit ;
            x = x/10 ;
        }
        
        return signMultiplier * ans ;
    }
}
