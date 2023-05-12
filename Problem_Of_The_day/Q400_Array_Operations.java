package Problem_Of_The_day ;

public class Q400_Array_Operations {
    public static int arrayOperations(int n, int[] arr) {
      
        int hasZero = 0 ;
        int subarrayCount = 0 ;
        int left = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            int val = arr[i] ;
            
            if(val == 0){
                hasZero++;
                if(left < i){
                    subarrayCount++ ;
                }
                left = i+1 ;
            }
            
        }
        
        if(left < n) subarrayCount++ ;
        
        if(hasZero == n) return 0 ;
        if(hasZero == 0) return -1 ;
        
        return subarrayCount ;
      }    
}
