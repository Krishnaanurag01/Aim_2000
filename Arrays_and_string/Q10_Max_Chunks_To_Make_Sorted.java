package Arrays_and_string;

public class Q10_Max_Chunks_To_Make_Sorted {

    public int maxChunksToSorted(int[] arr) {
        
        int count = 0 ;
        int max = 0 ;
        
        for(int i = 0 ; i < arr.length ; i++){
            
            max = Math.max(max,arr[i]);  // this will update the max range. here we are updating becuase if [1,2,0,3] comes then we can see that max till 0th index is 1 and when we come to 2 (index 1) then we first updating it becuase it says we have to partition max 0 to 2 size array so that every element of partition gets sorted.
            
            if(max == i){ // if the max range is current index then increase the count. 
                count++ ;
            }
        }
        
        
        return count ;
    }

}
