package Problem_Of_The_day;
import java.util.*;
public class Q75_Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = (int)1e9+7 ;
        Arrays.sort(horizontalCuts) ;
        Arrays.sort(verticalCuts) ;
        
        // find the max gap after cuts
        long hgap = horizontalCuts[0] ; // max horizontal gap after cut
        long vgap = verticalCuts[0] ;   // max vertical gap after cut
        
        // finding for horizontal
        for(int i = 1 ; i < horizontalCuts.length ; i++){
            long cut = horizontalCuts[i] ;
            long diff = (cut - horizontalCuts[i-1])%mod ;
            hgap = Math.max(hgap,diff) ;            
        }
        hgap = Math.max(hgap, ( Math.abs(h - horizontalCuts[horizontalCuts.length-1]) ) % mod ) ; // checking gap between last cut and boundary
        
        // finding for vertical
        for(int i = 1 ; i < verticalCuts.length ; i++){
            long cut = verticalCuts[i] ;
            long diff = (cut - verticalCuts[i-1])%mod ;
            vgap = Math.max(vgap,diff) ;            
        }
        vgap = Math.max(vgap, ( Math.abs(w - verticalCuts[verticalCuts.length-1]) )%mod ) ; // checking gap between last cut and boundary
        
        return (int)((hgap*vgap)%mod) ; // multiplying max horizontal gap * max vertical gap -> max area
    }
}