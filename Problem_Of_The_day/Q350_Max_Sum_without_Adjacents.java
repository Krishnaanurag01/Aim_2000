package Problem_Of_The_day;

public class Q350_Max_Sum_without_Adjacents {
    
    int findMaxSum(int arr[], int n) {
        
        int p = 0 ;
        int np = 0 ;
        
        for(int val : arr){
            int tp = np + val ;
            int tnp = Math.max(np, p) ;
            p = tp ;
            np = tnp ;
        }
        
        return Math.max(p,np) ;
    }
}
