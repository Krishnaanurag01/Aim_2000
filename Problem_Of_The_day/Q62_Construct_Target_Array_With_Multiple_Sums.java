package Problem_Of_The_day;
import java.util.*;

public class Q62_Construct_Target_Array_With_Multiple_Sums {

    // recursive solution.
    public boolean isPossible(int[] target) {
        int max = 0 ;
        int sum = 0 ;
        
        for(int i = 0 ; i < target.length ; i++){
            int val = target[i] ;
            if(target[max] < val){ max = i ;}
            sum += val ;
        }
        
        int restSum = sum - target[max] ; // sum except the max value
        if(target[max] == 1 || restSum == 1) return true  ;
        
        // int diff = target[max] - restSum ; // this was the previous value on place of current max value because current max value is a combination of previous all values.
        
        if(restSum > target[max] || restSum == 0 || target[max] % restSum == 0) return false ; // when restSum is greater than max then surely this max value is not the combi of previous values becuase on substraction it will  give negative values and 
        // if rest of the sum is 0 means we have only one element then it can't be roll back to 1 hence this is also false conditon
        // and if on mod operation 0 comes then then it is also the false one.
        target[max] %= restSum ;

        return isPossible(target) ;
    }


    // iterative solution
    public boolean isPossible2(int[] target) {
        
        long sum = 0 ;
        PriorityQueue<Integer> q = new PriorityQueue<>( (a,b) -> b - a ) ;
        for(int i = 0 ; i < target.length ; i++){
            int val = target[i] ;
            q.add(val) ;
            sum += val ;
        }
        
        while(q.peek() != 1){
            int max = q.poll() ; 
            long restSum = sum - max ; // sum except the max value
            if(max == 1 || restSum == 1) return true  ;
            if(restSum > max || restSum == 0 || max % restSum == 0) return false ;
            max %= restSum ;
            sum = restSum + max ;
            q.add(max) ;
        }
            
        return true ;
    }

}