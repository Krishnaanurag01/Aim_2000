package Dynamic_Programming_extras;
import java.util.*;

public class Q63_Minimum_Cost_to_Cut_a_Stick {


    // not very efficient, it will give memory linmit exceeded.
    // here we are working on the stick
 
    static Integer[][] dp ;
    public int minCost(int n, int[] cuts) {
        
        dp = new Integer[n+1][n+1] ;
        return helper(0,1,cuts) ;
    }
    
    int helper(int si, int ei, int[] cuts){
        
        if( ei - si + 1 <= 2){ // when we have one block only then return 0
            return 0 ;
        }
        
        if(dp[si][ei] != null) return dp[si][ei] ;
        
        int min = (int)1e9 ;
        
        for(int i = 0 ; i < cuts.length ; i++){
            if(cuts[i] > si && cuts[i] < ei ){ // if we can cut current (if current cuts[i]  > greater than start and less than end then we can do this.)
                
                int temp = ei - si  ;  //getting length where we perform cut 
                int left = helper(si,cuts[i],cuts) ; // getting answer from left
                int right = helper(cuts[i],ei,cuts) ; // getting answer from right
                temp += (left + right) ; // total answer
                min = Math.min(min,temp) ; // and updating the min value
            }
        }
        return dp[si][ei] =  min == (int)1e9 ? 0 : min ;
    }



    // here we are woking on the stick array instead on working on the stick.

    static Integer[][] dp2 ;
    public int minCost2(int n, int[] cuts) {
        
        dp2 = new Integer[cuts.length+2][cuts.length+2] ;
        
        int[] ncut = new int[cuts.length+2] ;  // we have to add the boundary of initial stick that is 0 and n so creating a new cut array and then storing
        
        for(int i = 0 ; i < cuts.length; i++){
            ncut[i+1] = cuts[i] ;
        }
        ncut[cuts.length+1] = n ; // storing the right boundary
        
        Arrays.sort(ncut) ;  // we must sort to remove dependency of element.
        return helper(1,cuts.length,ncut) ;
    }
    
    int helper2(int si, int ei, int[] cuts){
        
        if( si > ei ){  // returning zero when si is greater than ei
            return 0 ;
        }
        
        if(dp2[si][ei] != null) return dp2[si][ei] ;  
        
        int min = (int)1e9 ;
        
        for(int idx = si ; idx <= ei ; idx++){
            int temp = cuts[ei+1] - cuts[si-1] ; // size of stick where we w=are peforming cut operation
            int left =  helper2(si,idx-1, cuts) ; // subanswer from left
            int right =  helper2(idx+1,ei,cuts) ; // and from right.
            temp += left + right ;
            min = Math.min(min,temp) ;
        }
       
        return dp2[si][ei] =  min == (int)1e9 ? 0 : min ;
    }




    // tabulations : 

    public int minCost3(int n, int[] cuts) {

        int[] narr = new int[cuts.length+2] ;
        
        for(int i = 0 ; i < cuts.length; i++){
            narr[i+1] = cuts[i] ;
        }
         narr[cuts.length+1] = n ;
        Arrays.sort(narr) ;
        
        
        int[][] dp = new int[cuts.length+2][cuts.length+2] ;
        
        for(int i = cuts.length ; i >= 1 ; i--){
            for(int j = 1 ; j <= cuts.length ; j++){
                
                if(i > j) continue ;
                
                int min = (int)1e9 ;
        
                for(int idx = i ; idx <= j ; idx++){
                  int temp = narr[j+1] - narr[i-1] ;
                  int left =  dp[i][idx-1] ; 
                  int right = dp[idx+1][j] ;
                  temp += left + right ;
                  min = Math.min(min,temp) ;
                }
       
             dp[i][j] =  min ;
            }
        }
        
        return dp[1][cuts.length] ;
    }
    
}
