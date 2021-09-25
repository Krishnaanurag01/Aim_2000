package Dynamic_Programming_level_02;

public class Q_Painting_the_Fence {


    public static void main(String[] args) {
        
    }

    public static int get_total_ways_to_paint(int n , int k) {
        
        if(n==1){
            return k ;
        }

        int last_same = k ;
        int last_diff = k*(k-1) ;
        int total = last_diff + last_same ;

        for (int i = 3 ; i <= n ; i++) {
            last_same = last_diff ;
            last_diff = total*(k-1) ;
            total = last_diff + last_same ;
        }

        return total ; 
    }
    
}
