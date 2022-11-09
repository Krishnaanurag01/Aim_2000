package Problem_Of_The_day;
import java.util.*;

public class Q287_Minimum_sum_partition {
    
    HashMap<String,Integer> map ;
	public int minDifference(int arr[], int n) 
	{ 
	    // as we have to divide arr into two sets and in the end we have to calculate their sum.
	    // so instead of doing that we can first calculate the total sum and then we will give sum to set1 using pick, not pick approach
	    int sum = 0 ;
	    for(int val : arr) sum += val ;
	    map = new HashMap<>() ; // dp intialization.
	    
	    return helper(0, arr, 0, sum);
	} 
	
	
	int helper(int idx, int[] arr, int s1, int s2){
	    if(idx >= arr.length){ return Math.abs(s1- s2) ;}
	    
	    // s2 is also changing but for same s1, s2 will always remain same so don't care about s2 just take care of s1
	    String key = idx +" - "+s1 ;
	    if(map.containsKey(key)) return map.get(key) ;
	    
	    // not picking current val in sum1
	    int np = helper(idx+1, arr, s1, s2) ;
	    int p = helper(idx+1, arr, s1 + arr[idx], s2 - arr[idx]) ; // picking current val in sum1 so removing from s2(as here it was added previously)
	    map.put(key, Math.min(np,p)) ; // storing in dp
	    
	    return Math.min(np,p);
	}
}
