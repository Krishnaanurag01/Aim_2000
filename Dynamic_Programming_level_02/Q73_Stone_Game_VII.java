package Dynamic_Programming_level_02;

public class Q73_Stone_Game_VII {

    public static void main(String[] args) {
        
    }


    public static int get_diff(int[] stones , int si , int ei) {

        if(si >= ei) return 0 ; // the moment starting index becomes greater than ending index return  0.

        if(si+1 == ei){ // when only two elements left then return the max one.
            return Math.max(stones[si], stones[ei]) ;
        }
        

        int tookI = sum(stones,si+1,ei) - get_diff(stones, si+1, ei); // this denotes we took si index element and called the function with si+1. 
        int tookJ = sum(stones,si,ei-1) - get_diff(stones, si, ei-1); // this denotes we took ending index element (ei) and called the function with ei - 1 .


        return Math.max(tookI, tookJ) ;
    }


    private static int sum(int[] stones, int i, int ei) {
        
        int ans = 0 ;

        for (int k = i ; k <= ei ; k++) {
            ans += stones[k] ;
        }

        return ans ;
    }
    
}
