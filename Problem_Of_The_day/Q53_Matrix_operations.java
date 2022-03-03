package Problem_Of_The_day;

public class Q53_Matrix_operations {

    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        
        int i = 0 ; 
        int j = 0 ;
        int cd = 'R' ; // current direction
        
        int[] ans = new int[2] ;
        
        
        while( i < m && i >= 0 && j >= 0  && j < n ){
            
            // System.out.println(i +" - "+ j) ;
            

            if(arr[i][j] == 1 ){
                
                arr[i][j] = 0 ;
                
                if(cd == 'R'){
                    cd = 'D' ;
                }
                else if(cd == 'D'){
                    cd = 'L' ;
                }
                else if(cd == 'L')
                {
                    cd = 'U' ;
                }
                else{
                    cd = 'R' ;
                }
            }
            
            
            //  managing indexing
            
                if(cd == 'R'){
                   j++ ; 
                }
                else if(cd == 'D'){
                    i++ ;
                }
                else if(cd == 'L')
                {
                    j-- ;
                    
                }
                else{
                    i--;
                }
                
                
                // managin last accessed index.
           
           if(i >= m || i < 0 ){
               ans[1] = j ;
           }
           else if (j >= n  || j < 0){
               ans[0] = i ;
           }
           else{
                ans[0] = i ;
                 ans[1] = j ;
           }
            
        }
        
        return ans ;
    }
    
}
