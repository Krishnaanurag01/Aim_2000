package Strings;

public class Q46_Long_Pressed_Name {
    
    public boolean isLongPressedName(String name, String typed) {
        
        if(name.length() > typed.length() ) return false ;
        
        int i = 0 ; 
        int j = 0 ;
        
        while( i < name.length() && j < typed.length()){
            
            if(name.charAt(i) == typed.charAt(j)){
                i++ ;
                j++ ;
            }
            else if(i > 0 && name.charAt(i-1) == typed.charAt(j)){
                j++ ;
            }
            else{
                return false ;
            }
        }
        
        while(j < typed.length()){
            if(i > 0 && name.charAt(i-1) == typed.charAt(j)){
                j++ ;
            }
            else{
                return false ;
            }
        }
        
        if(i < name.length()) return false ;
        
        return true ;
    }
}
