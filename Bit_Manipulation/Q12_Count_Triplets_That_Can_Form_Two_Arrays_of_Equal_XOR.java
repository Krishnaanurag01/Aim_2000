package Bit_Manipulation;

public class Q12_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {

    public int countTriplets(int[] arr) {
  
        int count = 0 ;

        for(int i = 0 ; i < arr.length ; i++){
            int xor = arr[i] ; // starting with ith value

            for (int k = i+1; k < arr.length ; k++) {
                xor = xor ^ arr[k] ; // now doing xor operation on kth value

                if(xor == 0){ // if becomes zero only when all the elements becomes same so count the total same answer
                    count += k-i ; // this denotes total subarray of (i-> j-1) -> j > k . which will become same
                }
            }
        }

        return count ;
    }
    
}
