package Searching_Sorting_level_02;

public class Q32_Find_the_element_that_appears_once {
    
    public static int search(int A[], int N)
    {
        
        if(N == 1 ){ // when only one element present.
            return A[0] ;// return then only element
        }
        
        // checking the boundary case.

        if(A[0] != A[1]){ // if first element is not same as next element then first element is result.
            return A[0] ;
        }
        
        if(A[N-1] != A[N-2]){ // if last element is not same as last-1 element then return last element.
            return A[N-1] ;
        }
        
        
        // else applying the binary search

        int low = 0 ;
        int high = N - 1 ;
        
        while(low <= high){
            
            int mid = (low+high)/2 ;
            
            // as boundary condition is already managed in start so it won't throw index out of bound and theres always a element present with only 1 freq and also does not present in edges so it surely will get founded in between before coming to edges.
            if(A[mid] != A[mid-1] && A[mid] != A[mid+1]){
                return A[mid];
            }
            else if(A[mid] == A[mid - 1]){ // when left part has same element
                // left distance(total element)
                int dist = mid - low + 1 ;
                
                if(dist % 2 == 0){
                    // as distance is even so there can't be only one element with one freq so it means left part is full of pairs
                    low = mid + 1 ;
                }
                else{ // when total element present is odd in number then it means there must be a number present with one freq in left side
                    high = mid - 2 ; // as we already compaed the mid and mid -1 so jumping to mid -2 for next search
                }
            
            }
            else if(A[mid] == A[mid + 1]){ // when right part has same element
                 // right distance(total element)
                int dist = high - mid + 1 ;
                
                if(dist % 2 == 0){
                    // as distance is even so there can't be only one element with one freq so it means right part is full of pairs
                    high = mid - 1 ;
                }
                else{ // when total element present is odd in number then it means there must be a number present with one freq in right side
                    low = mid + 2 ; // as we already compaed the mid and mid + 1 so jumping to mid + 2 for next search
                }
                
            }
        }
        
        
        return -1;
        
    }
}
