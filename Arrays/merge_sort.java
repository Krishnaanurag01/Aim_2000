package Arrays;

public class merge_sort {
    
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m-l+1 ;
        int n2 = r-m ;

        int[] left = new int[n1] ;
        int[] right = new int[n2] ;

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[l + i] ;
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[i + m + 1] ;
        }

        int k = l ;
        int i = 0 ;
        int j = 0 ;

        while (i < n1 && j < n2) {
            if(left[i] < right[j]){
                arr[k++] = left[i++] ;
            }
            else{
                arr[k++] = right[j++] ;
            }
        }


        while (i < n1) {
            arr[k++] = left[i++] ;
        }

        
        while (i < n1) {
            arr[k++] = right[i++] ;
        }


    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        
        if(l < r){
            
            int m =  l + (r-l) /2 ;
            
            mergeSort(arr,l,m) ;
            
            mergeSort(arr,m+1 ,r) ;
            
            merge(arr,l,m,r) ;
        }
    }
}
