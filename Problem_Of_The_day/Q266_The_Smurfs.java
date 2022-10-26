package Problem_Of_The_day;

public class Q266_The_Smurfs {

    static int minFind(int n, String a[]){
        
        int red = 0 ;
        int blue = 0 ;
        int green = 0 ;
        
        for(String s : a){
            if(s.equals("R")){
                red++ ;
            }
            else if(s.equals("B")){
                blue++ ;
            }
            else{
                green++ ;
            }
        }
        
        if(red == n || blue == n || green == n){
            return n ;
        }
        
        if( (red % 2 == 0 && blue % 2 == 0 && green % 2 == 0) || (red % 2 == 1 && blue % 2 == 1 && green % 2 == 1) ){
            return 2 ;
        }
        
        return 1 ;
    }
}
