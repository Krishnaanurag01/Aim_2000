package Strings;

public class Q49_Zigzag_Conversion {

    public String convert(String s, int numRows) {
        
        if(numRows == 1) return s ;
        
        Character[][] arr = new Character[s.length()][s.length()] ;
        int i = 0 ;
        int j = 0 ;
        int k = 0 ;
        
        while(k < s.length()){
            
            // storing in one col for n rows
            for( i = 0 ; i < numRows && k < s.length() ; i++, k++){
                arr[i][j] = s.charAt(k) ;
            }
            
            j++ ; // as we need to store chars in crossed direction so moving to next direction.
            
            // now storing and going up with direction as i-1 and j+1
            for( i = numRows - 2 ; i > 0 && k < s.length() ; i--, k++, j++){
                arr[i][j] = s.charAt(k) ;
            }
        
        }
        
        StringBuilder sb = new StringBuilder() ;
        
        // now storing characters of each level.
        for(int m = 0 ; m < arr.length ; m++){
            for(int n = 0 ; n < arr.length ; n++){
                if(arr[m][n] == null) continue ;
                sb.append(arr[m][n]) ;
            }
            // System.out.println() ;
        }
        
        
        return sb.toString() ;
    }
}
