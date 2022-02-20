package Recursion_and_backtracking_level_02;

public class Q4_Josephus_problem {

    public int josephus(int n, int k)
    {
        
        if(n == 1){
            return n ;
        }
        
        int x = josephus(n-1,k) ; // find for n-1 
        int y = (x+k)%n ; // converting the number
        if(y==0)return n ; // this is handelling the case for 1 based indexing
        
        return y ;
    }
    
}
