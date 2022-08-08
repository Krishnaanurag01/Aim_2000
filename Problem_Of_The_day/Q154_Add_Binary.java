package Problem_Of_The_day;

public class Q154_Add_Binary {

    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder() ;
        boolean carry = false;
        
        int i = a.length() - 1;
        int j = b.length() - 1 ;
        
        while(i >= 0 && j >= 0){
            char ch1 = a.charAt(i) ;
            char ch2 = b.charAt(j) ;
            
            if(ch1 == '1' && ch2 == '1' && carry){
                sb.insert(0,'1') ;
            }
            else if((ch1 == '1' && ch2 == '1') || (ch1 == '1' && carry ) || (ch2 == '1' && carry )){
                sb.insert(0,'0') ;
                carry = true ;
            }
            else if( carry ){
                carry = false;
                sb.insert(0,'1') ;
            }
            else if(ch2 == '1' || ch1 == '1' ){
                sb.insert(0,'1') ;
            }
            else{
                sb.insert(0,'0') ;
            }
            i--;
            j--;
        }
        
        
        while( i >= 0){
            
            char ch = a.charAt(i) ;
            if(carry && ch == '1'){
                sb.insert(0,'0') ;
            }
            else if(carry){
                sb.insert(0,'1') ;
                carry = false ;
            }
            else{
                sb.insert(0,ch) ;
            }
            i-- ;
        }
        
        while(j >= 0 ){
           char ch = b.charAt(j) ;
            if(carry && ch == '1'){
                sb.insert(0,'0') ;
            }
            else if(carry){
                sb.insert(0,'1') ;
                carry = false ;
            }
            else{
                sb.insert(0,ch) ;
            }
            j-- ;
        }
        
        if(carry){
            sb.insert(0,1) ;
        }
    
        return sb.toString() ;
    }
    
}
