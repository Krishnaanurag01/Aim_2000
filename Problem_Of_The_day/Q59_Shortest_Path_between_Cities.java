package Problem_Of_The_day;

public class Q59_Shortest_Path_between_Cities {

    int shortestPath( int x, int y){ 
        
        int move = 0 ;
        
        int p1 = x ;
        int p2 = y ;
        
        while(p1 != p2){
            if(p1 < p2){
                move++ ;
                p2 = p2 / 2 ;
            }
            else if(p2 < p1){
                move++ ;
                p1 = p1 / 2 ;
            }
            else{
                return move ;
            }
        }
        
        return move ;
    }
    
}
