package Dynamic_Programming_extras ;

public class Q50_Longest_Mountain_in_Array {
    
    public int longestMountain(int[] arr) {
        int n = arr.length ;
        int ans = 0 ;
        
        for(int i = 1 ; i <= n-2 ; ){  // check the peek point of mountain only
            
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){  // peek point.
                int count = 1 ; // bydefault 1 for peek.
                int j = i ;
                
                /// counting the left side.
                while(j > 0 && arr[j] > arr[j-1]){
                    j--;
                    count++;
                }
                // going to right valley.
                while(i < n-1 && arr[i] > arr[i+1]){
                    i++ ;
                    count++ ;
                }
                ans = Math.max(ans,count) ;
            }
            else{
                i++ ;
            }
        }
        return ans ;
    }
}
