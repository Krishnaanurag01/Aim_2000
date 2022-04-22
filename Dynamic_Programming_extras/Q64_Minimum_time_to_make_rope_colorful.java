package Dynamic_Programming_extras ;

/**
 * Q64_Minimum_time_to_make_rope_colorful
 */
public class Q64_Minimum_time_to_make_rope_colorful {



public int minCost(String colors, int[] neededTime) {
        
    int time = 0 ;
    int cmax = 0 , csum = 0 ;
    
    for(int i = 0 ; i < colors.length() ; i++){
        
        if(i > 0 && colors.charAt(i-1) != colors.charAt(i)){
            time += csum - cmax ;
            cmax = 0 ;
            csum = 0 ;
        }
        
        cmax = Math.max(cmax, neededTime[i]) ;
        csum += neededTime[i] ;
    }
    
    
    time += csum - cmax ;

    return time ;
}

}