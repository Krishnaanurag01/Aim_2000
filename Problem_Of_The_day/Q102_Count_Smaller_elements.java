package Problem_Of_The_day;


public class Q102_Count_Smaller_elements {

    int[] ans ;
    
    // application for merge sort
    int[] constructLowerArray(int[] arr, int n) {
       int[][] updatedArr = new int[n][2] ; // storing index with element.
       
       for(int i = 0 ; i < n ; i++){
           updatedArr[i][0] = arr[i] ;
           updatedArr[i][1] = i ;
       }
       
       ans = new int[n] ;
       mergeSort(updatedArr,0,n-1) ;
       return ans ;
    }
    
    void merge(int arr[][], int l, int m, int r)
    {
        int n1 = m-l+1 ;
        int n2 = r-m ;

        int[][] left = new int[n1][2] ;
        int[][] right = new int[n2][2] ;

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[l + i] ;
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[i + m + 1] ;
        }

        int k = l ;
        int i = 0 ;
        int j = 0 ;

// sorting in descending order.
        while (i < n1 && j < n2) {
            if(left[i][0] > right[j][0]){ // if left value is greater then it means all the element in right side is smaller as array is sorted in descending order and first largest of right is small so count or simply take the right side length from starting from j
                arr[k] = left[i] ;
                ans[ left[i][1] ] += (n2-j) ; // this is the only line added to merge sort algo. here we are storing right side smaller element in index of left element
                k++;
                i++;
            }
            else{
                arr[k] = right[j] ;
                k++;
                j++;
            }
        }


        while (i < n1) {
            arr[k] = left[i] ;
            k++;
            i++;
        }

        
        while (j < n2) {
            arr[k] = right[j] ;
            k++;
            j++;
        }
    }
    
    
    void mergeSort(int arr[][], int l, int r)
    {
       if(l < r){
           int mid = (l+r)/2 ;
           mergeSort(arr,l,mid) ;
           mergeSort(arr,mid+1,r) ;
           merge(arr,l,mid,r);
       }
    }
    
}