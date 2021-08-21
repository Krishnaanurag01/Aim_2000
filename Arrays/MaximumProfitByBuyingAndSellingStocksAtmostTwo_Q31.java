package Arrays;



/**
 * MaximumProfitByBuyingAndSellingStocksAtmostTwo_Q31
 */
public class MaximumProfitByBuyingAndSellingStocksAtmostTwo_Q31 {

public static void main(String[] args) {
    int[] arr = { 10, 22, 5, 75, 65, 80};
    System.out.println(getMaxProfitAtmostTwoPurchase(arr, arr.length));
}   

// when theres no limit on purchasing stocks means we can buy unlimited stocks and sell it. this approach only works when we have a chance to do infinite transaction. 
// public static int getMaxProfit(int[] arr, int n) {
//     int profit = 0 ;
//     for (int i = 1; i < n ; i++) {
//         if(arr[i]> arr[i-1]){
//             profit +=arr[i]-arr[i-1];
//         }
//     }

// return profit;

// }
public static int getMaxProfitAtmostTwoPurchase(int[] arr , int n) {
// check pep coding youtube channel for its explanation.
    
// first finding max profit if sold today for all elements.
    int mpist = 0; 
    int leastSoFar = arr[0];
    int[] dpLeft = new int[n];
    for (int i = 1; i < n; i++) {
        if(arr[i] < leastSoFar){
            leastSoFar = arr[i];
        }
        mpist = arr[i]-leastSoFar;
        if(mpist > dpLeft[i-1]){
            dpLeft[i] = mpist;
        }else{
            dpLeft[i] = dpLeft[i-1];
        }
    }


    // now finding max profit if buy today or before.
    int mpibt = 0;
    int maxSoFar = arr[n-1];
    int[] dpRight = new int[n];

    for (int i = n-2; i >= 0 ; i--) {
        if(arr[i] > maxSoFar){
            maxSoFar = arr[i];
        }

        mpibt = maxSoFar - arr[i];
        if(mpibt > dpRight[i+1]){
            dpRight[i] = mpibt;
        }
        else{
            dpRight[i] = dpRight[i+1];
        }
    }

// now time for output , the element which will have max sum of both dpLeft and dpRight of same index is our answer.

    int output = 0 ;
    for (int i = 0; i < n; i++) {
        if(dpLeft[i]+dpRight[i] > output){
            output = dpLeft[i] + dpRight[i];
        }
    }

    return output;
}
}
