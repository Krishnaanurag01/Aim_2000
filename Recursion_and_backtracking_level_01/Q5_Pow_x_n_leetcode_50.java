package Recursion_and_backtracking_level_01;

public class Q5_Pow_x_n_leetcode_50 {

    public double myPow(double x, int n) {
       
        if(n < 0){
            x = 1/x ;
            
            if(n==Integer.MIN_VALUE){
                if(x==1 || x==-1)
                    return 1;
                else
                    return 0;
            }
        }
        
        return func(x,Math.abs(n)) ;
       
    }
    
    public double func(double x, int n) {
        
        if(n == 0 ){
            return 1 ;
        }
        
        double rem = func(x,n/2) ;
        double cal = rem*rem ;
        
        if(n % 2 == 1){
            cal = cal * x ;
        }
        
        
        return cal ;
       
    }
    
}
