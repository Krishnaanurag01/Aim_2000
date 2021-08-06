package Arrays;

import java.lang.reflect.Array;

public class MedianOfTwoSortedArrays_Q40_Q41 {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 6 };
        int[] arr2  = { 4, 8, 10 };
        System.out.println(getMedian(arr1, arr2));
        
    }

    // time complexicity = o(n+m) 
    // space complexicity = o(n+m)
    // public static int getMedian(int[] arr1 , int arr2[] , int n , int m) {


    //     int[] temp = new int[n+ m];
    //     int i = 0 , j = 0 , k = 0;
    //     int ans = 0 ;



    //     while ( i < n && j < m ) {
    //         if(arr1[i] < arr2[j]){
    //             temp[k] = arr1[i];
    //             i++;
    //         }            
    //         else if(arr2[j] < arr1[i]){
    //             temp[k] = arr2[j];
    //             j++;
    //         }
    //         k++;
    //     }
    //     while ( i < n) {
    //         temp[k] = arr1[i];
    //         i++;
    //         k++;           
    //     }
    //     while ( j < m) {
    //         temp[k] = arr2[j];
    //         j++;
    //         k++;            
    //     }

    //     if(temp.length % 2 != 0){
    //         ans = temp[temp.length/2];
    //     }
    //     else{
    //         ans = (temp[temp.length/2] + temp[temp.length/2 - 1])/2 ; 
    //     }
    //     return ans ; 
        
    // }



    // ********************  overall run time complexity : O(log (m+n)) *************************

    public static int getMedian(int[] nums1 , int[] nums2) {

        if(nums1.length > nums2.length){
            return(getMedian(nums2,nums1));
        }
        
        // size of nums1 and nums2 :
        int n1 = nums1.length;
        int n2 = nums2.length;

        // initializing low and high of array.

        int low = 0, high= n1;
        
        while (low <= high) {


        // getting mid point-1 of Array1.

            int cut1 = low+(high-low)/2;

        // partition of array2

        int cut2 = ((n1+n2)/2) - cut1;

        // initializing l1,l2,r1,r2.

        int l1 = (cut1==0)?Integer.MIN_VALUE: nums1[cut1-1];
        int l2 = (cut2== 0)? Integer.MIN_VALUE : nums2[cut2-1];
        int r1 = (cut1== n1)?Integer.MAX_VALUE : nums1[cut1];
        int r2 = (cut2 == n2)? Integer.MAX_VALUE : nums2[cut2];

        //         Shift element to the left

        if(l1 > r2) high= cut2-1;
        else if(l2> r1) low = cut1+1;
        else{
             if((n1+n2)%2 == 0 ){
                return (Math.max(l1, l2) + Math.min(r1, r2))/2;
             }
             else{
                 return Math.min(r1, r2);
             }
        }
    }
        return 0;
    }


    
}
