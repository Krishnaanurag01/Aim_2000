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


    public double findMedianSortedArrays(int[] a, int[] b) {
        
        // we considering that length of a array is smaller
        if(a.length > b.length){ // if not then do this
            return findMedianSortedArrays( b , a ) ;
        }
        
        int low = 0 ;
        int high = a.length ; // here taking the complete length instead of length - 1. this will help us in taking the extra 1 element for segregation.
        
        // total element
        int te = a.length + b.length ;
        
        
        while(low <= high){
            int aleft = (low+high)/2 ; // this is mid point in first array. 
            int bleft = (te+1)/2 - aleft ; // this is the mid point in second array.
            
            // covering the edge cases
            int alm1 = (aleft == 0) ? Integer.MIN_VALUE : a[aleft-1] ; // a left minus element
            int al = (aleft == a.length) ? Integer.MAX_VALUE : a[aleft] ; // a left element
            int blm1 = (bleft == 0) ? Integer.MIN_VALUE : b[bleft-1] ; // b left minus element
            int bl = (bleft == b.length) ? Integer.MAX_VALUE : b[bleft] ; // b left element
            
            if(alm1 <= bl && al >= blm1){ // when the segregated part is valid
                
                if(te % 2 == 0 ){ // when total element is 
                    // when even then find the average of two mid element
                    
                    int mid1 = Math.max(alm1,blm1) ; // max in a's left part -1 and b's left part minus -1
                    int mid2 = Math.min(al,bl) ; // min in a's right part and b's right part
                    
                    double avg  = (mid1+mid2)/2.0 ;
                    
                    return avg ;
                }
                else{
                    // when odd then return the largest element of left side
                    return Math.max(alm1 , blm1) ;
                }
            }
            else if(alm1 >= bl){ // if the a's left part minus 1 element is larger than the b's right part first element then it means we have to include the smaller element of b array and exclude some element of a array
                high = aleft - 1 ; // so reducing the high helps in taking less element in a's array
            }
            else if(blm1 >= al){ // this this denotes that a array still has some element smaller in right side so include them in left part so increasing the low of a's array 
                low = aleft + 1 ;
            }
            
        }
        
        return -1 ;
        
    }
    
}
