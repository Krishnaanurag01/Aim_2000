package Searching_Sorting_level_02;

public class Q8_Roof_Top {
    
    static int maxStep(int A[], int N)
    {
        // Your code here
        int max = 0 ;
        int curr = 0 ;
        
        for(int i = 1 ; i < N ; i++){ // starting from 2nd building (1st index) becuase moving from 0th to 0th building counts 0 step.
            
            if(A[i] > A[i-1] ){ // if current building is larger then increase the step count
                curr++ ;
            }
            else{ // if current building is smaller or equl then make current count as 0 .
                curr = 0 ;
            }
            
            max = Math.max(max,curr) ; // updating answer every time.
            
        }
        
        return max ;
    }
    
}
