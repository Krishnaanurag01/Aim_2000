package Problem_Of_The_day;

public class Q90_Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate {

    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int idx = -1 ;
        int mdsf = (int)1e9 ;  // manhatten distance so far.
        
        for(int i = 0 ; i < points.length ; i++){
            int[] point = points[i] ;
            int x2 = point[0] ;
            int y2 = point[1] ;
            
            if(x == x2 || y == y2){
                int md = Math.abs(x - x2) + Math.abs(y - y2) ;
                if(md < mdsf){
                    mdsf = md ;
                    idx = i ;
                }
            }
        }
        return idx ;
    }
}
