package Problem_Of_The_day;

public class Q298_Count_of_Subarrays {
    
    long countSubarray(int arr[], int n, int k) {

        long ans = (long)((long)n*((long)n+1))/2 ; // intitally the total subarray possible.
        long c = 0 ; // count of element less than equal to k.
        
        for(int val : arr){
            if(val <= k){
                c++ ;
            }
            else{
                // now current element is greater than k so remove total subarrays by lesser element from answer.
                ans = ans - ((c*(c+1))/2);
                c = 0 ;
            }
        }
        
        ans = ans - ((c*(c+1))/2);
        return ans ;
     }
}
