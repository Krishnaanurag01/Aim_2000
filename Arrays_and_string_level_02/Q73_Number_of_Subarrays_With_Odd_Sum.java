package Arrays_and_string_level_02;

public class Q73_Number_of_Subarrays_With_Odd_Sum {

    // method 01 : brute force time : -> complexity : O(n2)

    public int numOfSubarrays(int[] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum % 2 != 0)
                    count++;
            }
        }

        return count;
    }

    // method 02 :

    public int numOfSubarrays2(int[] arr) {
        
        long ans = 0 ;
        int mod = 1000000007 ;
        
        // odd : even + odd , odd + even
        // even : even + even , odd + odd
        
        int even = 0 ; // count of even sum till now
        int odd = 0 ; // count of odd sum till now
        long sum = 0 ; // it's act like presum
        
        for(int val : arr){
            
            sum += val ; // adding current value to sum (like presum)
            
            if(sum % 2 == 0){ // denotes sum is even
                ans += odd ; 
                even++ ;
            }
            else{ /// denotes sum is odd
                ans += (1+even) ; // as current number is also odd so adding +1
                 odd++ ;
            }
        }
        
        
        return (int)(ans%mod) ;
    }


}
