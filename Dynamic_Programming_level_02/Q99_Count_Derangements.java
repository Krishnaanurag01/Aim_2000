package Dynamic_Programming_level_02;

public class Q99_Count_Derangements {

    public static void main(String[] args) {
        
        System.out.println( get_count(40));
        System.out.println( get_count2(40));
        System.out.println( get_count3(40));
    }

    // recursive solution.
    public static int get_count(int n) {
        
        if(n == 1) return 0 ; // when n is 1 then we can only arrange elements in one way which already present.so 0.
        if(n == 2) return 1 ; // when n is 2 then we can only arrange elements in two ways where one is already present and one extra . for eg : {a,b} => {a,b} , {b,a}

        return (n-1)*(get_count(n-2) + get_count(n-1)) ; // this is formula, we can place one element at everyplace except the original place so n-1 and rest of the elements if the element of the place where we swapped first element placed at first element location then rest of the array is n-2 else if the element didn't placed at the first element location then it could place n-1 location so adding both n-2 + n-1. 
    }
    

    // dp solution with O(n) time and space.

    
    public static int get_count2(int n) {
        
        if( n == 1) return 0 ;
        if( n == 2) return 1 ;
      
        int[] dp = new int[n+1] ;
        dp[1] = 0 ; // when total elements are 1.
        dp[2] = 1 ; // when total elements are 2.

        for (int i = 3 ; i < dp.length; i++) {
            dp[i] = (i-1)*(dp[i-2] + dp[i-1]) ; // same formula as above.
        }

        return dp[n] ;
    }

    // optimized solution in O(n) time and O(1) space.

    public static int get_count3(int n) {
        
        if( n == 1) return 0 ;
        if( n == 2) return 1 ;
      
        int previous1 = 0 ;
        int previous2 = 1;

        for (int i = 3; i <= n ; i++) {
            int current = (i-1) * (previous1+previous2) ; // same formula : here previous 1 denotes dp[n-2] and previous 2 denotes dp[n-1]

            previous1 = previous2 ;
            previous2 = current ;
        }

        return previous2 ;

    }
}
