package Searching_Sorting_level_02;

public class Q20_Allocate_Books {


    //same as Q24 of searching and sorting
    public static int minPages(int[]A, int B) {
    
        if(B > A.length ) return -1 ; // when the number of students is greater than no of book then return -1 ;
    
        // finding the max page and total page in library
            int max = Integer.MIN_VALUE ;  
            int sum = 0 ;
    
            for(int val : A)
            {
                max = Math.max(max,val) ;
               sum += val ;
            }

    
            int low = max ;
            int high = sum ;
            int ans = 0 ;
    
            while(low <= high){
                int pages = low + (high - low)/2 ;
    
                int maxP = isPossible(A,B,pages) ; // getting the max pages that a student will be allocated with.
                if(maxP != -1){
                    ans = maxP ;
                    high = pages - 1 ; // for finding the smaller answer
                }
                else{
                    // high = pages - 1 ;
                    low = pages + 1 ; // for finding the larger answer
                }
            }
    
            return ans; 
      }
    
       public static int isPossible(int[] A , int s , int pages){
    
            int calS = 1 ;
            int max = 0 ;
            int sum = 0 ;
    
            for(int i = 0 ; i < A.length ; i++){
                sum += A[i];
    
                if(sum > pages){
                    calS++ ;
    
                    sum = A[i] ;
                    max = Math.max(max,sum);
                }
                else{
                    max = Math.max(max,sum);
                }
            } 
    
    // System.out.println( calS + " " + max) ;
    
    
            return calS > s ? -1 : max ;
        }
    
}
