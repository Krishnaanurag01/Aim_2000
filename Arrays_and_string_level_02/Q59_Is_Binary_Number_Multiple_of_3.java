package Arrays_and_string_level_02;

public class Q59_Is_Binary_Number_Multiple_of_3 {


    // steps : count 1 at odd and even position, if the difference between odd count and even count is multiple of three then the decimal equivalent number will also be multiple of 3. 

    int isDivisible(String s) {
        
        int odd = 0 ;
        int even = 0 ;
        
        for(int i = 0 ; i < s.length() ; i++ ){
            char ch = s.charAt(i) ;
            if(i % 2 == 0 && ch == '1'){
                even++ ;
            }
            else {
                
                if(ch == '1'){
                    odd++ ;
                }
                
            }
        }
         
         if((odd-even) % 3 == 0){
             return 1 ;
         }
         else{
             return 0 ;
         }
     }
    
}
