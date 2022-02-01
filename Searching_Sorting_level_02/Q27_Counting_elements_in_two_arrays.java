package Searching_Sorting_level_02;
import java.util.*;

public class Q27_Counting_elements_in_two_arrays {
    

    // method 01  : o((m+n)logn)
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        
        Arrays.sort(arr2) ; // sorting second array we will apply binary search on it
        
        ArrayList<Integer> ans = new ArrayList<>() ;
        
        for(int i = 0 ; i < m ; i++){
            
            // now for every element of array1 we are finding the freq by binary search
            ans.add(helper(arr2,arr1[i],n)) ; 
        }
        
        return ans ;
    }
    

    // binary search
    public static int helper(int[] arr , int num,int n){
        
        int low = 0 ;
        int high = n-1 ;
        
        int ans = 0 ;
        while(low <= high){
            
            int mid = (low+high)/2 ;
            
            if(arr[mid] <= num){
                
                ans = mid + 1 ; // updating answer
                low = mid + 1 ; // and checking for larger freq
            }
            else{
                high = mid - 1 ; // when arr[mid] is not less than or equal then checking for smaller values
            }
        }
        
        return ans ;
    }

    // method 02 : when it is guaranteed that the max elememt in arr2 is not greater than max elememt of arr1.

    public static int[] countEleLessThanOrEqual1(int arr1[], int arr2[], int m, int n)
    {
        
        int maxElem = -1 ;
        
        for(int val : arr1){
            maxElem = Math.max(maxElem,val) ;
        }
        
        // step 01 : find the freq array
        int[] freq = new int[maxElem+1] ;
        
        for(int val : arr2){
            freq[val]++ ;
        }
        
        //step 02 : calculate the prefix sum
        
        for(int i = 1 ; i < freq.length ; i++){
            
            freq[i] += freq[i-1] ;
        }
        
       
        for (int i = 0; i < arr1.length ; i++) {
            arr1[i] = freq[i] ; // storing result in same array, here freq[i] stored that freq of element smaller or equal to current element (arr[i])
        }
        
        
        return arr1 ;
    }


}
