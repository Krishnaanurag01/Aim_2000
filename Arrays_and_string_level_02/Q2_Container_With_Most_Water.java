package Arrays_and_string_level_02;

public class Q2_Container_With_Most_Water {


    // brute force : time is O(n2)
    
    public int maxArea(int[] arr) {
        
        int ans = 0 ;
        
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                ans = Math.max(ans, Math.min(arr[i],arr[j]) * (j-i));
            }
        }
        
        return ans ;
    }

    public int maxArea1(int[] arr) {
        
        int ans = 0 ;

        int i = 0 ;
        int j = arr.length-1 ;

        while(i < j){
            ans = Math.max(ans, Math.min(arr[i], arr[j]) * (j-i) ) ;     // finding water capacity by selecting the smaller building between arr[i] and arr[j] and then multiplying it with their width.

            if( arr[j] > arr[i]){ // now we increase i pointer if arr[i] building is smaller
                i++ ;
            }
            else if(  arr[j] <=  arr[j]){  // else decrease j pointer.
                j-- ;
            }
           
        }
        
        return ans ;
        
        
    }
}
