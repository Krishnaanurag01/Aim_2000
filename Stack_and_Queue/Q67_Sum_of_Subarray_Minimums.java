package Stack_and_Queue;
import java.util.*;

public class Q67_Sum_of_Subarray_Minimums {

    public int sumSubarrayMins(int[] arr) {
        
        int[] left = new int[arr.length] ; // it stores for how many element current ith val is minimum from current position to left.
        int[] right = new int[arr.length] ;// it stores for how many element current ith val is minimum from current position to right.
        
        Stack<Pair> stack = new Stack<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            int curr_val = arr[i] ;
            int count = 1 ; // taking 1 by default for example : in array [4] 4 is min.
            
            while(stack.size() > 0 && stack.peek().val > curr_val){ // counting element that is greater than current element and taking thier count of in how many array that elment is min.
                count += stack.pop().minCount ;
            }
            // add currrent value with left count in it.
            stack.push(new Pair(curr_val, count)) ;
            left[i] = count ;
        }
        
        // same as left but for right side.
        stack = new Stack<>() ;
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            int curr_val = arr[i] ;
            int count = 1 ;
            
            while(stack.size() > 0 && stack.peek().val >= curr_val){
                count += stack.pop().minCount ;
            }
            // add currrent value with left count in it.
            stack.push(new Pair(curr_val, count)) ;
            right[i] = count ;
        }
        
        long ans = 0 ;
        
        for(int i = 0 ; i < left.length ; i++){
            ans = add(ans,  mul(arr[i], mul(left[i], right[i]))) ; // ans is  :  ans+=  val * left_count * righ_count
        }
        
        return (int)ans ;
    }
    
    int M = (int)1e9+7 ;
    
    long mod(long a){
        return ((a % M) + M)% M ;
    }
    
    long add(long a, long b){
        return mod(mod(a) + mod(b)) ;
    }
    
    long mul(long a, long b){
        return mod(mod(a) * mod(b)) ;
    }
    
    class Pair{
    int val ;
    int minCount ;
    
    Pair(int x, int y){
        val = x ;
        this.minCount = y ;
    }}
}
