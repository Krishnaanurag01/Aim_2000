package Problem_Of_The_day ;
public class Q333_Last_modified_ball {
    
    int solve(int N, int[] A) {
        
        for(int i = A.length - 1; i >= 0 ; i--){
            if(A[i] < 9) return i+1;
        }
        
        return -1;
    }
}
