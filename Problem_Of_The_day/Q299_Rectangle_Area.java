package Problem_Of_The_day;
public class Q299_Rectangle_Area {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int area1 = (ax2 - ax1) * (ay2 - ay1) ;
        int area2 = (bx2 - bx1) * (by2 - by1) ;
        
        // finding dimention of common area.
        
        // this is bottom left dimention.
        int cx1 = Math.max(ax1, bx1) ;
        int cx2 = Math.min(ax2, bx2) ;
        
        // this is top right dimention.
        int cy1 = Math.max(ay1, by1) ;
        int cy2 = Math.min(ay2, by2) ;
        
        int x = cx2 - cx1 ; // now finding x length
        int y = cy2 - cy1 ; // now finding y length
        int common_area = 0 ;
        
        if(x > 0 && y > 0){ // if both has positive value then it means the common area exist.
            common_area = x * y ;
        }
        
        // sum of both area - common area.
        return area1 + area2 - common_area ;
    }
    
}