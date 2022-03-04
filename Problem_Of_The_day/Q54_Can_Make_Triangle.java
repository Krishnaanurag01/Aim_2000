package Problem_Of_The_day;

public class Q54_Can_Make_Triangle {

    int[] canMakeTriangle(int A[], int N) 
    { 
        int[] ans = new int[N-2] ;
        
        int k = 0 ; 
        for(int i = 0 ; i < N - 2 ; i++){
            int a = A[i] ;
            int b = A[i+1] ;
            int c = A[i+2] ;
            
            if(a+b > c && b+c > a &&  c + a > b){
                ans[k] = 1 ;
            }
            else{
                ans[k] = 0 ;
            }
            k++ ;
        }
        
        return ans ;
    }
    
}
