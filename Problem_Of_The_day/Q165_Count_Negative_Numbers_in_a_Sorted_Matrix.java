package Problem_Of_The_day;

public class Q165_Count_Negative_Numbers_in_a_Sorted_Matrix {

    public int countNegatives(int[][] grid) {
        
        // here using binary search for finding the position of -1
        int count = 0 ;
        
        for(int[] arr : grid){
            int low =  0;
            int high = arr.length - 1;
            
            while(low <= high){
                int mid = (low + high)/2 ;
                if(arr[mid] >= 0 ){
                    low = mid + 1;
                }
                else{
                    if(arr[mid] <= -1){
                        high = mid - 1;
                    }
                }
            }

            
            if(low < arr.length){ // if -1 position lies between arr boundry then count all the element from that index till end
                count += (arr.length - low) ;
            }
        }
        
        return count;
        
    }
}
