package Problem_Of_The_day;

public class Q56_Height_Using_Parent_Array {

    static int findHeight(int N, int arr[]){
        
        return helper(N-1,arr) ;// accessing from last child to top.
     }
     
     static int helper(int idx , int[] arr){
         
         if( arr[idx] == -1 ){
             return  1 ;
         }
 
         return helper(arr[idx],arr) + 1  ; 

     }
    
}
