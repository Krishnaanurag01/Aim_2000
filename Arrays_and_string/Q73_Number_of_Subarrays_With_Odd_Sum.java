package Arrays_and_string;

public class Q73_Number_of_Subarrays_With_Odd_Sum {

    // method 01 : brute force time : -> complexity : O(n2)

    public int numOfSubarrays(int[] arr) {
        
        int count = 0 ;
        
        for(int i = 0 ; i < arr.length ; i++){
            int sum = 0 ;
            for(int j = i ; j < arr.length ; j++){
                sum += arr[j] ;
                if(sum % 2 != 0) count++ ;
            }
        }
        
        return count ;
    }

}
