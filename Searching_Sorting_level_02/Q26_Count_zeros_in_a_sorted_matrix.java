package Searching_Sorting_level_02;

public class Q26_Count_zeros_in_a_sorted_matrix {
    
    int countZeros(int A[][], int N)
    {
        
        int i = 0 ;
        int j = N-1 ;
        
        int count = 0 ;
        
        while(i < N && j >= 0){
            
            if(A[i][j] == 1 ) // this denotes that this column can't have any zeros
            {
                j-- ; // so subtract the column
            }
            else{ // else if we find the zero in current row
                count += (j+1) ; // calculate the zeros
                i++ ; // and move to next row
            }
                
        }
        
        return count ;
    }

}
