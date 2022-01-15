package Arrays_and_string;

public class Q29_Add_Strings {

    public String addStrings(String num1, String num2) {
        
        int carry = 0 ;
        
        StringBuilder ans = new StringBuilder();
        
        int i  = num1.length()  - 1 ;
        int j = num2.length() - 1 ;
        
        while(i >= 0 || j >= 0 || carry > 0 ) {
            
            int val1 = i >= 0 ? num1.charAt(i) - '0' : 0 ; // taking val1 of num1
            int val2 = j >= 0 ? num2.charAt(j) - '0' : 0 ; // val2 of num2
          
            int sum = val1 + val2 + carry ;  
            
            ans.append(sum % 10); // adding last digit in sum 
            
            carry = sum/10 ;         // and sending rest to carry.
            
            i-- ;
            j-- ;
        }
        
        
        return ans.reverse().toString();
        
    }
    
}
