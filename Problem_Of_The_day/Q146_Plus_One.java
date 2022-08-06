package Problem_Of_The_day;

public class Q146_Plus_One {

    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
     for(int i=n-1; i>=0; i--) {
         if(digits[i] < 9) {
             digits[i]++;
             return digits;
         }
         
         digits[i] = 0;
     }
     
     int[] newNumber = new int [n+1];
     newNumber[0] = 1;
     
     return newNumber;
     }

     // 2nd method using stringbuilder


     public int[] plusOne2(int[] digits) {
        
        StringBuilder sb = new StringBuilder() ;
        
        boolean flag = false;
        boolean carry = false;
        
        for(int i = digits.length - 1 ; i >=0 ; i--){
            int val = digits[i] ;
            if(flag == false){
                // System.out.println(val) ;
                if(val != 9){
                    flag = true ;
                    sb.insert(0,val+1) ;
                }
                else if(val == 9){
                    flag = true ;
                    sb.insert(0,0);
                    carry = true;
                }
            }
            else if(carry == true){
                                // System.out.println(val) ;

                if(val == 9){
                    sb.insert(0,0);
                }
                else{
                    sb.insert(0,val + 1);
                    carry = false;
                }
            }
            else{
                                // System.out.println(val) ;

                sb.insert(0,val) ;
            }
        }
        
        if(carry) sb.insert(0,1) ;
        // System.out.println(sb) ;
        
        int[] ans = new int[sb.length()] ;
        int k = 0 ;
        for(int i = 0 ; i < sb.length() ; i++){
            ans[k++] = sb.charAt(i) - '0' ;
        }
        
        return ans ;
    }
     
}
