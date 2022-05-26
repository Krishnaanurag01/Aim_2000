package Searching_Sorting_level_02;

public class Q42_Farthest_number {

    static int[] farNumber(int n, int[] a)
	{
	    
		int[] arr = new int[n] ; // this arr stores min from n to 0 index. hence it will be sorted
		arr[n-1] = a[n-1] ;
		for(int i = n - 2 ; i >= 0 ; i--)
		arr[i] = Math.min(a[i],arr[i+1]);
		
		
		
		for(int i = 0 ; i < n ; i++){
		    a[i] = bsearch(i,arr,a[i]); // finding the min value using binary search on sorted array.
		}
		
	     return a ;
	}
	
	static int bsearch(int i, int[] arr, int val){
	    
	    int low = i ;
	    int high = arr.length - 1 ;
	    int ans = (int)1e9 ;
	    int idx = -1 ;
	    
	    while(low <= high){
	        int mid = low + ( high - low ) / 2 ;
	        
	        if(arr[mid] < val ){
	            ans = arr[mid] ;
	            idx = mid ;
	            low = mid + 1 ;
	        }
	        else{
	            high = mid - 1 ;
	        }
	    }
	    
	    return idx ;
	}
}
