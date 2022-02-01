package Searching_Sorting_level_02;

public class Q28_Distinct_absolute_array_elements {
    
    int distinctCount(int[] arr, int n) {
        // code here
        
        
        int count = 0 ;
        
        
        int i = 0 ;
        int j = n-1 ;
        
        
        while(i <= j){
            
            int val1 = (int)Math.abs(arr[i]) ;
            int val2 = (int)Math.abs(arr[j]) ;
            
            if(i > 0 && val1 == Math.abs(arr[i-1])) // if the previous value is same as current value then 
           {
               i++ ; // increment and move to next iteration
               continue ;
           }
            
            
            if( j < n-1 && val2 == Math.abs(arr[j+1])) // same for j 
            {
                j-- ;
                continue ;
            }
            
            // next step is to : choose the larger side value and increment the count and corresponding pointer as well
            
            if(val1 > val2){ 
                count++ ;
                i++ ;
            }
            else if(val2 > val1){
                count++;
                j-- ;
            }
            else{ /// when both val is same then we will consider only one count and increase the pointer
                count++ ;
                i++ ;
                j-- ;
            }
        }
        
        return count ;
    }
}
