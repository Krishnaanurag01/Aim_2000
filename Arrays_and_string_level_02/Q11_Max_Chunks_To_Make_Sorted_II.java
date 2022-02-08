package Arrays_and_string_level_02;

public class Q11_Max_Chunks_To_Make_Sorted_II {

    public int maxChunksToSorted(int[] arr) {
        
        int[] right_min = new int[arr.length+1] ; // finding the min from right to till left for each index. // making an extra +1 size becuase when we process the main logic loop then we will be accessing the currentnode + 1 index. that's why making it.
        right_min[arr.length] = Integer.MAX_VALUE ; // and storing max value of integer so that no other number from right to left can have higher than this.
        
        for(int i = arr.length - 1 ; i >= 0 ; i-- ){
            right_min[i] = Math.min(right_min[i+1],arr[i]) ; // storing from right to left.
        }
        
        int left_max = Integer.MIN_VALUE ; // took min value by default becuase we have to process left max from 0 to length index.
        
        int count = 0 ; // number of partition
        
        for(int i = 0 ; i < arr.length ; i++){
            left_max = Math.max(left_max,arr[i]) ; // fiding left max till now.
            
            if(left_max <= right_min[i+1]){ // if current max is less than or equal i+1 index min value then increase the count becuase we have to partition it.
                count++ ;
            }
        }
        
        return count ;
        
    }
    
}
