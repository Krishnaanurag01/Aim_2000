package Problem_Of_The_day;

public class Q386_Count_the_Substrings {

    
    int countSubstring(String S) 
    { 
        int ans = 0 ;
        
        for(int i = 0 ; i < S.length() ; i++){
               int small = 0;
               int large = 0;
               for(int j = i ; j < S.length() ; j++){
                   if(Character.isLowerCase(S.charAt(j))){
                       small++ ;
                   }
                   else{
                       large++ ;
                   }
                   if(small == large) ans++ ;
               }
        }
        
        return ans ;
    }
}
