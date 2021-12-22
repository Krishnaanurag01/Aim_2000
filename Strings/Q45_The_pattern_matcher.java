package Strings;

public class Q45_The_pattern_matcher {
    
    public void follPatt(String s)
    {
        // Code here
        int x = 0 ;
        int y = 0 ;
        
        for(int i = 0 ; i < s.length() ; i++ ){
            char ch = s.charAt(i) ;
            
            if(ch == 'x'){
                x++ ;
                y = 0 ;
            }
            else{
                y++ ;
            }
            
            if( y > x ){
                break ;
            }
            
            if( x == y ){
                x = 0 ;
                y = 0 ;
            }
            
            
        }
        
     System.out.println(x == y ? "1" : "0");   
    }

}
