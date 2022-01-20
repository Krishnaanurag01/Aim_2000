package Problem_Of_The_day;

public class Q42_Binary_number_to_decimal_number {

    public int binary_to_decimal(String str)
    {
        
        int sum = 0 ;
        int expo = 0 ;
        
        // logic : start traversing from last to 0 and when the current char is 1 then add 2^expo in sum
        for(int i = str.length() - 1 ; i >= 0 ; i--){
            char ch = str.charAt(i) ;
            
            if(ch == '1'){
                sum += Math.pow(2,expo) ;
            }
            
            expo++ ;
        }
        
        
        return sum ;
    }
    
}
