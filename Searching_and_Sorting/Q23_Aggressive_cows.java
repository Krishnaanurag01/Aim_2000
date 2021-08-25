package Searching_and_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Q23_Aggressive_cows {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking total test cases.
        int TestCases  = sc.nextInt();
        while (TestCases-- > 0) {
            // total stalls and cows.
            int totalStalls = sc.nextInt();
            int totalCows = sc.nextInt();

            int[] stalls = new int[totalStalls];

            for (int i = 0; i < totalStalls ; i++) {
                stalls[i] = sc.nextInt();                
            }


            /// solutions begins from here!


            // sorting array so that it would be easier to find difference.
            Arrays.sort(stalls);


            // we assumed one cow is at the start and one cow at the end so the maximum distance is arr[n-1] - arr[0]. so looking into this distance. (it is maximum becuase oth index is lowest and n is highest becuase array is sorted)
            int low = 1 , high = stalls[totalStalls-1] - stalls[0];

            int res = 0; // result ! we can also return high!, both will be same.

            while (low <= high) {

                int mid = (low+high)/2;

                // here checking is it possible to place cows with mid distance such that all cows are placed.
                if(isPossible(stalls, totalStalls , totalCows , mid)){
                    // when it returns true then it means we can place it with current mid distance so now checking for larger mid . for larger mid we increase the low to mid + 1 so we can find in larger side of the array.
                    res = mid;
                    low = mid+1;
                }
                else{
                    // else we check smaller distance that can take all the cows.
                    high = mid-1;
                }
                
            }

            System.out.println(res);
            
        }
        sc.close();
        
    }

    public static boolean isPossible(int[] arr , int n , int cows , int distance) {

        // here we placed one cow at 0th index that's why cowCount is 1 initially.
        int cowCount = 1 ;
        int lastPlacedCows = arr[0];

        for (int i = 1; i < arr.length; i++) {

            // now checking if the distance we get from arr[i] and last cow is equals or greater than mid. and increamenting count so that when we placed all the cows then we can return true.
            if(arr[i] - lastPlacedCows >= distance){
                cowCount++;
                lastPlacedCows = arr[i];
            }

            if(cowCount == cows ){
                return true;
            }
            
        }





        return false;
    }
}
