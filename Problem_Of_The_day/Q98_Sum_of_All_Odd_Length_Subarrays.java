package Problem_Of_The_day;

public class Q98_Sum_of_All_Odd_Length_Subarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        
        for(int i = 1 ; i < arr.length ; i++)
            arr[i] += arr[i-1] ;
        
        int sum = arr[arr.length-1] ; // sum of all subarray of length 1.
        
        for(int i = 3 ; i <= arr.length ; i += 2){ // now taking subarray of odd length and calculating it
            for(int j = i - 1 ; j < arr.length ; j++){
                sum += arr[j] - (j - i >= 0 ? arr[j-i] : 0) ;
            }
        }
        
        return sum ;
    }
}
