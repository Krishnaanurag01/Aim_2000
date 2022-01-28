package Searching_Sorting_level_02;

public class Q16_Median_of_2_Sorted_Arrays_of_Different_Sizes {

    // method 01 : brute force
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {

        // Step 01 : merge the array into one big array
        
        int[] mergedArr = new int[n+m] ;

        int i = 0 ;
        int j = 0 ; 
        int k = 0 ;

        while (i < n &&  j < m) {
            if(a[i] <= b[j]){
                mergedArr[k++] = a[i++] ;
            }
            else{
                mergedArr[k++] = b[j++] ;
            }
        }

        while (i < n ) {
            mergedArr[k++] = a[i++] ;
        }

        while (j < m ) {
            mergedArr[k++] = b[j++] ;
        }

        // step 02 : return the mid 
        
        int midIdx = (n+m)/ 2 ;
        if(n+m % 2 == 0){
            // when even then return both the mid element divide by 2.
            return ((double)mergedArr[midIdx] +(double) mergedArr[midIdx-1])/(double)2 ;
        }
        else{
            // else when only one mid present then return the mid
            return mergedArr[midIdx] ;
        }

    }

    // method 02 : optimal approach
    
}
