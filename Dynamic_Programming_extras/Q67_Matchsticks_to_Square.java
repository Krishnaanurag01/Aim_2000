package Dynamic_Programming_extras;
import java.util.*;

public class Q67_Matchsticks_to_Square {

    public boolean makesquare(int[] matchsticks) {
        
        if(matchsticks==null || matchsticks.length==0) return false;
       int sum=0;
       for(int num:matchsticks) sum+=num;
       if(sum%4!=0) return false; // if total length can't be divided in four side then return false directly
       Arrays.sort(matchsticks) ; 

       return helper(matchsticks.length - 1 ,matchsticks,new int[4],sum/4); // else check if it really can form square
   }
   
   boolean helper(int idx, int[] sticks, int[] sum, int target){
       
       if(idx == -1){
           return sum[0] == target && sum[1] == target && sum[2] == target && sum[3] == target ;
       }
       
       for(int j = 0 ; j < 4 ; j++){
           if(sum[j] + sticks[idx] > target) continue;
           sum[j] += sticks[idx];         
           if(helper(idx-1, sticks, sum, target)) return true ;
           sum[j] -= sticks[idx];
       }
       
       return false;
   }
}
