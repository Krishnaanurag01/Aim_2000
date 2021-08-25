package Searching_and_Sorting;

public class Q22_Kth_Element_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
       int arr1[] = {2, 3, 6, 7, 9};
       int arr2[] = {1, 4, 8, 10};

       System.out.println(getKthElement(arr1, arr2, arr1.length, arr2.length, 5));
    }

    // time complexcity : log(min(n,m)) and space is o(1).
    // this question is similar to median in arrays.
    public static int getKthElement(int[] arr1 , int[] arr2 , int n , int m , int k) {
        
        if( n > m ){
            return getKthElement(arr2, arr1, m , n , k);
        }
        int low = Math.max(0, k-m); // it means min number of elements in arr1 . here subtracting m from k becuase there might be a case
                                    // when total length of arr2 is for example 3 and k is 5 so it means we must have atleast 2 elements in arr1.

        int high = Math.min(k, n); // and here taking min of length of arr1  or k because for example : we have to find k(2) element then it means at most we can have only 2 length in high thats why taking min in high.

        while(low <= high){

            // applying binary search as same as median of two arrays in Arrays part.

            int cut1 = (low+high)/2 ;
            int cut2 = k-cut1 ;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1-1] ;
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2-1] ;
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if(l1 <= r1 && l2 <= r2){
                return Math.max(l1, l2);
            }
            else if( l1 > r1){
                high = cut1 - 1;
            }
            else{
                low = cut1 + 1;
            }
        }

        return 1;
    }
}
