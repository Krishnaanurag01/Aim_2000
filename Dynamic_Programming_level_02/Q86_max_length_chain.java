package Dynamic_Programming_level_02;

import java.util.Arrays;

public class Q86_max_length_chain {

    public static void main(String[] args) {

        Pair[] p = {new Pair(5 ,24) , new Pair (39, 60 ), new Pair (15, 28 ) , new Pair( 27, 40 ) , new Pair( 50 , 90 )} ;

        System.out.println(get_max_length_rod(p));
        
    }

    
    
    static class Pair {
     
        int x ;
        int y ;

        Pair(int a,int b){
            x=a;
            y=b ;
        }   
    }

    public static int get_max_length_rod(Pair[] arr) {
     
        Arrays.sort(arr, (a,b) -> {  // sorting first on the basis of x value.
            return a.x - b.x ;
        });

        int n = arr.length ;

        int[] dp = new int[n] ; // now making an dp array.
        int ans = 0 ;

        for(int i = 0 ; i < n ; i++){
            int max = 0 ;
            for (int j = 0; j < i; j++) { // running from j to i 
                if(arr[j].y < arr[i].x){ // and if arr[j].y value is less than arr[i].x then check its dp  value and find max
                    max = Math.max(max, dp[j]) ;
                }
            }

            dp[i] = max + 1 ; // adding one because we are adding current chain. 
            ans = Math.max(ans, dp[i]) ; // also updating the answer.
        }


        return ans ;
    }
    
}
