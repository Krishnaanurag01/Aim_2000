package Problem_Of_The_day;

public class Q359_Implement_Atoi {

    int atoi(String str) {
        
        boolean flag = false; 
         int ans = 0 ;
         for(char ch : str.toCharArray()){
             if(ch == '-' && flag == false && ans == 0){
                 flag = true ;
                 continue ;
             }
             int t = (int)ch;
             if(t < 48 || t > 57) return -1 ;
             ans = ans * 10 + (t - '0') ;
         }
         
         if(flag) ans *= -1 ;
         return ans ;
        }
}
